#!/usr/bin/env python3
# Copyright (c) 2026 Wind River Systems, Inc.
#
# Generate SKIP_RECIPE entries for recipes that cannot be built because something they
# (transitively) depend on is not available, so that "bitbake world" - and with it
# yocto-check-layer's test_world - doesn't stop on unresolved dependencies.
#
# Two steps, because the second step needs the result of two different configurations:
#
#  1. dump: run inside a bitbake build directory (oe-init-build-env), once with only the layers
#     that are always present ("minimal": oe-core, meta-oe, meta-python, ... plus the meta-ros
#     layers) and once with every optional layer too (meta-qt5, meta-qt6, meta-python-ai, ...,
#     "full"):
#
#       generate-world-skips.py dump OUT.json
#
#  2. generate: combine the two dumps and print the include file for a distro layer:
#
#       generate-world-skips.py generate MINIMAL.json FULL.json > ros-distro-recipe-unavailable.inc
#
# A recipe that is unbuildable in both configurations is skipped unconditionally (through the
# "unavailable" group, which is in ROS_WORLD_SKIP_GROUPS unless the user removes it). A recipe
# that is only unbuildable in the minimal configuration is skipped when one of the optional layers
# that provides what it is missing is not in BBFILE_COLLECTIONS.
#
# Recipes that already have a SKIP_RECIPE entry are parsed as skipped, so they are not in the
# dump and don't get a second entry.

import json
import os
import re
import sys


def dump(out):
    import bb.tinfoil

    with bb.tinfoil.Tinfoil() as tinfoil:
        tinfoil.prepare(config_only=False)
        rc = tinfoil.cooker.recipecaches['']
        layers = {}
        for coll, pattern in (tinfoil.config_data.getVar('BBFILE_COLLECTIONS') and
                              [(c, tinfoil.config_data.getVar('BBFILE_PATTERN_' + c))
                               for c in tinfoil.config_data.getVar('BBFILE_COLLECTIONS').split()]):
            layers[coll] = pattern.lstrip('^')

        def layer_of(fn):
            best = ('', None)
            for coll, path in layers.items():
                if fn.startswith(path) and len(path) > len(best[0]):
                    best = (path, coll)
            return best[1]

        data = {}
        for fn, pn in rc.pkg_fn.items():
            if pn.endswith('-native') or pn.endswith('-nativesdk') or pn.startswith('nativesdk-'):
                pass
            rundeps = set()
            for pkg, deps in rc.rundeps[fn].items():
                rundeps.update(deps)
            for pkg, deps in rc.runrecs[fn].items():
                pass  # recommends are optional
            entry = data.setdefault(fn, {})
            entry.update({
                'pn': pn,
                'layer': layer_of(fn),
                'depends': sorted(set(rc.deps[fn])),
                'rundeps': sorted(rundeps),
                'provides': sorted(set(rc.fn_provides.get(fn, [])) | {pn}),
                'packages': sorted(set(rc.packages_for_fn(fn)) if hasattr(rc, 'packages_for_fn') else
                                   [p for p, fns in rc.packages.items() if fn in fns]),
                'rprovides': sorted({p for p, fns in rc.rproviders.items() if fn in fns}),
            })
        # which collection provides which name (build and runtime), for the "full" run
        assume = tinfoil.config_data.getVar('ASSUME_PROVIDED').split()
        dynamic = sorted(rc.packages_dynamic.keys()) if hasattr(rc, 'packages_dynamic') else []
        json.dump({'layers': layers, 'recipes': data, 'assume_provided': assume, 'dynamic': dynamic},
                  open(out, 'w'))


def resolve(dump_data):
    """Return (pn -> set of root causes, i.e. names nothing provides) for every unbuildable pn."""
    recipes = dump_data['recipes']
    providers = {}
    rproviders = {}
    for fn, r in recipes.items():
        for p in r['provides']:
            providers.setdefault(p, set()).add(fn)
        for p in r['packages'] + r['rprovides']:
            rproviders.setdefault(p, set()).add(fn)
    assume = set(dump_data.get('assume_provided', []))
    dynamic = [re.compile(d) for d in dump_data.get('dynamic', [])]

    def satisfied(dep, fns):
        # (list of providers, True if the dependency is provided by something outside the recipes)
        return dep in assume or any(d.match(dep) for d in dynamic)

    bad = {}  # fn -> set(root causes)
    changed = True
    while changed:
        changed = False
        for fn, r in recipes.items():
            causes = set()
            for dep in r['depends']:
                fns = providers.get(dep, set())
                good = [f for f in fns if f not in bad]
                if not good and not satisfied(dep, fns):
                    causes |= {dep} if not fns else set().union(*(bad[f] for f in fns))
            for dep in r['rundeps']:
                fns = rproviders.get(dep, set()) | providers.get(dep, set())
                good = [f for f in fns if f not in bad]
                if not good and not satisfied(dep, fns):
                    causes |= {dep} if not fns else set().union(*(bad[f] for f in fns))
            if causes and bad.get(fn) != causes:
                bad[fn] = causes
                changed = True
    return bad, recipes


def generate(minimal_json, full_json):
    minimal = json.load(open(minimal_json))
    full = json.load(open(full_json))
    bad_min, rec_min = resolve(minimal)
    bad_full, rec_full = resolve(full)
    # names provided in the full configuration, and by which layer / recipe
    prov_layer = {}
    prov_pn = {}
    for fn, r in rec_full.items():
        for p in r['provides'] + r['packages'] + r['rprovides']:
            prov_layer.setdefault(p, set()).add(r['layer'])
            prov_pn.setdefault(p, set()).add(r['pn'])
    bad_full_pn = {rec_full[fn]['pn'] for fn in bad_full}

    out = []
    out.append('# Generated by scripts/generate-world-skips.py: recipes that cannot be built because something they')
    out.append('# depend on is not available. Regenerate it after regenerating the recipes.')
    out.append('')
    out.append('ROS_WORLD_SKIP_GROUPS += "unavailable"')
    out.append('')
    entries = {}
    for fn, causes in sorted(bad_min.items(), key=lambda kv: rec_min[kv[0]]['pn']):
        pn = rec_min[fn]['pn']
        if pn.endswith('-native') or pn.endswith('-nativesdk') or pn.startswith('nativesdk-'):
            continue
        if pn in bad_full_pn or any(c not in prov_layer for c in causes):
            # not buildable even with every optional layer: nothing provides something it needs
            missing = sorted(c for c in causes if c not in prov_layer) or sorted(causes)
            entries[pn] = (None, 'depends on %s' % ', '.join(missing[:3]))
            continue
        layers = sorted({l for c in causes for l in prov_layer[c] if l})
        pns = sorted({p for c in causes for p in prov_pn[c]})
        entries[pn] = ((layers, pns), 'depends on %s' % ', '.join(sorted(causes)[:3]))
    for pn, (cond, reason) in sorted(entries.items()):
        reason = reason.replace("'", '').replace('"', '')
        if cond is None:
            out.append('SKIP_RECIPE[%s] ?= "${@bb.utils.contains(\'ROS_WORLD_SKIP_GROUPS\', \'unavailable\', \'%s\', \'\', d)}"' % (pn, reason))
        else:
            layers, pns = cond
            ls = ', '.join("'%s'" % l for l in layers)
            ps = ', '.join("'%s'" % p for p in pns)
            out.append('SKIP_RECIPE[%s] ?= "${@\'%s\' if (any(l not in d.getVar(\'BBFILE_COLLECTIONS\').split() for l in [%s]) or any(d.getVarFlag(\'SKIP_RECIPE\', p) for p in [%s])) else \'\'}"' % (pn, reason, ls, ps))
    print('\n'.join(out))


if __name__ == '__main__':
    if len(sys.argv) == 3 and sys.argv[1] == 'dump':
        dump(sys.argv[2])
    elif len(sys.argv) == 4 and sys.argv[1] == 'generate':
        generate(sys.argv[2], sys.argv[3])
    else:
        sys.exit(__doc__)
