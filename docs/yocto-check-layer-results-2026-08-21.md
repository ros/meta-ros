# `yocto-check-layer` Results — 2026-08-21

Produced for Milestone 3, Task M3-1 of
[`meta-ros-audit-remediation-spec.md`](meta-ros-audit-remediation-spec.md) (audit ref §4). This
converts that section's "unknown — needs environment" row into concrete findings.

This was a four-round investigation within the same session, each round peeling back one blocking
layer to reveal the next:

1. **Round 1** — fatal `LICENSE`-format QA errors in 40 `meta-ros-common` recipes. **Fixed.**
2. **Round 2** — `python3-junitparser` needed a `python_uv_build.bbclass` that doesn't exist on
   wrynose. **Fixed** (by the user, directly).
3. **Round 3** — two further findings: `meta-ros-common`'s `boost` bbappend causes large-scale
   signature changes in unrelated recipes (expected/likely-permanent, not a bug — not fixed);
   `suitesparse-{cholmod,config,spqr}` unconditionally depended on `openblas`, only provided by the
   optional `meta-python-ai` dynamic layer (a real inconsistency). **Fixed and verified.**
4. **Round 4** — with `openblas` resolved, three more missing `world` providers surfaced
   (`google-benchmark`, `urdfdom`, `ffmpeg`), one of which (`google-benchmark`) is a genuine
   backward cross-layer dependency. **Not fixed** — resolving these needs a substantially larger
   external-layer environment or an architectural call, judged beyond this task's scope.

Raw logs for every run in all three rounds are archived at
`/opt/meta-ros-remediation-handoff/yocto-check-layer-logs-2026-08-21/` (outside this repo, not
committed — `/tmp` on this machine is a `tmpfs` that doesn't survive a reboot, so the scratch copies
were moved to persistent disk during the session).

## Summary

| Layer | Result | Why |
|---|---|---|
| `meta-ros-common` | **FAIL** | `test_parse` now passes (rounds 1+2 fixes confirmed). Fails on: a patch missing `Upstream-Status:`, no `SECURITY.md`, and `test_signatures`/`test_world`/`test_world_inherit_class` due to the `boost` bbappend's large (likely permanent, likely acceptable) signature fan-out. Full 9-test suite ran. |
| `meta-ros1` | FAIL | Rounds 1–3 blockers cleared and verified (parse fully clean, `openblas` fixed). Now fails at `world` resolution on round 4's findings: missing providers for `google-benchmark`, `urdfdom`, `ffmpeg`. |
| `meta-ros2`, `meta-ros1-noetic`, `meta-ros2-humble`, `meta-ros2-jazzy`, `meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`, `meta-spaceros-jazzy` | FAIL (blocked, not re-verified past round 1) | All depend on `meta-ros-common` (directly or via `meta-ros2`), so all will hit the same round-4 findings at the same `world`-resolution stage — established mechanism, not individually re-confirmed for these 9. |

All 11 layers still fail overall, but the *reason* has moved three times: parse-level blockers
(rounds 1 and 2) and the `openblas` dependency-resolution blocker (round 3) are now cleared and
verified for the layers that were re-tested; the current blocker (round 4) is a set of missing
external `world` providers, requiring more environment build-out than this task's scope covers.

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

### 3b. Fixed: `suitesparse-{cholmod,config,spqr}` unconditionally depended on `openblas`, an optional-layer-only package

Re-testing `meta-ros1` (rounds 1+2 fixes both confirmed cleared for it too) hit a new, different
`world`-resolution failure:

```
ERROR: Nothing PROVIDES 'openblas' (but meta-ros-common/recipes-extended/suitesparse/suitesparse-cholmod_5.2.1.bb,
  suitesparse-spqr_4.3.3.bb, suitesparse-config_7.7.0.bb DEPENDS on or otherwise requires it).
ERROR: Required build target 'meta-world-pkgdata' has no buildable providers.
Missing or unbuildable dependency chain was: ['meta-world-pkgdata', 'ceres-solver', 'suitesparse-cholmod', 'openblas']
```

This traced directly back to the `dynamic-layers` mechanism documented in Milestone 1 (`README.md`'s
own table, from task M1-1): `openblas` is only provided by the **optional**
[`meta-python-ai`](https://github.com/zboszor/meta-python-ai) layer — it isn't in `meta-openembedded`
or `openembedded-core` at all (confirmed by searching both trees). But
`meta-ros-common/recipes-extended/suitesparse/{suitesparse-cholmod_5.2.1.bb,
suitesparse-config_7.7.0.bb, suitesparse-spqr_4.3.3.bb}` are **not** under `dynamic-layers/` — they're
regular, always-active recipes, and `suitesparse-config` unconditionally set `DEPENDS = "openblas"`.

This was inconsistent with how the *same repo* handles the identical situation correctly elsewhere:
`meta-ros-common/recipes-support/ipopt/ipopt_3.14.16.bb` gates its own `openblas` `PACKAGECONFIG`
behind the optional layer's presence:

```
PACKAGECONFIG ??= "${@bb.utils.contains('BBFILE_COLLECTIONS', 'meta-python-ai', 'openblas', '', d)}"
```

**Practical effect:** any integrator who follows the documented, normal path — meta-ros layers only,
without opting into the optional `meta-python-ai` layer — got a hard, unresolvable dependency
failure trying to build `world` (or anything pulling in these three `suitesparse` recipes), because
nothing provided `openblas` in that configuration. This wasn't a "some Yocto series doesn't have it
yet" issue like rounds 1–2; it was a same-repo inconsistency between the documented optionality
contract and the actual recipe dependencies.

**Fix applied and confirmed:** checked whether `openblas` is load-bearing before gating it, rather
than guessing. `ipopt`'s `DEPENDS` on plain `lapack` (no `openblas`) confirms `meta-oe`'s
`lapack_3.12.1.bb` recipe (Reference-LAPACK) builds and exports a usable bundled BLAS on its own —
`openblas` is a faster, optional swap, not the only viable implementation, for anything that already
depends on `lapack`. All three `suitesparse` recipes already unconditionally depended on `lapack`
too (or, in `suitesparse-config`'s case, didn't — added it), so the same pattern applied safely:

```diff
- DEPENDS = "openblas"
+ DEPENDS = "lapack"
+ DEPENDS:append = "${@bb.utils.contains('BBFILE_COLLECTIONS', 'meta-python-ai', ' openblas', '', d)}"
```

(and the equivalent removal of the bare `openblas` line from `suitesparse-cholmod`'s and
`suitesparse-spqr`'s existing `DEPENDS` lists, replaced with the same conditional `append`).

**Verified, not just asserted:** re-ran `yocto-check-layer` against `meta-ros1` (without
`meta-python-ai` present — the common, previously-broken case) after the fix. The `openblas`
resolution failure is gone entirely, and bitbake's own parse summary confirms a fully clean parse:
`Parsing of 3038 .bb files complete (3035 cached, 3 parsed). 5533 targets, 124 skipped, 1 masked,
0 errors.` The risk profile made this worth confirming rather than leaving as a documented
suggestion: the pre-fix state was already a guaranteed hard failure for anyone without
`meta-python-ai`, so the fix could only match or improve on that, and it's now verified to improve
on it. The `meta-python-ai`-present path (using `openblas` itself) was not re-verified, since that
layer's own `LAYERDEPENDS` additionally requires `meta-virtualization`, not cloned in this
environment (judged out of scope — see 3c).

### 3c. Beyond `openblas`: several more missing `world` providers — where this investigation stopped

With `openblas` fixed, re-testing `meta-ros1` got substantially further (a fully clean recipe
parse — `0 errors` across 3038 `.bb` files) before hitting the *next* unresolvable dependency:

```
ERROR: Nothing PROVIDES 'google-benchmark' (but meta-ros-common/recipes-devtools/gazebo/ignition-physics5_5.3.2.bb,
  meta-ros-common/recipes-devtools/dartsim/dartsim_6.16.6.bb DEPENDS on or otherwise requires it). Close matches:
  googlebenchmark
  opencl-benchmark
```

And `meta-ros-common` tested alone (before `meta-ros1` was even added) independently surfaces two
more, in the same "Nothing PROVIDES" shape:

```
ERROR: Nothing PROVIDES 'urdfdom' (but .../gazebo/sdformat_16.0.1.bb, .../gazebo-classic/sdformat9_9.10.1.bb,
  .../dartsim/dartsim_6.16.6.bb DEPENDS on or otherwise requires it)
ERROR: Nothing PROVIDES 'ffmpeg' (but .../gazebo/ignition-common4_4.7.0.bb, .../gazebo/gz-common_7.1.1.bb,
  .../gazebo/gz-common6_6.3.0.bb, .../gazebo/gz-common5_5.8.0.bb DEPENDS on or otherwise requires it)
```

`google-benchmark` is the most interesting of the three: `meta-oe` does have a similarly-named
recipe (`googlebenchmark`, no hyphen — the "close match" bitbake suggested), but that's a different,
non-matching `PN`. The actual matching provider — `PN = "google-benchmark"`, hyphenated, exactly
what `dartsim`/`ignition-physics5` want — is
`meta-ros2/recipes-benchmark/google-benchmark/google-benchmark_git.bb` (the same recipe already
flagged in the original audit §4 as one of only two repo-wide hardcoded-absolute-path hits). That
recipe lives in **`meta-ros2`**, a layer whose own `LAYERDEPENDS` depends *on* `meta-ros-common` —
not the other way around. So `meta-ros-common`'s own recipes (`dartsim`, `ignition-physics5`, always
active, not under `dynamic-layers/`) have a real dependency on content that only exists in a layer
built on top of them — an inverted/backward cross-layer dependency, distinct in kind from the
`openblas` optional-layer situation.

**Investigation deliberately stopped here.** `urdfdom` and `ffmpeg` aren't in `meta-openembedded` or
`openembedded-core` either (not searched exhaustively across every possible external layer, but not
in either tree actually added to this environment) — resolving them, plus the `google-benchmark`
layering question, would mean identifying and adding a substantially larger set of external layers
than "the documented required set" (`meta-oe`, `meta-python`), or making an architectural call on
where `google-benchmark` should actually live. That's beyond what a `yocto-check-layer` results
record needs to resolve, and it's concretely why the audit originally scoped full `world` validation
into its own deferred milestone requiring "a full Yocto build environment" — this investigation has
now empirically confirmed that scoping was correct, not just cautious. Recording these three as
findings; not chasing further.

## What was and wasn't re-verified across all three rounds

- **Re-verified through all three rounds:** `meta-ros-common` (parse clean, patches/security/
  signature findings all reconfirmed), `meta-ros1` (parse clean, `openblas` fixed and verified, now
  blocked on the `google-benchmark`/`urdfdom`/`ffmpeg` findings in 3c instead).
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

## The other 10 layers — blocked on round 4's findings, not yet individually verifiable

Their own layer-specific compliance (patch upstream-status, README format, `SECURITY.md`, etc.) is
still unverified. Four rounds in, the blocking mechanism is now well-understood — missing external
`world` providers (`google-benchmark`, `urdfdom`, `ffmpeg`) and a same-repo backward cross-layer
dependency — rather than "no environment available" or "wrong Yocto series." A clean run across all
10 needs either a substantially larger external-layer environment or the `google-benchmark` layering
question resolved first; both were judged beyond this task's scope (see 3c).

## Environment used

- [`bitbake-setup`](https://docs.yoctoproject.org/dev/brief-yoctoprojectqs/index.html#install-and-use-bitbake-setup)
  (PyPI package `bitbake-setup`, v2.19.0), config `poky-wrynose` (Yocto 6.0, matching this branch's
  `LAYERSERIES_COMPAT`), bitbake variant `poky`, `distro/poky`, `machine/qemux86-64`.
- Location: `/opt/meta-ros-remediation-handoff/yocto-wrynose/` — a poky/OE-core tree, outside this
  repo checkout and not committed.
- Additional layers needed to satisfy meta-ros's `LAYERDEPENDS` (`meta-python`,
  `openembedded-layer`): `meta-openembedded` cloned at its `wrynose` branch, with `meta-oe` and
  `meta-python` added to `bblayers.conf`.
- `meta-python-ai` (`wrynose` branch) was cloned but **not** added to `bblayers.conf` — its own
  `LAYERDEPENDS` additionally needs `meta-virtualization` (not cloned) — see 3b/3c.
- Host note: every run printed
  `WARNING: Host distribution "elxr-26.04" has not been validated with this version of the build
  system` — informational only, not treated as a failure.
- Raw logs for all runs across all four rounds: `/opt/meta-ros-remediation-handoff/yocto-check-layer-logs-2026-08-21/`.

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
