# `yocto-check-layer` Results — 2026-08-21

Produced for Milestone 3, Task M3-1 of
[`meta-ros-audit-remediation-spec.md`](meta-ros-audit-remediation-spec.md) (audit ref §4). This
converts that section's "unknown — needs environment" row into concrete findings.

This was a three-round investigation within the same session, each round peeling back one blocking
layer to reveal the next:

1. **Round 1** — fatal `LICENSE`-format QA errors in 40 `meta-ros-common` recipes. **Fixed.**
2. **Round 2** — `python3-junitparser` needed a `python_uv_build.bbclass` that doesn't exist on
   wrynose. **Fixed** (by the user, directly).
3. **Round 3** — two further findings, neither fixed here: `meta-ros-common`'s `boost` bbappend
   causes large-scale signature changes in unrelated recipes (expected/likely-permanent, not a
   bug), and `suitesparse-{cholmod,config,spqr}` unconditionally depend on `openblas`, which is
   only provided by the optional `meta-python-ai` dynamic layer (a real inconsistency).

Raw logs for every run in all three rounds are archived at
`/opt/meta-ros-remediation-handoff/yocto-check-layer-logs-2026-08-21/` (outside this repo, not
committed — `/tmp` on this machine is a `tmpfs` that doesn't survive a reboot, so the scratch copies
were moved to persistent disk during the session).

## Summary

| Layer | Result | Why |
|---|---|---|
| `meta-ros-common` | **FAIL** | `test_parse` now passes (rounds 1+2 fixes confirmed). Fails on: a patch missing `Upstream-Status:`, no `SECURITY.md`, and `test_signatures`/`test_world`/`test_world_inherit_class` due to the `boost` bbappend's large (likely permanent, likely acceptable) signature fan-out. Full 9-test suite ran. |
| `meta-ros1` | FAIL | Round 1+2 blockers cleared; now fails at the `world` signature stage on a *new*, different issue: `suitesparse-*` unconditionally `DEPENDS` on `openblas`, which only exists when the optional `meta-python-ai` layer is added — not part of this test environment's base layer set. |
| `meta-ros2`, `meta-ros1-noetic`, `meta-ros2-humble`, `meta-ros2-jazzy`, `meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`, `meta-spaceros-jazzy` | FAIL (blocked, not re-verified in round 3) | All depend on `meta-ros-common` (directly or via `meta-ros2`), so all will hit the same `openblas`/`suitesparse` issue at the same `world`-signature stage — established mechanism, not individually re-confirmed for these 9 in round 3 (see below). |

All 11 layers still fail overall, but the *reason* has moved twice: parse-level blockers (rounds 1
and 2) are now cleared for the layers that were re-tested; the current blocker (round 3) is a
`world`-resolution issue, one level further into the check than before.

## Round 1 — fixed: malformed `LICENSE` fields in `meta-ros-common`

`meta-ros-common` is edited directly (it's the one layer without a `recipes-bbappends` directory —
see `AGENTS.md`), and 40 of its hand-authored recipes set `LICENSE` using the English words `AND`
/ `OR` as separators between multiple license identifiers, e.g.:

```
LICENSE = "EPL-1.0 AND LicenseRef-EPL-2.0-or-later"
LICENSE = "FreeImage OR GPL-2.0-or-later OR GPL-3.0-or-later"
```

OE-core's `LICENSE` syntax requires `&` (all apply), `|` (choice), or parentheses for grouping —
not the literal words `AND`/`OR`. This trips a **fatal QA error** (`license-format`) that halts
bitbake's recipe parsing entirely for anything that pulls in `meta-ros-common` — which is all 10
other meta-ros layers, since each declares `ros-common-layer` in its `LAYERDEPENDS`.

**Context that resolved this quickly:** the user pointed to
[ros-infrastructure/superflore#327](https://github.com/ros-infrastructure/superflore/pull/327),
an in-flight PR (open/draft, user is a reviewer on it) doing the *opposite* migration — changing
superflore's recipe generator to emit `AND` instead of `&`, because the SPDX spec has deprecated
`&`. Per the user's own review comment on that PR, applying it globally "would break support for
Scarthgap and Wrynose," so it was scoped to Blacksail-and-later only. Since this branch's
`LAYERSERIES_COMPAT` is `wrynose`, and wrynose's bitbake confirmed-in-practice does not accept
`AND`/`OR`, the correct move on this branch right now is the old syntax. These `meta-ros-common`
recipes aren't superflore output (no generation header, consistent with the direct-edit
convention) — someone had apparently hand-migrated them to the newer SPDX-preferred syntax ahead
of the tooling that will eventually support it here.

**Fix applied:** reverted `AND`/`OR` back to `&`/`|` in all 40 affected recipes across
`recipes-devtools/{coinor,cppcheck,dartsim,gazebo-classic,gazebo,ogre-next,python}/` and
`recipes-support/{gdal,ode,pagmo,zziplib}/`. Confirmed clean by re-running `yocto-check-layer`
against `meta-ros-common` twice — zero remaining `QA Issue: ... license-format` errors.

## Round 2 — fixed (by the user): `python_uv_build.bbclass` unavailable on wrynose

With the `LICENSE` errors cleared, `meta-ros-common`'s parse got further and hit a new fatal error:

```
ERROR: ParseError at meta-ros-common/recipes-devtools/python3-junitparser/python3-junitparser_5.0.1.bb:14:
    Could not inherit file classes/python_uv_build.bbclass
```

`python3-junitparser_5.0.1.bb` had `inherit python_uv_build ptest-python-pytest`. Checked upstream
(`junitparser`'s `pyproject.toml` at the pinned `SRCREV`): it genuinely declares
`build-backend = "uv_build"`, so the recipe's `inherit` was *correct* for the package — the problem
was environmental. This wrynose-era `openembedded-core` has no `python_uv_build.bbclass`, but does
have both of that class's own dependencies already: `python_pep517.bbclass` (complete, present) and
`python3-uv-build_0.10.10.bb` (with `BBCLASSEXTEND = "native"`, so `python3-uv-build-native`
resolves). Confirmed the actual upstream `python_uv_build.bbclass` (present on OE-core's bleeding
edge `master`, but not even on `whinlatter`, the release right after wrynose) is a trivial 3-line
wrapper: `inherit python_pep517` + `DEPENDS += "python3-uv-build-native"`.

Given all the real dependencies were already present, this was a much lower-risk fix than it first
looked — proposed vendoring the 3-line wrapper as its own `classes/python_uv_build.bbclass` in
`meta-ros-common`, verbatim from OE-core master (MIT-licensed). **The user instead fixed it more
simply themselves**, inlining the two effective lines directly into the recipe rather than adding a
new class file:

```diff
-inherit python_uv_build ptest-python-pytest
+inherit python_pep517 ptest-python-pytest
+
+DEPENDS += "python3-uv-build-native"
```

Confirmed: `meta-ros-common`'s `test_parse` now passes cleanly.

## Round 3 — two further findings, not fixed here

### 3a. `meta-ros-common`'s `boost` bbappend causes large-scale signature changes — likely expected, not a bug

With rounds 1+2 fixed, `meta-ros-common` still fails `test_signatures`, `test_world`, and
`test_world_inherit_class`:

```
AssertionError: Adding layer meta-ros-common changed signatures.
30796 signatures changed, initial differences (first hash before, second after):
   boost-native:do_create_recipe_spdx: ...
   boost-native:do_deploy_source_date_epoch: ...
   boost:do_deploy_source_date_epoch: ...
```

Root cause: `meta-ros-common/recipes-support/boost/boost_%.bbappend` adds `inherit python3native`
and `DEPENDS += "python3-numpy-native"` to `boost`, to enable the Boost.Python/Boost.NumPy bindings
ROS packages need. `boost`/`boost-native` are foundational, widely-depended-upon OE-core recipes,
so any real modification to them ripples through the signature of nearly everything that transitively
depends on `boost-native` — hence ~30.8K changed signatures from one bbappend.

**This is very likely expected and acceptable, not a defect.** Bbappending a shared recipe to add a
`PACKAGECONFIG`/dependency a project genuinely needs is a completely standard Yocto pattern; the
`test_signatures` check's design intent is to catch layers with an unexpectedly broad, incidental
footprint (e.g. a stray global `DISTRO_FEATURES` append), not to forbid this. `meta-ros-common` will
likely never cleanly pass `test_signatures`/`test_world_inherit_class` in the strict sense as long
as this bbappend exists — which is presumably permanent, since removing it would break real
Boost.Python/NumPy functionality ROS packages depend on. Flagging for awareness, not as an
actionable fix.

### 3b. `suitesparse-{cholmod,config,spqr}` unconditionally depend on `openblas`, an optional-layer-only package

Re-testing `meta-ros1` (rounds 1+2 fixes both confirmed cleared for it too) hit a new, different
`world`-resolution failure:

```
ERROR: Nothing PROVIDES 'openblas' (but meta-ros-common/recipes-extended/suitesparse/suitesparse-cholmod_5.2.1.bb,
  suitesparse-spqr_4.3.3.bb, suitesparse-config_7.7.0.bb DEPENDS on or otherwise requires it).
ERROR: Required build target 'meta-world-pkgdata' has no buildable providers.
Missing or unbuildable dependency chain was: ['meta-world-pkgdata', 'ceres-solver', 'suitesparse-cholmod', 'openblas']
```

This traces directly back to the `dynamic-layers` mechanism documented in Milestone 1 (`README.md`'s
own table, from task M1-1): `openblas` is only provided by the **optional**
[`meta-python-ai`](https://github.com/zboszor/meta-python-ai) layer — it isn't in `meta-openembedded`
or `openembedded-core` at all (confirmed by searching both trees). But
`meta-ros-common/recipes-extended/suitesparse/{suitesparse-cholmod_5.2.1.bb,
suitesparse-config_7.7.0.bb, suitesparse-spqr_4.3.3.bb}` are **not** under `dynamic-layers/` — they're
regular, always-active recipes, and `suitesparse-config` unconditionally sets `DEPENDS = "openblas"`.

This is inconsistent with how the *same repo* handles the identical situation correctly elsewhere:
`meta-ros-common/recipes-support/ipopt/ipopt_3.14.16.bb` gates its own `openblas` `PACKAGECONFIG`
behind the optional layer's presence:

```
PACKAGECONFIG ??= "${@bb.utils.contains('BBFILE_COLLECTIONS', 'meta-python-ai', 'openblas', '', d)}"
```

**Practical effect:** any integrator who follows the documented, normal path — meta-ros layers only,
without opting into the optional `meta-python-ai` layer — gets a hard, unresolvable dependency
failure trying to build `world` (or anything pulling in these three `suitesparse` recipes), because
nothing provides `openblas` in that configuration. This isn't a "some Yocto series doesn't have it
yet" issue like rounds 1–2; it's a same-repo inconsistency between the documented optionality
contract and the actual recipe dependencies.

**Not fixed here** — the right resolution needs a maintainer call between (at least) two approaches,
each with different implications:
- Gate `suitesparse-{cholmod,spqr}`'s `openblas` usage the same way `ipopt` does (a `PACKAGECONFIG`
  conditional on `meta-python-ai`'s presence) — but this changes what these recipes *build* when
  `meta-python-ai` isn't present (would need to confirm `openblas` isn't load-bearing for their core
  functionality, only an optional acceleration path).
- Relocate these three recipes under `meta-ros-common/dynamic-layers/meta-python-ai/`, matching the
  existing `openblas`-bbappend precedent already there — but this makes `suitesparse` support itself
  conditional on the optional layer, which may not match how downstream `ceres-solver`/other
  consumers expect to find it.

**Further investigation was intentionally not pursued to completion:** the optional
`meta-python-ai` layer itself additionally depends on a `virtualization-layer` collection
(`meta-virtualization`, not cloned in this environment) per its own `LAYERDEPENDS` — adding
`meta-python-ai` to get a fuller signal on `meta-ros1` would have meant pulling in yet another
layer, which was judged to be beyond this task's reasonable scope (M3-1's job is to produce the
results record, not build out every optional-layer combination). `meta-python-ai` was cloned
(`wrynose` branch, confirmed to exist and declare `LAYERSERIES_COMPAT = "wrynose"`) but never added
to `bblayers.conf` for this reason.

## What was and wasn't re-verified across all three rounds

- **Re-verified through all three rounds:** `meta-ros-common` (parse clean, patches/security/
  signature findings all reconfirmed), `meta-ros1` (parse clean, now blocked on the
  `openblas`/`suitesparse` issue instead).
- **Not re-verified since round 1:** `meta-ros2`, `meta-ros1-noetic`, `meta-ros2-humble`,
  `meta-ros2-jazzy`, `meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`,
  `meta-spaceros-jazzy`. Each depends on `meta-ros-common` (directly or via `meta-ros2`), so each
  will hit the same `openblas`/`suitesparse` `world`-resolution failure `meta-ros1` did — this
  follows directly from `LAYERDEPENDS` and the confirmed mechanism, but wasn't individually
  reconfirmed for these 9 in round 3.

**Note on environment hygiene:** `yocto-check-layer` does not reliably restore `bblayers.conf` to
its pre-run state after a normal (non-interrupted) completion — a prior run's dependency-layer
additions were found still present in `bblayers.conf` at the start of a later, unrelated invocation
in this session, causing that layer to be silently `SKIPPED` rather than tested. Worth resetting
`bblayers.conf` to the intended base set before each invocation rather than assuming it's clean.

## `meta-ros-common` — full results (final, all fixes applied)

| Test | Result | Detail |
|---|---|---|
| `test_layerseries_compat` | ok | |
| `test_parse` (`bitbake -p`) | **ok** | Fixed in rounds 1+2. |
| `test_patches_upstream_status` | FAIL | 1 patch with malformed/missing `Upstream-Status:`: `recipes-devtools/gazebo/ignition-rendering6/ign-gz-namespace-migration.patch`. |
| `test_readme` | ok | |
| `test_security` | FAIL | No `SECURITY.md` in the layer. Not a checklist item the original audit (§4) checked for; `yocto-check-layer` enforces it directly, so this is new information regardless. |
| `test_show_environment` | ok | |
| `test_signatures` | FAIL | `boost` bbappend's large signature fan-out — see 3a, likely expected/permanent. |
| `test_world` | ERROR | Same underlying cause as `test_signatures`. |
| `test_world_inherit_class` | FAIL | Same underlying cause. |

`Ran 9 tests in 468.996s`.

## The other 10 layers — blocked on the round-3 finding, not yet individually verifiable

Their own layer-specific compliance (patch upstream-status, README format, `SECURITY.md`, etc.) is
still unverified. Three rounds in, the blocking mechanism is now well-understood (a same-repo
`openblas`/`suitesparse`/`meta-python-ai` dependency-gating inconsistency) rather than "no
environment available" or "wrong Yocto series" — but a clean run across all 10 needs that
inconsistency resolved (or the optional layer chain fully built out) first.

## Environment used

- [`bitbake-setup`](https://docs.yoctoproject.org/dev/brief-yoctoprojectqs/index.html#install-and-use-bitbake-setup)
  (PyPI package `bitbake-setup`, v2.19.0), config `poky-wrynose` (Yocto 6.0, matching this branch's
  `LAYERSERIES_COMPAT`), bitbake variant `poky`, `distro/poky`, `machine/qemux86-64`.
- Location: `/opt/meta-ros-remediation-handoff/yocto-wrynose/` — a poky/OE-core tree, outside this
  repo checkout and not committed.
- Additional layers needed to satisfy meta-ros's `LAYERDEPENDS` (`meta-python`,
  `openembedded-layer`): `meta-openembedded` cloned at its `wrynose` branch, with `meta-oe` and
  `meta-python` added to `bblayers.conf`.
- `meta-python-ai` (`wrynose` branch) was cloned but **not** added to `bblayers.conf` — see 3b.
- Host note: every run printed
  `WARNING: Host distribution "elxr-26.04" has not been validated with this version of the build
  system` — informational only, not treated as a failure.
- Raw logs for all runs across all three rounds: `/opt/meta-ros-remediation-handoff/yocto-check-layer-logs-2026-08-21/`.

## Commands used

```sh
source <poky-wrynose-build>/init-build-env build

# meta-ros-common tested alone (no meta-ros dependencies of its own):
yocto-check-layer --dependency <meta-oe> <meta-python> \
  -o meta-ros-common.log <path-to-meta-ros-common>

# Each other layer tested individually against its already-verified ancestors,
# using --no-auto-dependency so ancestors are made available to satisfy
# LAYERDEPENDS without being independently re-tested as their own target
# (yocto-check-layer's default behavior would otherwise re-run every
# dependency layer's full suite on every invocation):
yocto-check-layer --no-auto-dependency \
  --dependency <meta-oe> <meta-python> <meta-ros-common> [<meta-ros1-or-meta-ros2>] \
  -o <layer>.log <path-to-layer>
```

Dependency chain used per layer (from each layer's `LAYERDEPENDS`):
- `meta-ros1`, `meta-ros2` → `meta-ros-common`
- `meta-ros1-noetic` → `meta-ros-common`, `meta-ros1`
- `meta-ros2-humble`, `meta-ros2-jazzy`, `meta-ros2-kilted`, `meta-ros2-lyrical`,
  `meta-ros2-rolling`, `meta-spaceros`, `meta-spaceros-jazzy` → `meta-ros-common`, `meta-ros2`
