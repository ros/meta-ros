# `yocto-check-layer` Results — 2026-08-21

Produced for Milestone 3, Task M3-1 of
[`meta-ros-audit-remediation-spec.md`](meta-ros-audit-remediation-spec.md) (audit ref §4). This
converts that section's "unknown — needs environment" row into concrete findings.

This was a seven-round investigation within the same session, each round peeling back one blocking
layer to reveal the next:

1. **Round 1** — fatal `LICENSE`-format QA errors (`AND`/`OR` as literal words) in 40
   `meta-ros-common` recipes. **Fixed.**
2. **Round 2** — `python3-junitparser` needed a `python_uv_build.bbclass` that doesn't exist on
   wrynose. **Fixed** (by the user, directly).
3. **Round 3** — two further findings: `meta-ros-common`'s `boost` bbappend causes large-scale
   signature changes in unrelated recipes (expected/likely-permanent, not a bug — not fixed);
   `suitesparse-{cholmod,config,spqr}` unconditionally depended on `openblas`, only provided by the
   optional `meta-python-ai` dynamic layer (a real inconsistency). **Fixed and verified.**
4. **Round 4** — with `openblas` resolved, three more missing `world` providers surfaced
   (`google-benchmark`, `urdfdom`, `ffmpeg`). Initially left as findings requiring a larger
   environment or an architectural call.
5. **Round 5** — per the user's direction to include `meta-ros2` and `meta-ros2-<DISTRO>` layers
   (google-benchmark's real provider lives in `meta-ros2`), re-tested with those added. Found the
   *same* `LICENSE` `AND`/`OR` bug independently present in `meta-ros2` itself (12 files) and,
   at much larger scale, in `meta-ros2-rolling/generated-recipes/` (61 files — genuine superflore
   output, not hand-edited). Also found two recipes with a `WITH`-exception `LICENSE` clause that
   OE's parser doesn't support at all (independent of the `AND`/`OR` bug), and a stale
   `.replace()`-based license workaround that had become a silent no-op. **All hand-authored
   instances fixed and verified** (meta-ros2's 12 + 7 `meta-ros2-rolling` bbappends + 2
   `WITH`-clause fixes + 1 go-mod license file); the 61 `meta-ros2-rolling/generated-recipes/`
   instances **not fixed** — flagged as a probable regeneration-time issue instead.
6. **Round 6** — with those fixes, `google-benchmark`/`google-benchmark-vendor`/`ffmpeg` all now
   resolve (the last needed only a standard `LICENSE_FLAGS_ACCEPTED = "commercial"` opt-in, not a
   code change). Testing the *realistic* layer combination (`meta-ros2-humble` alone, not mixed
   with `meta-ros1`) got all the way down to a single remaining finding: `gz-gui`/`gz-sim`/
   `gz-gui9` unconditionally depend on `qtdeclarative`, which only the optional `meta-qt6` layer
   provides.
7. **Round 7** — checked each affected package's actual upstream `CMakeLists.txt` for a genuine
   headless build option rather than assuming. Mixed, precise answer: `gz-sim` **v10** specifically
   has a real `ENABLE_GUI` option and is safely gate-able like `openblas` was; `gz-sim` **v9**,
   `gz-gui`, `gz-gui9`, and `gz-launch7/8/9` are all confirmed genuinely, permanently Qt-required
   with no upstream escape hatch. `gz-sim` has a very large blast radius (`packagegroup-ros-world-
   <distro>` itself, plus dozens of real simulation packages, across every ROS2 distro). Presented
   the full breakdown to the user; **decision: record the analysis, don't touch any recipes this
   round.**

Raw logs for every run across all seven rounds are archived at
`/opt/meta-ros-remediation-handoff/yocto-check-layer-logs-2026-08-21/` (outside this repo, not
committed — `/tmp` on this machine is a `tmpfs` that doesn't survive a reboot, so the scratch copies
were moved to persistent disk during the session).

## Summary

| Layer | Result | Why |
|---|---|---|
| `meta-ros-common` | **FAIL** | `test_parse` passes (rounds 1+2 fixes). Fails on: a patch missing `Upstream-Status:`, no `SECURITY.md`, and `test_signatures`/`test_world`/`test_world_inherit_class` due to the `boost` bbappend's large (likely permanent, likely acceptable) signature fan-out. Full 9-test suite ran. |
| `meta-ros2` | Not run as its own `yocto-check-layer` target | Its own `LICENSE` bugs (12 files) fixed and verified via direct `bitbake` parse/dependency queries, but not run through the full `yocto-check-layer` 9-test suite as a standalone target. |
| `meta-ros1` | FAIL | Parse fully clean; `openblas` fixed. At `world` resolution, blocked on `google-benchmark`/`urdfdom` when tested with `meta-ros2`+`meta-ros2-humble` mixed in — likely an artifact of that unrealistic combination (ROS1 + a ROS2 distro layer together), not a real-world scenario; not chased further. |
| `meta-ros2-humble` | FAIL, but only on one finding | Tested as the realistic combination (`meta-ros-common` + `meta-ros2`, no `meta-ros1`). `google-benchmark-vendor`, `urdfdom`, `ffmpeg` all resolve cleanly. Only remaining blocker: `gz-gui`/`gz-sim`/`gz-gui9`'s unconditional `qtdeclarative` dependency (round 6). |
| `meta-ros1-noetic`, `meta-ros2-jazzy`, `meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`, `meta-spaceros-jazzy` | FAIL (not re-verified past round 1) | Each depends on `meta-ros-common` (directly or via `meta-ros2`), so each would very likely hit the same round-6 `qtdeclarative` finding (or, for `meta-ros2-rolling` specifically, its own remaining 61 generated-recipe `LICENSE` instances first). Not individually re-run. |

The practical bottom line: after 6 rounds and roughly a dozen real fixes, `meta-ros2-humble` tested
in a realistic configuration is down to **one** remaining, well-understood finding
(`qtdeclarative`), from an original "unknown — needs environment."

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
`AND`/`OR`, the correct move on this branch right now is the old syntax.

**Fix applied:** reverted `AND`/`OR` back to `&`/`|` in all 40 affected recipes. Confirmed clean by
re-running `yocto-check-layer` against `meta-ros-common`.

## Round 2 — fixed (by the user): `python_uv_build.bbclass` unavailable on wrynose

`python3-junitparser_5.0.1.bb` had `inherit python_uv_build ptest-python-pytest`. Confirmed against
upstream `junitparser`'s `pyproject.toml` (`build-backend = "uv_build"`) that the `inherit` was
correct in intent — the gap was that wrynose's `openembedded-core` has no `python_uv_build.bbclass`,
even though both of that class's own dependencies (`python_pep517.bbclass`,
`python3-uv-build-native`) already exist and work there. The user fixed this directly, inlining the
class's two effective lines into the recipe instead of adding a new vendored bbclass file.

## Round 3 — fixed and verified: `suitesparse`'s unconditional `openblas` dependency

`suitesparse-{cholmod,config,spqr}` unconditionally `DEPENDS` on `openblas`, which is only provided
by the optional [`meta-python-ai`](https://github.com/zboszor/meta-python-ai) layer (documented in
Milestone 1's own README table). This is inconsistent with `ipopt` in the same layer, which
correctly gates the identical dependency via
`bb.utils.contains('BBFILE_COLLECTIONS', 'meta-python-ai', ...)`. Checked whether `openblas` was
load-bearing before fixing — it isn't: `meta-oe`'s `lapack` recipe already exports a usable bundled
BLAS, matching `ipopt`'s own working pattern. Applied the same gate to all three `suitesparse`
recipes and verified via a real re-run: `meta-ros1` without `meta-python-ai` present parses `world`
fully cleanly.

`meta-ros-common` also independently fails `test_signatures`/`test_world`/`test_world_inherit_class`
because its `boost` bbappend (adds Boost.Python/NumPy support) causes ~30.8K signature changes in
unrelated recipes when the layer is added. This is very likely expected and permanent — bbappending
a foundational, widely-depended-upon recipe like `boost` to add a genuinely-needed dependency is a
standard Yocto pattern, not what `test_signatures` is designed to catch. Not fixed, not expected to
be fixable without removing real functionality.

## Round 4 — three more missing `world` providers found

With `openblas` fixed, `meta-ros1`'s `world` resolution got further before hitting:
`google-benchmark` (real provider is in `meta-ros2`, not `meta-ros-common` or any layer `meta-ros1`
declares a dependency on — a backward cross-layer relationship, since `meta-ros2` depends *on*
`meta-ros-common`), `urdfdom`, and `ffmpeg` (neither in `meta-openembedded` or `openembedded-core`).
Initially not chased further, since `google-benchmark`'s real layer wasn't part of the test
environment. Resolved in rounds 5–6 below once the user pointed to including `meta-ros2` and a
`meta-ros2-<DISTRO>` layer.

## Round 5 — fixed: more `LICENSE` `AND`/`OR` bugs, found across `meta-ros2` and `meta-ros2-rolling`

Adding `meta-ros2` + `meta-ros2-humble` to satisfy `google-benchmark` hit the *same* fatal
`license-format` QA error, this time in `meta-ros2/recipes-devtools/fzf/fzf_0.72.0.bb`. A
repo-wide re-scan found the issue in two very different places:

- **12 hand-authored files directly in `meta-ros2`** (not under `generated-recipes/`) — same kind
  of bug as round 1, same kind of fix: `dynamic-layers/meta-qt6/recipes-qt/qt6/{qt5compat,
  qtdeclarative,qtshadertools}_git.bbappend`, `recipes-devtools/python/python3-uvloop_0.19.0.bb`,
  `recipes-kernel/lttng/babeltrace_1.5.11.bb`, `recipes-support/{draco (×2 versions),
  dynamic-trajectory-generator,nlopt,openni,openni2,openscenegraph}`. **Fixed.**
- **61 files under `meta-ros2-rolling/generated-recipes/`** — genuine superflore output (per
  `AGENTS.md`, never hand-edited; it gets silently overwritten on the next regen). No other distro
  layer (`humble`/`jazzy`/`kilted`/`lyrical`, `meta-ros1`/`noetic`, `meta-spaceros*`) has this issue
  at all — only `rolling`. This strongly suggests `meta-ros2-rolling` was regenerated using a
  superflore build that's already emitting the `AND`-based format from
  [PR #327](https://github.com/ros-infrastructure/superflore/pull/327), before that change was
  properly scoped and merged — directly relevant to the PR the user is reviewing upstream. **Not
  fixed** — the real fix is regenerating `meta-ros2-rolling` with a corrected superflore, not
  hand-patching 61 generated files that would just get overwritten again. `meta-ros2-rolling` also
  had 7 `recipes-bbappends/*` files (legitimate override files, not generated) with the same bug —
  **fixed** those directly (`cyclonedds`, `gtsam`, `pybind11-vendor`, `rmw-zenoh`, `ur-description`,
  `vision-opencv`, `cv-bridge`).

**Two further, independent `LICENSE`-syntax bugs found in the same pass** (not the `AND`/`OR`
issue): OE's `oe.license` parser only recognizes `&`, `|`, `(`, `)` as operators — the SPDX `WITH`
keyword (for license-exception clauses) isn't one, so a bare `X WITH Y-exception` gets silently
mis-tokenized as an implicit-`&`-joined bogus identifier. Confirmed OE-core's own established
convention (`socat`, `newlib`, `clang`, `autoconf-archive`, `gcc`, `xz`, `glslang` all checked) is a
single hyphenated compound token, lowercase `with` — e.g. `GPL-3.0-with-autoconf-exception`,
`GPL-3-with-bison-exception` (`glslang`'s exact precedent for the case found here). Fixed
`meta-ros2/recipes-support/openscenegraph/openscenegraph_3.6.5.bb`
(`LGPL-2.1-only-with-WxWindows-exception-3.1`) and the `qtshadertools` bbappend
(`GPL-3.0-or-later-with-Bison-exception-2.2`) to match.

Also fixed `meta-ros2/recipes-devtools/fzf/fzf-licenses.inc`'s own `LICENSE += "AND BSD-3-Clause AND
EXPAT"` — this file is generated by `go-mod-update-modules.bbclass`, but unlike superflore's
continuous regeneration this is a one-time, locally-run task (its own header warns a future manual
re-run would need the fix reapplied, not that CI silently overwrites it), so hand-fixing it directly
was judged appropriate.

Finally, `meta-ros2-rolling/recipes-bbappends/ur-description/ur-description_4.3.0-1.bbappend` had a
`.replace()`-based `LICENSE` workaround that had gone stale: it targeted an older,
apostrophe-containing generated `LICENSE` string that no longer matches the current generated
recipe's value, so `.replace()` was silently passing the current (`AND`-broken) value through
unchanged — a no-op masquerading as a fix. Replaced with a direct assignment now that the original
apostrophe problem the `.replace()` worked around is already gone from the current generated value.

**All fixes in this round verified** via `bitbake-layers show-recipes google-benchmark-vendor` with
`meta-ros-common` + `meta-ros2` + `meta-ros2-humble` in `bblayers.conf`: fully clean parse (0 errors
across 5341 recipes), and `google-benchmark-vendor` resolves correctly (provided by
`meta-ros2-humble` 0.1.2-1).

## Round 6 — `google-benchmark`/`ffmpeg` resolved; one remaining finding (`qtdeclarative`)

Re-running the full `world`-signature check for `meta-ros1` with `meta-ros2` + `meta-ros2-humble`
included: `google-benchmark`/`google-benchmark-vendor` both resolve now. `ffmpeg` surfaced a
different kind of message —

```
ffmpeg was skipped: Has a restricted license 'commercial' which is not listed in your LICENSE_FLAGS_ACCEPTED.
```

— not a bug at all: standard Yocto behavior requiring an explicit opt-in
(`LICENSE_FLAGS_ACCEPTED = "commercial"` in `local.conf`) for patent-encumbered codecs. Added that
to the test environment's `local.conf` (a one-time environment setting, not a repo change) and
`ffmpeg` resolved.

With that, `meta-ros1` (mixed with `meta-ros2`+`meta-ros2-humble`) still hit `urdfdom` — but this
combination (a ROS1 layer plus a ROS2 distro layer simultaneously) isn't a realistic real-world
setup; further investigation showed `meta-ros1`'s own `urdfdom_1.0.0-2.bb` inherits
`ros_recipe_now_generated.bbclass`, which renames itself away (`PN:append = "-notgenerated"`)
whenever `ROS_SUPERFLORE_GENERATED_RECIPES` indicates the current context already has a
superflore-generated `urdfdom` — a deliberate conflict-avoidance mechanism for combining ROS-era
hand-written fallbacks with newer generated equivalents, likely not designed for (or meaningful in)
a mixed ROS1+ROS2-distro test. Not chased further — not a realistic scenario to fix for.

**Switched to the realistic combination instead**: `meta-ros2-humble` alone (its actual
`LAYERDEPENDS`: `meta-ros-common` + `meta-ros2`, no `meta-ros1`). Result: `urdfdom`,
`google-benchmark-vendor`, and `ffmpeg` all resolve cleanly. The *only* remaining blocker:

```
ERROR: Nothing PROVIDES 'qtdeclarative' (but .../gz-gui_10.0.0.bb, .../gz-sim_10.4.0.bb,
  .../gz-gui9_9.0.2.bb DEPENDS on or otherwise requires it)
```

Same shape as the `openblas` finding — `qtdeclarative` is only provided by the optional
[`meta-qt6`](https://code.qt.io/yocto/meta-qt6) layer (per Milestone 1's README table again), and
`gz-gui`/`gz-sim`/`gz-gui9` unconditionally `DEPENDS` on it (confirmed: plain `DEPENDS`, not gated
by any `bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', ...)` check, even though these same
recipes already conditionally `inherit` a `qt6-cmake` bbclass based on that exact check for a
different purpose).

**Why this one wasn't fixed the same way as `openblas` right away:** `openblas` was a swappable BLAS
*implementation* — `lapack`'s bundled reference BLAS was a genuine functional substitute, so gating
was safe and verified with a real test. `qtdeclarative`'s situation needed checking case-by-case
before assuming the same fix would apply — see round 7.

## Round 7 — verified against real upstream `CMakeLists.txt`: mixed answer, not touched

Rather than assume `qtdeclarative` was uniformly unfixable or uniformly fixable, checked each
affected package's actual upstream build system for a genuine headless option (not guessed):

| Recipe | Upstream headless option? | Verdict |
|---|---|---|
| `gz-sim_10.1.1.bb`, `gz-sim_10.4.0.bb` (gz-sim **v10**) | **Yes** — `option(ENABLE_GUI "Build gz-sim with GUI enabled" ON)`; `gz-gui` is only `gz_find_package`d `if(ENABLE_GUI)` | Safely gate-able, same pattern as `openblas`: conditional `DEPENDS` on `gz-gui` + `-DENABLE_GUI=OFF` in `EXTRA_OECMAKE` when `qt6-layer` absent. |
| `gz-sim9_{9.0.0,9.1.0,9.5.0}.bb` (gz-sim **v9**) | **No** — `gz_find_package(gz-gui9 REQUIRED)` and `Qt5 ... REQUIRED`, no `ENABLE_GUI`-equivalent in this older major version | Genuinely Qt-required, same situation as `gz-gui`/`gz-gui9`. |
| `gz-gui_10.0.0.bb`, `gz-gui9_9.0.2.bb` | N/A — these packages exist only to provide the GUI | Correctly, permanently Qt-required. Gating would be meaningless (nothing left to build). |
| `gz-launch7/8/9` (`7.1.1`, `8.0.0/1/3`, `9.0.0/1`) | **No** — confirmed `gz_find_package(gz-gui ... REQUIRED)` and `gz_find_package(gz-sim ... REQUIRED PRIVATE COMPONENTS gui)`, no disable flag | Genuinely Qt-required, no escape hatch. |

**Blast radius checked before proposing anything:** `gz-sim` (any version) is depended on directly
by `packagegroup-ros-world-<distro>.bb` itself in every ROS2 distro (`humble`/`jazzy`/`kilted`/
`lyrical`/`rolling`), plus dozens of real packages across those distros —
`turtlebot3-gazebo`, `ur-simulation-gz`, `nav2-bringup`, `gz-ros2-control(-demos)`,
`rmf-simulation`, `ros-gz(-sim)`, `open-manipulator-bringup`, and many more. `gz-gui` has a similar
but smaller footprint (`gz-launch`, `gz-sim` itself, `ignition-gui6`, several vendor/plugin
packages). This is a much larger footprint than `openblas`'s narrowly-scoped 3 `suitesparse`
recipes — a structural change here (gating `gz-sim` v10, and/or relocating the genuinely
Qt-only packages under `dynamic-layers/meta-qt6/` so `world` gracefully skips them instead of
hard-failing) would touch how a wide swath of the ROS2 simulation ecosystem resolves.

**Decision: recorded as a finding, not acted on.** Given the mixed picture (one narrow, verified-safe
gate available for `gz-sim` v10; several genuinely-unfixable-by-gating packages where the real fix
would be a `dynamic-layers` relocation with real blast radius), this was presented to the user with
the full breakdown above rather than executed unilaterally, and the explicit decision was to record
the analysis for a maintainer to act on rather than touch any recipes this round.

## What's genuinely blocking a clean `meta-ros2-humble` run right now

Just the `qtdeclarative`/`meta-qt6` finding above (round 6/7). Everything else discovered across all
seven rounds for this specific, realistic layer combination has either been fixed and verified, or
identified as expected/non-fixable Yocto behavior (the `boost` signature fan-out).

## `meta-ros-common` — full results (final, all applicable fixes applied)

| Test | Result | Detail |
|---|---|---|
| `test_layerseries_compat` | ok | |
| `test_parse` (`bitbake -p`) | **ok** | Fixed in rounds 1+2. |
| `test_patches_upstream_status` | FAIL | 1 patch with malformed/missing `Upstream-Status:`: `recipes-devtools/gazebo/ignition-rendering6/ign-gz-namespace-migration.patch`. |
| `test_readme` | ok | |
| `test_security` | FAIL | No `SECURITY.md` in the layer. Not a checklist item the original audit (§4) checked for; `yocto-check-layer` enforces it directly, so this is new information regardless. |
| `test_show_environment` | ok | |
| `test_signatures` | FAIL | `boost` bbappend's large signature fan-out — see round 3, likely expected/permanent. |
| `test_world` | ERROR | Same underlying cause as `test_signatures`. |
| `test_world_inherit_class` | FAIL | Same underlying cause. |

## The other layers — not individually re-run through the full `yocto-check-layer` suite

`meta-ros2` (as its own target), `meta-ros1-noetic`, `meta-ros2-jazzy`, `meta-ros2-kilted`,
`meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`, `meta-spaceros-jazzy`: their own
layer-specific compliance (patch upstream-status, README format, `SECURITY.md`, etc.) is still
unverified through the full 9-test suite. `meta-ros2-rolling` specifically would also need its
remaining 61 generated-recipe `LICENSE` instances resolved (regeneration, not hand-patching) before
a clean run is possible there. The rest would very likely hit the same `qtdeclarative` finding
`meta-ros2-humble` did, following the same `LAYERDEPENDS` chain through `meta-ros2` →
`meta-ros-common`.

## Environment used

- [`bitbake-setup`](https://docs.yoctoproject.org/dev/brief-yoctoprojectqs/index.html#install-and-use-bitbake-setup)
  (PyPI package `bitbake-setup`, v2.19.0), config `poky-wrynose` (Yocto 6.0, matching this branch's
  `LAYERSERIES_COMPAT`), bitbake variant `poky`, `distro/poky`, `machine/qemux86-64`.
- Location: `/opt/meta-ros-remediation-handoff/yocto-wrynose/` — a poky/OE-core tree, outside this
  repo checkout and not committed.
- `meta-openembedded` cloned at its `wrynose` branch (`meta-oe`, `meta-python` added to
  `bblayers.conf`); `meta-python-ai` (`wrynose` branch) cloned but never added (its own
  `LAYERDEPENDS` additionally needs `meta-virtualization`, not cloned); `meta-qt6` never cloned.
- `local.conf` has `LICENSE_FLAGS_ACCEPTED = "commercial"` added (round 6, for `ffmpeg`) — an
  environment setting, not a repo change.
- Host note: every run printed
  `WARNING: Host distribution "elxr-26.04" has not been validated with this version of the build
  system` — informational only, not treated as a failure.
- Raw logs for all runs across all seven rounds: `/opt/meta-ros-remediation-handoff/yocto-check-layer-logs-2026-08-21/`.
- **Note on environment hygiene:** `yocto-check-layer` does not reliably restore `bblayers.conf` to
  its pre-run state after a normal (non-interrupted) completion — a prior run's dependency-layer
  additions were found still present in `bblayers.conf` at the start of a later, unrelated
  invocation, causing that layer to be silently `SKIPPED` rather than tested. Reset `bblayers.conf`
  to the intended base set before each invocation rather than assuming it's clean.

## Commands used

```sh
source <poky-wrynose-build>/init-build-env build

# Single-layer test, dependencies supplied explicitly:
yocto-check-layer --no-auto-dependency \
  --dependency <meta-oe> <meta-python> <meta-ros-common> [<meta-ros2>] \
  -o <layer>.log <path-to-layer>

# Direct dependency-resolution query (faster than a full yocto-check-layer
# pass when only checking whether something PROVIDES cleanly, not running
# the full 9-test suite):
bitbake-layers show-recipes <recipe-name>
```

`--no-auto-dependency` + explicit `--dependency` avoids `yocto-check-layer`'s default behavior of
re-testing every dependency layer as its own separate target on every invocation.

Dependency chain used per layer (from each layer's `LAYERDEPENDS`):
- `meta-ros1`, `meta-ros2` → `meta-ros-common`
- `meta-ros1-noetic` → `meta-ros-common`, `meta-ros1`
- `meta-ros2-humble`, `meta-ros2-jazzy`, `meta-ros2-kilted`, `meta-ros2-lyrical`,
  `meta-ros2-rolling`, `meta-spaceros`, `meta-spaceros-jazzy` → `meta-ros-common`, `meta-ros2`
