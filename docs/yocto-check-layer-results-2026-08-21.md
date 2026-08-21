# `yocto-check-layer` Results — 2026-08-21

Produced for Milestone 3, Task M3-1 of
[`meta-ros-audit-remediation-spec.md`](meta-ros-audit-remediation-spec.md) (audit ref §4). This
converts that section's "unknown — needs environment" row into concrete findings.

## Summary

| Layer | Result | Why |
|---|---|---|
| `meta-ros-common` | **FAIL** | Fatal QA `license-format` errors in several recipes' `LICENSE` field; also a patch missing `Upstream-Status:`, and no `SECURITY.md`. Full test suite ran (see below). |
| `meta-ros1` | FAIL (blocked) | Never reached its own test suite — aborted at the signature baseline due to `meta-ros-common`'s fatal QA errors. |
| `meta-ros2` | FAIL (blocked) | Same. |
| `meta-ros1-noetic` | FAIL (blocked) | Same. |
| `meta-ros2-humble` | FAIL (blocked) | Same. |
| `meta-ros2-jazzy` | FAIL (blocked) | Same. |
| `meta-ros2-kilted` | FAIL (blocked) | Same. |
| `meta-ros2-lyrical` | FAIL (blocked) | Same. |
| `meta-ros2-rolling` | FAIL (blocked) | Same. |
| `meta-spaceros` | FAIL (blocked) | Same. |
| `meta-spaceros-jazzy` | FAIL (blocked) | Same. |

All 11 layers currently fail `yocto-check-layer`, but 10 of the 11 failures are the *same* root
cause cascading through `LAYERDEPENDS`, not 10 independent problems.

## Root cause: malformed `LICENSE` fields in `meta-ros-common` block every other layer

`meta-ros-common` is edited directly (it's the one layer without a `recipes-bbappends` directory —
see `AGENTS.md`), and several of its hand-authored recipes set `LICENSE` using the English word
`AND` as a separator between multiple license identifiers, e.g.:

```
LICENSE = "EPL-1.0 AND LicenseRef-EPL-2.0-or-later"
```

OE-core's `LICENSE` syntax requires `&` (all apply), `|` (choice), or parentheses for grouping —
not the literal word `AND`. This trips a **fatal QA error** (`license-format`) that halts bitbake's
recipe parsing entirely for anything that pulls in `meta-ros-common` — which is all 10 other
meta-ros layers, since each declares `ros-common-layer` in its `LAYERDEPENDS`.

Practical effect: neither `yocto-check-layer` nor a real `bitbake world` attempt can get past the
initial signature-generation baseline for *any* of the 11 meta-ros layers until this is fixed.
Confirmed by running the check against `meta-ros-common` alone, then separately against each of the
other 10 layers — every one of those 10 runs aborted identically at "Getting initial signatures"
with the same fatal QA errors, before even reaching that layer's own test suite.

Affected recipes (compiled across all 11 check runs — bitbake's parallel parser surfaces a
different partial subset each run before halting, so this is a superset, not necessarily
exhaustive; see caveat below):

| Recipe | `LICENSE` value |
|---|---|
| `recipes-devtools/coinor/coinor-cgl_git.bb` | `"EPL-1.0 AND LicenseRef-EPL-2.0-or-later"` |
| `recipes-devtools/cppcheck/cppcheck_2.14.2.bb` | `"0BSD AND BSD-2-Clause AND GPL-3.0-only AND Zlib"` |
| `recipes-devtools/dartsim/dartsim_6.13.2.bb` | `"BSD-2-Clause AND BSD-3-Clause AND MIT"` |
| `recipes-devtools/dartsim/dartsim_6.16.6.bb` | `"BSD-2-Clause AND BSD-3-Clause AND MIT"` |
| `recipes-devtools/gazebo-classic/gazebo11_11.15.1.bb` | `"Apache-2.0 AND GPL-2.0-only AND LGPL-2.1-only AND LGPL-3.0-only"` |
| `recipes-devtools/gazebo-classic/gazebomsgsout-native_11.14.0.bb` | `"Apache-2.0 AND GPL-2.0-only AND LGPL-2.1-only AND LGPL-3.0-only"` |
| `recipes-devtools/gazebo/gz-launch7_7.1.1.bb` | `"Apache-2.0 AND BSD-3-Clause"` |
| `recipes-devtools/gazebo/gz-launch8_8.0.0.bb` | `"Apache-2.0 AND BSD-3-Clause"` |
| `recipes-devtools/gazebo/gz-launch8_8.0.1.bb` | `"Apache-2.0 AND BSD-3-Clause"` |
| `recipes-devtools/gazebo/gz-launch8_8.0.3.bb` | `"Apache-2.0 AND BSD-3-Clause"` |
| `recipes-devtools/gazebo/gz-launch_9.0.0.bb` | `"Apache-2.0 AND BSD-3-Clause"` |
| `recipes-devtools/gazebo/gz-launch_9.0.1.bb` | `"Apache-2.0 AND BSD-3-Clause"` |

**Caveat — this list may be incomplete.** bitbake halts world-parsing once fatal QA errors
accumulate, so recipes further down the parse order than the ones listed here were never reached.
Re-run `bitbake -p` (or this same check) after fixing the above to surface any further
`license-format` violations before considering this closed.

**Suggested fix (not applied here — out of scope for this task; M3-1's job is to produce this
record, not fix every failure it surfaces, per the milestone's own acceptance criteria):** replace
`AND` with `&` in each `LICENSE` field above, e.g.
`LICENSE = "EPL-1.0 & LicenseRef-EPL-2.0-or-later"`. Mechanical, `meta-ros-common`-only change —
safe to edit directly per the layer's direct-edit convention. This is the single blocker preventing
`yocto-check-layer` from validating any of the other 10 layers, so it's worth prioritizing as a
fast-follow ahead of the rest of Milestone 3.

## `meta-ros-common` — full results

`meta-ros-common` has no meta-ros-internal dependencies of its own, so it was tested standalone and
ran its complete 9-test suite before hitting the parse blocker:

| Test | Result | Detail |
|---|---|---|
| `test_layerseries_compat` | ok | |
| `test_parse` (`bitbake -p`) | ERROR | Fatal QA `license-format` errors, see above. |
| `test_patches_upstream_status` | FAIL | 1 patch with malformed/missing `Upstream-Status:`: `recipes-devtools/gazebo/ignition-rendering6/ign-gz-namespace-migration.patch` |
| `test_readme` | ok | |
| `test_security` | FAIL | No `SECURITY.md` in the layer. Not a checklist item the original audit (§4) checked for — `yocto-check-layer` enforces it directly, so this is new information. |
| `test_show_environment` | ok | |
| `test_signatures` | ERROR | Cascades from the `LICENSE` parse blocker. |
| `test_world` | ERROR | Cascades from the `LICENSE` parse blocker. |
| `test_world_inherit_class` | FAIL | Cascades from the `LICENSE` parse blocker. |

`Ran 9 tests in 244.133s — FAILED (failures=3, errors=3, skipped=2)`

## The other 10 layers — blocked, not yet individually verifiable

`meta-ros1`, `meta-ros2`, `meta-ros1-noetic`, `meta-ros2-humble`, `meta-ros2-jazzy`,
`meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`, and
`meta-spaceros-jazzy` all failed identically at the "Getting initial signatures" baseline step —
*before* `yocto-check-layer`'s own per-layer test suite (parse, patches, README, security,
signatures, world) ever ran against their own content. Their own layer-specific compliance
(patch upstream-status, README format, `SECURITY.md`, etc.) is therefore **still unverified** — the
same "unknown" status the original audit left it in, now understood to be blocked on a specific,
fixable root cause rather than "no environment available."

**Next step once `meta-ros-common`'s `LICENSE` fields are fixed:** re-run this same check per layer
(commands below) to get real per-layer results for all 10.

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
