# `yocto-check-layer` Results — 2026-08-21

Produced for Milestone 3, Task M3-1 of
[`meta-ros-audit-remediation-spec.md`](meta-ros-audit-remediation-spec.md) (audit ref §4). This
converts that section's "unknown — needs environment" row into concrete findings.

This is a two-round investigation within the same session: the first round found a fatal
`LICENSE`-format QA error blocking every layer, which turned out to be fixable and was fixed; the
second round (after that fix) found a second, distinct blocker that is **not** fixed here.

## Summary

| Layer | Result | Why |
|---|---|---|
| `meta-ros-common` | **FAIL** | Blocked by a missing `python_uv_build.bbclass` (see below); also a patch missing `Upstream-Status:`, and no `SECURITY.md`. Full test suite ran (see below). |
| `meta-ros1` | FAIL (blocked) | Never reached its own test suite — aborted at the signature baseline due to `meta-ros-common`'s parse blocker. |
| `meta-ros2` | FAIL (blocked, unconfirmed post-fix) | Confirmed blocked before the LICENSE fix; not individually re-run after it (see caveat below). |
| `meta-ros1-noetic` | FAIL (blocked, unconfirmed post-fix) | Same. |
| `meta-ros2-humble` | FAIL (blocked, unconfirmed post-fix) | Same. |
| `meta-ros2-jazzy` | FAIL (blocked, unconfirmed post-fix) | Same. |
| `meta-ros2-kilted` | FAIL (blocked, unconfirmed post-fix) | Same. |
| `meta-ros2-lyrical` | FAIL (blocked, unconfirmed post-fix) | Same. |
| `meta-ros2-rolling` | FAIL (blocked, unconfirmed post-fix) | Same. |
| `meta-spaceros` | FAIL (blocked, unconfirmed post-fix) | Same. |
| `meta-spaceros-jazzy` | FAIL (blocked, unconfirmed post-fix) | Same. |

All 11 layers currently fail. `meta-ros1` was re-tested after the `LICENSE` fix and hits the same
new blocker as `meta-ros-common`, confirming the cascade is still in effect — the other 9 were not
individually re-run a second time (see "What was and wasn't re-verified" below), since re-running
them would burn a lot of wall-clock time to reconfirm the same already-understood mechanism rather
than surface new information.

## Round 1 — root cause found and fixed: malformed `LICENSE` fields in `meta-ros-common`

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

**Fix applied (commit follows this doc):** reverted `AND`/`OR` back to `&`/`|` in all 40 affected
recipes across `recipes-devtools/{coinor,cppcheck,dartsim,gazebo-classic,gazebo,ogre-next,python}/`
and `recipes-support/{gdal,ode,pagmo,zziplib}/`. Confirmed by re-running `yocto-check-layer`
against `meta-ros-common` twice (once after the first batch of 39, which surfaced one more —
`freeimage` — that bitbake hadn't reached yet before halting; then again after that one too) —
zero remaining `QA Issue: ... license-format` errors in either run.

## Round 2 — new blocker found: `python_uv_build.bbclass` unavailable on wrynose

With the `LICENSE` errors cleared, `meta-ros-common`'s parse gets further and hits a new, distinct
fatal error:

```
ERROR: ParseError at meta-ros-common/recipes-devtools/python3-junitparser/python3-junitparser_5.0.1.bb:14:
    Could not inherit file classes/python_uv_build.bbclass
```

`python3-junitparser_5.0.1.bb` has `inherit python_uv_build ptest-python-pytest`. Checked upstream
(`junitparser`'s `pyproject.toml` at the pinned `SRCREV`): it genuinely declares
`build-backend = "uv_build"` — so the recipe's `inherit` is *correct* for the package. The problem
is environmental: this wrynose-era `openembedded-core` checkout has no `python_uv_build.bbclass` at
all (confirmed by searching the whole checkout — only unrelated `uv_build`-version-bump patches for
an unrelated recipe, `python3-cryptography-vectors`, turned up). The closest analogous class present
is `python_setuptools_build_meta.bbclass`, but that's a different build backend than what
`junitparser` actually declares, so swapping to it would be a real behavior change, not a
same-meaning syntax revert like the `LICENSE` fix — **not applied here.**

This looks like the same underlying pattern as Round 1: a recipe written against tooling from a
newer OE-core generation than wrynose currently ships, landed on this `wrynose`-targeting branch
before the target environment could support it. Plausible resolutions (none applied, all need a
maintainer call, not a unilateral guess):
- Backport/vendor a `python_uv_build.bbclass` compatible with wrynose's OE-core (real, nontrivial
  work — would need real `uv` build-backend knowledge to get right).
- Pin `python3-junitparser` to an older release that used a supported build backend, if one exists.
- Leave it broken on `wrynose` until this repo's `master` moves to whichever Yocto series ships
  native `uv_build` support, and treat this as a `wrynose`-specific known issue in the interim.

This is now **the** active blocker on `meta-ros-common`'s (and therefore every other layer's) parse
— confirmed by re-testing `meta-ros1` after the `LICENSE` fix, which hit the identical
`python_uv_build.bbclass` error at the same "Getting initial signatures" stage.

## What was and wasn't re-verified after the `LICENSE` fix

- **Re-verified:** `meta-ros-common` (twice — confirmed `LICENSE` errors gone, confirmed the new
  `python_uv_build` blocker), `meta-ros1` (confirmed it hits the same new blocker, proving the
  cascade mechanism is unchanged in kind, just in current root cause).
- **Not re-verified:** `meta-ros2`, `meta-ros1-noetic`, `meta-ros2-humble`, `meta-ros2-jazzy`,
  `meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`,
  `meta-spaceros-jazzy`. Each depends on `meta-ros-common` (directly or via `meta-ros2`), so each
  will hit the same `python_uv_build.bbclass` error at the same baseline stage — this follows
  directly from `LAYERDEPENDS` and was true of every layer tested pre-fix, but it was not
  individually re-confirmed for these 9 specifically after the `LICENSE` fix landed.

## `meta-ros-common` — full results (round 2, post-`LICENSE`-fix)

`meta-ros-common` has no meta-ros-internal dependencies of its own, so it was tested standalone and
ran its complete 9-test suite before hitting the (now different) parse blocker:

| Test | Result | Detail |
|---|---|---|
| `test_layerseries_compat` | ok | |
| `test_parse` (`bitbake -p`) | ERROR | `python_uv_build.bbclass` missing, see above. |
| `test_patches_upstream_status` | FAIL | 1 patch with malformed/missing `Upstream-Status:`: `recipes-devtools/gazebo/ignition-rendering6/ign-gz-namespace-migration.patch` — unchanged from round 1. |
| `test_readme` | ok | |
| `test_security` | FAIL | No `SECURITY.md` in the layer — unchanged from round 1. Not a checklist item the original audit (§4) checked for; `yocto-check-layer` enforces it directly, so this is new information regardless. |
| `test_show_environment` | ok | |
| `test_signatures` | ERROR | Cascades from the `python_uv_build` parse blocker. |
| `test_world` | ERROR | Cascades from the `python_uv_build` parse blocker. |
| `test_world_inherit_class` | FAIL | Cascades from the `python_uv_build` parse blocker. |

`Ran 9 tests in 127.435s — FAILED` (same shape as round 1's `Ran 9 tests in 244.133s — FAILED
(failures=3, errors=3, skipped=2)`; the patch and `SECURITY.md` findings are independent of both
parse blockers and hold regardless of which one is currently active).

## The other 10 layers — blocked, not yet individually verifiable

Their own layer-specific compliance (patch upstream-status, README format, `SECURITY.md`, etc.) is
still unverified — the same "unknown" status the original audit left it in. Two rounds in, it's now
understood to be blocked on specific, identified root causes (first `LICENSE` format, now
`python_uv_build`) rather than "no environment available," but a clean run across all 10 still
needs the `python_uv_build` gap resolved first.

**Next step once `python_uv_build.bbclass` is resolved for wrynose:** re-run this same check per
layer (commands below) to get real per-layer results for all 10.

## Environment used

- [`bitbake-setup`](https://docs.yoctoproject.org/dev/brief-yoctoprojectqs/index.html#install-and-use-bitbake-setup)
  (PyPI package `bitbake-setup`, v2.19.0), config `poky-wrynose` (Yocto 6.0, matching this branch's
  `LAYERSERIES_COMPAT`), bitbake variant `poky`, `distro/poky`, `machine/qemux86-64`.
- Location: `/opt/meta-ros-remediation-handoff/yocto-wrynose/` — a poky/OE-core tree, outside this
  repo checkout and not committed.
- Additional layers needed to satisfy meta-ros's `LAYERDEPENDS` (`meta-python`,
  `openembedded-layer`): `meta-openembedded` cloned at its `wrynose` branch, with `meta-oe` and
  `meta-python` added to `bblayers.conf`.
- Host note: every run printed
  `WARNING: Host distribution "elxr-26.04" has not been validated with this version of the build
  system` — informational only, not treated as a failure.

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
