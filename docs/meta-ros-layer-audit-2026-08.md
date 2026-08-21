# meta-ros Layer Audit — August 2026

**Scope:** Read-only scan of the `meta-ros` monorepo (11 sub-layers: `meta-ros-common`,
`meta-ros1`, `meta-ros1-noetic`, `meta-ros2`, `meta-ros2-{humble,jazzy,kilted,lyrical,rolling}`,
`meta-spaceros`, `meta-spaceros-jazzy`). No recipes, config, or scripts were modified in the
course of this audit. Findings below are grouped by the six areas of the audit brief, each with
what/where, why it matters, effort (small/medium/large), and a concrete next step. A phased
roadmap closes the report.

Numeric claims are backed by actual `grep`/`find`/`gh` counts run against the repo (or, for CI
behavior, by literally re-running the check in question), not estimated from samples — noted
inline where relevant.

---

## 1. Recipe currency & upgrade automation

### 1.1 The regeneration pipeline works, but has no scheduled trigger and no fan-out
**Where:** `.github/workflows/generate_recipes.yml` (`workflow_dispatch` only — no `schedule:`)
→ `scripts/ros-generate-cache.sh` → `scripts/ros-generate-recipes.sh` → `scripts/rename-bbappend.sh`
→ PR to branch `superflore/<yocto-release>/<ros-distro>/<date>`.

A human must manually pick a Yocto-release branch and a ROS distro from a dropdown and click
"Run workflow," once per branch × distro combination. There's no matrix job sweeping all
combinations automatically.

**Verified cadence (via `gh run list`, not assumed):** 177 runs total since the workflow was
added (2024-04-13). Of the last 50: 44 success, 4 failure, 2 cancelled (~8% failure rate).
Resulting PRs merge same-day to next-day; **zero open superflore PRs today**. This is an
actively-used process, not neglected — but it is a single-point-of-failure on one maintainer
remembering to click it.

**Per-distro staleness (last sync commit, relative to 2026-08-20):**

| Distro | Last sync | Age |
|---|---|---|
| humble | 2026-07-03 | ~7 weeks |
| lyrical | 2026-07-21 | ~4.5 weeks |
| jazzy | 2026-06-30 | ~7.5 weeks |
| kilted | 2026-06-30 | ~7.5 weeks |
| rolling | 2026-05-06 | ~3.5 months |
| noetic | 2025-07-11 | ~13.5 months |

`rolling` drifting 3.5 months is a real risk (fast-moving, non-LTS distro); `noetic` at 13+
months is more defensible (ROS1/EOL-adjacent, already "best-effort" per README) but means it's
generated against a year-old rosdistro snapshot.

**Effort:** Small — add a `schedule:` cron trigger with a matrix over the distro list, gated so
it doesn't open empty PRs when nothing changed upstream.
**Next step:** Add scheduled + matrix trigger to `generate_recipes.yml`, or at minimum a
scheduled reminder/issue-bot if full unattended automation is judged too risky.

### 1.2 `.bbappend` scale and patch fragility
**Where:** All `recipes-bbappends*/` directories.

**Counted totals:** 3,796 `.bbappend` files across the repo (0 in `meta-ros-common`/
`meta-spaceros` since those aren't superflore-generated the same way). 87% (3,285) are pinned to
an exact `PV` in the filename; only 13% (511) use the `_%.bbappend` wildcard that survives future
version bumps. This makes `rename-bbappend.sh` — which parses sync-commit messages to `git mv`
matching bbappends — a structurally critical, fragile link: if superflore's commit-message format
ever changes shape, renames get silently skipped and the override **silently stops applying**
(no build error, just a missing fix).

1,163 `.patch` files live under `recipes-bbappends*`. Sampled several; most are small, but
`meta-ros2-humble/recipes-bbappends/moveit/moveit-setup-app-plugins/remove-ament-target-dependencies.patch`
is a ~1,500-line, 100-file backport patch across the whole moveit2 CMake tree, shared by 6 sibling
`moveit-setup-*` bbappends all pinned to the same `PV`. Any future moveit version bump is a
coordinated multi-file re-patching event, not a routine regen — worth flagging as a "watch this on
every moveit bump" item, and checking whether the fix has since landed upstream (patch header
cites an upstream commit) and could simply be dropped on newer distro layers.

74 `.bbappend` files (227 lines) carry `SRCREV` pins, almost all for the standard "vendor package"
workaround pattern (CMake `FetchContent` redirected to a bitbake-fetched, pinned source tree) —
this is a legitimate, necessary, recurring pattern, not stale cruft. Comment quality varies though:
some pins document the release tag they correspond to (good), others pin a bare commit hash with
no explanation (e.g. `tinyspline-vendor`, `libaec`).

**Effort:** Medium (structural risk, no single fix) / Small (backfilling missing SRCREV comments).
**Next step:** No urgent code change; flag the moveit bbappend cluster for extra scrutiny on the
next moveit bump, and do a documentation-only sweep adding a one-line "tied to release X" comment
to the ~74 files with `SRCREV` pins that currently lack one.

### 1.3 `git://` fetch scheme — checked, not currently a problem
**Where:** Whole repo — 12,188 raw `git://` occurrences (12,006 in generated `.bb`, 79 in local
`.bbappend`, 11 in local `.inc`).

The README's own definition of "unsupported" calls out `git://` needing replacement by `https://`
as a breakage signal. **Verified directly rather than assumed:** filtering out lines that already
carry `protocol=https`/`protocol=ssh` leaves **zero** results. Every occurrence already uses the
safe form — `git://` here is bitbake's fetcher-scheme identifier, not the deprecated anonymous
wire protocol. This category of breakage does not currently manifest anywhere in this repo.

**Effort:** None needed now.
**Next step:** Optional small lint (a few lines, could sit next to `check-patch-files.sh`) that
fails if a `git://` line lacks a `protocol=` qualifier, to catch a future regression early.

### 1.4 Skip-groups: actively maintained, but no re-check mechanism
**Where:** `scripts/generate-skip-groups.py`; output lands (via manual copy-paste, not automated)
in `<layer>/recipes-core/packagegroups/packagegroup-ros-world-<distro>.bb`. A related, separately
hand-authored mechanism, `SKIP_RECIPE[...]` in `<distro>/ros-distro-recipe-blacklist.inc`, gates
whole recipes off by license/feature flag (`qt5`, `gazebo`, `connext`, `aws`, `mongodb`, etc.).

**Counted scale:** 875 `SKIP_RECIPE[]` entries in noetic alone; 180–196 in each ROS2 distro layer;
194 in spaceros-jazzy. Both files are actively edited by humans (most recent touch: 2026-07-02 for
kilted's blacklist), so this isn't abandoned — but there is **no** re-check/expiry mechanism: zero
`TODO`/`FIXME`/date markers found anywhere explaining when a skip should be revisited. Skips
accumulate monotonically; nothing prunes ones that are now stale (e.g. a dependency that became
available in a newer OE release).

**Effort:** Medium.
**Next step:** Two independent, low-risk improvements: (1) wire `generate-skip-groups.py`'s
invocation into `generate_recipes.yml` (or a sibling workflow) so the skip block is regenerated
and diffed per distro on a cadence, surfacing newly-buildable packages as a PR instead of relying
on someone remembering to rebuild `world` by hand; (2) add a date/build-reference comment to each
`SKIP_RECIPE[]` entry so staleness becomes visible even without full automation.

### 1.5 `check-patch-files.sh` / Travis is not actually gating anything today (see also §6.1)
**Where:** `.travis.yml` → `scripts/check-patch-files.sh 'meta-ros*'`.

Ran the exact check Travis specifies against the current tree: **exit code 1, 351 violations**
(148 orphaned patches not referenced by any recipe, 203 patches missing an `Upstream-Status:`
line). If Travis were actually gating merges, this would be failing right now, and yet PRs
continue merging cleanly. Also: the glob `'meta-ros*'` does not match `meta-spaceros`/
`meta-spaceros-jazzy` at all, so even a reactivated check would silently skip those two layers.
`scripts/test-all.sh` is confirmed dead — it hardcodes a `./meta-ros/recipes-ros/` path structure
that hasn't existed since the pre-superflore layout.

**Effort:** Small to re-wire (delete dead config, or port the check into a GitHub Actions job);
Medium to actually clear the 351-violation backlog if reactivating.
**Next step:** Decide explicitly: retire `.travis.yml`/`test-all.sh` (removes misleading signal),
or port `check-patch-files.sh` into a GitHub Actions job — fixing the `meta-spaceros` glob and
clearing the backlog first so the new job doesn't go red on day one.

---

## 2. Documentation

### 2.1 No per-sub-layer READMEs (11 layers, 0 READMEs)
**Where:** `find . -maxdepth 2 -iname 'README*'` → only `./README.md`.

Anyone landing directly inside e.g. `meta-ros2-jazzy/` has zero in-directory context. This is
also a stated Yocto Project Compatible checklist expectation (see §4).

**Effort:** Medium. **Next step:** One shared short template (what this layer is, its
`LAYERSERIES_COMPAT`, link to root README) for the 9 "thin" layers; unique content for
`meta-ros-common` and `meta-ros2` (which host the dynamic-layers mechanism).

### 2.2 The `dynamic-layers` mechanism is undocumented in prose
**Where:** Zero hits for "dynamic-layers"/"BBLAYERS" in README.md/CONTRIBUTING.md. The mechanism
(optional deps on `meta-qt5`, `meta-qt6`, `meta-zenoh` via `meta-ros2`; `meta-python-ai` via
`meta-ros-common`) exists only in `conf/layer.conf` code.

A downstream integrator who wants PyQt5/PyQt6/Zenoh-backed ROS packages must add the right
upstream layer to their own `bblayers.conf` with an exactly-matching collection name
(`qt5-layer`, `qt6-layer`, `zenoh-layer`, `meta-python-ai`) — get it wrong, or not know the option
exists, and packages silently fail to build with no error pointing back to "you're missing an
optional layer."

**Effort:** Small. **Next step:** Add a table to README (or a new `docs/dynamic-layers.md`)
mapping `dynamic-layers/<name>` → required upstream layer → collection name → what it unlocks.

### 2.3 No architecture explanation of how the layer stack composes
**Where:** README.md's "ROS Layers" section is three short paragraphs; no diagram, no build-order
or `BBFILE_PRIORITY` explanation.

**Effort:** Medium. **Next step:** A short "Architecture" section/diagram: `core` +
`openembedded-layer` + `meta-python` → `meta-ros-common` → distro layer → optional
`dynamic-layers/*`.

### 2.4 No documented recipe-override (bbappend) workflow — highest first-contribution friction
**Where:** README.md's entire guidance is one sentence: "When changes are required against the
generated recipes, the bbappend files are created in `recipes-bbappends`."

Undocumented specifics a contributor has to reverse-engineer from examples: bbappend naming
convention (version-pinned vs. `_%` wildcard), why multiple `recipes-bbappends-<topic>` directory
variants exist per layer with no stated rule for when to create a new one (`recipes-bbappends-nav2`,
`-moveit2`, `-demos`, `-spaceros` all found), and the fact that `meta-ros-common` has **no**
`recipes-bbappends` directory at all — its recipes are hand-maintained, so the fix pattern there
is "edit directly," the opposite convention from the distro layers, discoverable only by noticing
the directory's absence.

**Effort:** Medium. **Next step:** A "Fixing a Recipe" walkthrough (root README or
`docs/recipe-overrides.md`) covering naming, when a topic-suffixed directory is warranted, and the
`meta-ros-common` exception.

### 2.5 LICENSE / `LIC_FILES_CHKSUM` conventions undocumented
**Where:** Zero hits for either term in README/CONTRIBUTING. `meta-ros-common/licenses/` holds 4
stock license texts referenced via `LICENSE_PATH`. A sampled bbappend
(`meta-spaceros-jazzy/.../ompl_1.6.0.bbappend`) overrides `LICENSE` without touching
`LIC_FILES_CHKSUM` — a real precedent, but the rule for when that's safe isn't written down.

**Effort:** Small. **Next step:** Short "Licensing" subsection in CONTRIBUTING.md.

### 2.6 `scripts/` tooling is mostly well-documented internally but entirely undiscoverable from top-level docs
**Where:** Zero mentions of `scripts/` in README/CONTRIBUTING. Per-script quality: `rename-bbappend.sh`,
`ros-cherrypick.sh`, `ros-generate-cache.sh`, `ros-generate-recipes.sh`, `test-all.sh` (though dead,
per §1.5) all have decent usage/help text. `generate-skip-groups.py` has a `usage()` function with a
minor bug (doesn't exit after printing it). `check-patch-files.sh` has **zero** usage documentation
— only a copyright header.

**Effort:** Small. **Next step:** A short table in CONTRIBUTING.md (or `scripts/README.md`)
listing all scripts and their purpose; add a two-line usage comment to `check-patch-files.sh`.

### 2.7 Milestone/superflore process is wiki-only, and the README's description of it appears stale
**Where:** README's "Tags" section describes a milestone-batch process (last one: 2022-06-05, per
README) pointing entirely to an external wiki page. But `.github/workflows/generate_recipes.yml`
— the pipeline actually in active use today (177 runs, most recent within the last ~7 weeks per
§1.1) — is a per-distro `workflow_dispatch` flow with **no milestone-tagging step at all**. Two
distinct problems: (a) the only detailed explanation lives on an unversioned external wiki page
(single point of failure), and (b) what the README currently says doesn't match what the repo
actually does today.

**Effort:** Small (interim caveat note) / Medium (full mirror-and-rewrite). **Next step:** Add an
interim note to the "Tags" section flagging milestones as legacy and linking the active
`generate_recipes.yml` mechanism; file a full `docs/superflore-process.md` mirror as a follow-up.
Confirm with a maintainer that milestones are formally discontinued before asserting it in writing
— this was inferred from workflow behavior, not stated explicitly anywhere.

### 2.8 README's "easiest way to get started" combo may be stale
**Where:** README.md: "The easiest way to get started... is to build the combination of Kirkstone
(Yocto Project) with Humble (ROS 2)." The support table directly above lists only
Wrynose/Whinlatter/Walnascar/Styhead/Scarthgap — Kirkstone doesn't appear in it at all.

**Effort:** Small. **Next step:** Confirm Kirkstone's actual status and update the recommendation
to a currently-listed combination (e.g. Scarthgap+Humble).

### 2.9 README's support table only covers ROS2 — no ROS1/Noetic row
**Where:** README.md's Yocto-release × ROS-distro table lists only ROS2 distros; ROS1 Noetic isn't
represented despite `meta-ros1`/`meta-ros1-noetic` being active, maintained sub-layers.

**Effort:** Small. **Next step:** Either add a Noetic row/column or state explicitly (near the
table) which Yocto releases Noetic is supported/best-effort against, so its omission reads as
deliberate rather than an oversight.

---

## 3. AI/agent guidance files

No `AGENTS.md`, `CLAUDE.md`, or equivalent exists anywhere in the repo today. Below is a concrete
draft for a root `AGENTS.md`, grounded in what this audit actually verified (generated-vs-bbappend
convention, dynamic-layers mechanism, branch model from README, DCO requirement from
CONTRIBUTING.md, and the `scripts/` inventory from §1/§2) — not boilerplate.

<details>
<summary><strong>Proposed root <code>AGENTS.md</code> (click to expand)</strong></summary>

```markdown
# meta-ros — Agent Guidance

meta-ros is a set of OpenEmbedded/Yocto layers (`meta-ros-common`,
`meta-ros1`, `meta-ros1-noetic`, `meta-ros2`, `meta-ros2-<distro>` for
Humble/Jazzy/Kilted/Lyrical/Rolling, `meta-spaceros`, `meta-spaceros-jazzy`)
that add ROS 1/ROS 2 recipe support to Yocto builds. Most recipe content in
this repo is **generated**, not hand-written. Read this before editing
anything under `recipes-*` or `generated-recipes`.

## The generated-vs-bbappend rule (most important convention)

- `generated-recipes/` and most `recipes-*/` content (outside
  `recipes-bbappends*`) is produced by the external `superflore` tool
  (https://github.com/ros-infrastructure/superflore) from ROS's
  `rosdistro` metadata, via `.github/workflows/generate_recipes.yml` and
  `scripts/ros-generate-recipes.sh`. **Never hand-edit a generated `.bb`
  file.** Any manual edit there is silently discarded the next time that
  distro's recipes are regenerated.
- To fix a broken/generated recipe, add or edit a `.bbappend` in the
  matching `recipes-bbappends*` directory of the same sub-layer, named
  after the recipe it overrides (e.g.
  `meta-ros2-humble/recipes-bbappends/rviz/rviz2_15.0.13-1.bbappend`).
  Prefer the `_%.bbappend` wildcard form over an exact-version filename
  where the fix isn't version-specific — exact-version bbappends silently
  stop applying (no error) once superflore bumps the recipe's `PV`.
  `scripts/rename-bbappend.sh` mechanically renames pinned bbappends when
  recipes are regenerated, but verify the underlying fix still makes sense
  against the new version before trusting the rename.
- Patch files carried in a bbappend must include an `Upstream-Status:`
  line and must actually be referenced by a recipe
  (`scripts/check-patch-files.sh` checks both; run it locally before
  submitting a patch-adding PR, since CI does not currently enforce this
  — see the audit report's CI-hygiene findings).
- **Exception:** `meta-ros-common` has no `recipes-bbappends` directory —
  its recipes are hand-maintained, not superflore-generated, so fixes
  there are made directly to the recipe.

## Layer layout

- `meta-ros-common` holds recipes/config shared across all ROS distros
  (3rd-party deps, image/packagegroup recipes) plus `conf/ros-distro/`.
- Each ROS distro gets its own sub-layer with its own `conf/layer.conf`,
  `LAYERVERSION_*`, `LAYERSERIES_COMPAT_*`, and `recipes-*` /
  `generated-recipes` / `recipes-bbappends*` directories.
- Optional dependencies on layers that aren't always present (`meta-qt5`,
  `meta-qt6`, `meta-zenoh` in `meta-ros2`; `meta-python-ai` in
  `meta-ros-common`) use OE's `dynamic-layers/<layer-name>/` mechanism,
  wired up via `BBFILES_DYNAMIC` in `conf/layer.conf`. If you add a new
  recipe that should only build when some other optional layer is
  present, put it under `dynamic-layers/<that-layer>/...` and add a
  matching `BBFILES_DYNAMIC` line — don't add a hard `LAYERDEPENDS` for
  something most users won't have.
- A second, older mechanism handles license-gated or heavy-optional-dep
  *packages* (not whole recipes): `ROS_WORLD_SKIP_GROUPS` combined with
  `SKIP_RECIPE[...]` entries in each distro's
  `ros-distro-recipe-blacklist.inc`, plus generated
  `RDEPENDS:${PN}:remove` blocks in each `packagegroup-ros-world-<distro>.bb`
  (produced by `scripts/generate-skip-groups.py`). Use `dynamic-layers`
  for "this whole recipe needs an optional layer"; use the skip-groups
  mechanism for "this package has a restrictive license or an
  unresolvable optional dependency but the recipe itself is fine."
- `LAYERVERSION_*_layer` is currently `"3"` across all sub-layers — each
  ROS distro lives in its own physical sub-layer with bbappend-based
  overrides. The project deliberately moved away from a single
  `ROS_DISTRO`-variable-selected layer (version 2) specifically so fixes
  could live in `.bbappend`s instead of `.inc` files; don't propose
  re-merging the distro layers without accounting for why that was
  changed (see each `conf/layer.conf`'s history comment).

## Branch model

- `master` tracks the Yocto Project release series currently under
  development.
- Branches named after Yocto releases (e.g. `scarthgap`, `wrynose`) track
  that release's support lifecycle; commit history there is linear —
  don't rebase/rewrite it.
- `<branch>-next` branches stage commits pending merge into the
  corresponding unsuffixed branch; history there *may* be rewritten, so
  treat it as unstable.
- `build` (a separate branch) carries the `mcf`/`kas`-based
  getting-started tooling.
- Recipe-regeneration PRs land on branches named
  `superflore/<yocto-release>/<ros_distro>/<date>`, opened by
  `.github/workflows/generate_recipes.yml`.

## Commit requirements

- Every commit must carry a DCO `Signed-off-by:` trailer (see
  CONTRIBUTING.md) — use `git commit -s`.
- Contributions are under the MIT license (`COPYING.MIT`) unless stated
  otherwise.

## `scripts/` — what's here and when to use it

- `ros-generate-cache.sh`, `ros-generate-recipes.sh` — the superflore
  regeneration pipeline invoked by `generate_recipes.yml`; run locally
  only to reproduce/debug that workflow.
- `rename-bbappend.sh` — renames existing bbappends to match a newly
  regenerated recipe's version string.
- `generate-skip-groups.py` — regenerates the skip-groups block for a
  distro's `packagegroup-ros-world-<distro>.bb` from a bitbake cooker
  log; its output must currently be pasted in by hand.
- `check-patch-files.sh <dir-glob>` — validates that every `.patch` file
  under the given path has an `Upstream-Status:` line and is referenced
  by some recipe. Run this yourself before submitting a PR that adds or
  touches a patch file — it is not currently wired into any active CI
  check.
- `ros-cherrypick.sh` — ports bbappend patches between ROS-distro layers
  within the same Yocto branch (e.g. humble → iron); see its header
  comment for a worked example.

## Before you touch a recipe

1. Is this file under `generated-recipes/` or an ungenerated `recipes-*`
   path? If yes, don't edit it directly — add a `.bbappend` under the
   matching `recipes-bbappends*` directory instead (except
   `meta-ros-common`, see above).
2. Does the fix belong in one distro's layer, or is it common to all ROS
   distros? Common fixes belong in `meta-ros-common`; distro-specific
   ones in that distro's sub-layer.
3. If adding a dependency on a layer that isn't `core`/`meta-python`/
   `openembedded-layer`/`ros-common-layer` (the current hard
   `LAYERDEPENDS` set), it should almost certainly be a `dynamic-layers`
   optional dependency instead of a hard one — check first.
```

</details>

**Effort:** Small (this content is ready to land as-is; adjust wording to house style).
**Next step:** Land as `AGENTS.md` at repo root. Consider short nested `AGENTS.md` files in
`meta-ros-common/` (documents the `dynamic-layers/meta-python-ai` pattern and shared
`conf/ros-distro/` convention) and `scripts/` (per-script usage) once the root file is validated —
don't add these speculatively before the root one proves useful.

---

## 4. Yocto Project Compatible Program readiness

Assessed against the current YP Compatible layer checklist. `yocto-check-layer` itself is **not
installed in this environment** (`which yocto-check-layer` → not found) — it ships as part of
OE-core (`scripts/yocto-check-layer` in a poky/OE-core checkout), so running it for real requires
a full BitBake build environment with this repo's layers added to `bblayers.conf`. That setup is
out of scope for this read-only pass; noted as **unknown/needs environment** below where the
checklist item can only be confirmed by actually running the tool.

| Checklist item | Status | Detail |
|---|---|---|
| `layer.conf` parses / standard `BBFILE_*` vars set | **Met** | All 11 `conf/layer.conf` files set `BBPATH`, `BBFILES`, `BBFILE_COLLECTIONS`, `BBFILE_PATTERN_*`, `BBFILE_PRIORITY_*` correctly and consistently. |
| `LAYERSERIES_COMPAT` accuracy | **Met** | *Correction from an earlier draft of this report:* meta-ros uses a branch-per-Yocto-release model, not a single branch declaring compatibility with every supported series. This audit initially inspected only the checked-out `master` ref (where all 11 layers set `LAYERSERIES_COMPAT_*_layer = "wrynose"`) and incorrectly read that as a gap against Scarthgap support. Checking the `scarthgap` branch directly (`git show remotes/origin/scarthgap:meta-ros2/conf/layer.conf`) confirms it sets `LAYERSERIES_COMPAT_ros2-layer = "scarthgap"` exclusively, and likewise across `meta-ros-common` and presumably the other sub-layers on that branch. `master`/`master-next` (tracking the latest Yocto release) is correctly `"wrynose"`-only. This is deliberate and correct per-branch scoping, not a defect — no action needed. |
| License file / `LIC_FILES_CHKSUM` sanity | **Mostly met** | Top-level `COPYING.MIT` covers the whole repo. Generated recipes carry real `LIC_FILES_CHKSUM` values referencing `package.xml` with real md5 hashes (spot-checked, e.g. `LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=..."` — not placeholder/generated stubs). `meta-ros-common/licenses/` supplies 4 stock license texts via `LICENSE_PATH`. No individual sub-layer has its own `LICENSE`/`COPYING` file, but since this is a single-repo, single-license (MIT) monorepo with one root `COPYING.MIT`, this is a soft gap rather than a hard checklist failure — worth a maintainer decision on whether per-layer license files are wanted for layers that might be consumed independently. |
| No hardcoded absolute paths | **Mostly met** | Grep for `/home/<user>` across all `.bb`/`.bbappend`/`.inc` found only 2 matches repo-wide (`meta-ros2/recipes-benchmark/google-benchmark/google-benchmark_git.bb`, `meta-ros1-noetic/.../packagegroup-ros-world-noetic.bb`) — worth a quick manual look at those two specifically, but this is not a systemic problem. |
| No network access at build time (outside fetch tasks) | **No issue found** | Searched for `wget`/`curl` invocations inside non-fetch tasks (`do_configure`/`do_compile`) — no genuine hits after checking context (initial grep matches were false positives from an overly broad OR pattern). |
| `yocto-check-layer` compliance | **Unknown — needs environment** | Tool not available in this checkout/environment. To verify: check out `poky` (or standalone `bitbake` + `openembedded-core` + `meta-openembedded`), add all 11 meta-ros layers to `bblayers.conf`, then run `yocto-check-layer --dependency <core-layers> <path-to-each-meta-ros-layer>` (or `--with-software-layer-check` for the strict variant). This is the single highest-value unknown in this section — everything else here is inferred from static analysis; this tool would catch parse errors, signature/reproducibility issues, and README-format issues directly. |
| README format expectations | **Unmet** | The standard OE layer README template expects, per layer: a description, a `Dependencies` section (naming required layers), a `Patches` section, and a maintainer contact. This repo's single root README is a project-level overview (support matrix, getting started, branch model, history) and does **not** follow that per-layer template for any of the 11 sub-layers — ties directly to finding §2.1 (no per-sub-layer READMEs) and is the most concrete, actionable checklist gap identified in this audit. |
| Maintainer contact / `MAINTAINERS` file | **Unmet** | No `MAINTAINERS` file anywhere in the repo (`find . -maxdepth 2 -iname 'MAINTAINERS*'` → no results). Contact info exists only diffusely (README points to GitHub issues/discourse/a working-group doc), not as a structured, checklist-expected maintainer list. |

**Effort:** Medium for README-format compliance (ties to §2.1). Small for adding a `MAINTAINERS`
file. Medium (environment setup, one-time) to actually run `yocto-check-layer` and close out the
"unknown" row.

**Next step, in order of leverage:** (1) set up a throwaway poky/OE-core checkout with meta-ros
layers added and run `yocto-check-layer` to convert the one "unknown" row into concrete findings;
(2) add a `MAINTAINERS` file; (3) fold README-format compliance into the §2.1 per-layer-README
work already planned.

---

## 5. Modernization opportunities

### 5.1 The existing `dynamic-layers` pattern (Qt5/Qt6/Zenoh, python-ai) is correct and current — use as the template
**Where:** `meta-ros2/conf/layer.conf`, `meta-ros-common/conf/layer.conf`, and their
`dynamic-layers/` subdirectories. Confirmed this is BitBake's current, non-legacy mechanism
(`BBFILES_DYNAMIC`) for optional-layer content — no changes needed. Positive finding, useful as
the reference pattern for anything below.

### 5.2 No further dynamic-layers candidates found — audited all hard `LAYERDEPENDS`
**Where:** Every `LAYERDEPENDS_*` across all 11 layer.conf files traces back to only `core`,
`meta-python`, `openembedded-layer`, and the internal meta-ros chain. Checked plausible candidates
seen in other Yocto histories (rust/cargo, clang/llvm, gstreamer bad/ugly plugins, ffmpeg/x264,
docker) — each is either a single-recipe, already-license-gated, or already-excluded-from-world-build
case, not a hard layer dependency issue. **This is a negative/confirming finding**, worth stating
explicitly so this ground isn't re-investigated later: the maintainers have already captured the
real optional-dependency opportunities.

### 5.3 Two coexisting "make it optional" mechanisms — worth documenting, not consolidating
**Where:** `dynamic-layers` (whole recipes gated on an optional layer) vs. `ROS_WORLD_SKIP_GROUPS`
+ `SKIP_RECIPE[...]` (individual packages gated by license/feature flag, superflore-generated).
Diffing `packagegroup-ros-world-humble.bb` against `-jazzy.bb` showed the differences are largely
genuine per-distro package-list differences, not artificial duplication ripe for templating.

**Effort:** Small. **Next step:** Document both mechanisms and when each applies (folds into the
AGENTS.md content in §3, already included there).

### 5.4 Minor `LAYERRECOMMENDS` gaps
**Where:** `meta-ros2/conf/layer.conf:32` sets `LAYERRECOMMENDS_ros2-layer = "qt6-layer zenoh-layer"`
but omits `qt5-layer`, even though `dynamic-layers/meta-qt5/` has real content. `meta-ros-common`
sets `BBFILES_DYNAMIC` for `meta-python-ai` but never sets any `LAYERRECOMMENDS_ros-common-layer`
at all — makes that optional path less discoverable to tooling than qt6/zenoh, by omission.

**Effort:** Small. **Next step:** Add `qt5-layer` to `LAYERRECOMMENDS_ros2-layer`, and add
`LAYERRECOMMENDS_ros-common-layer = "meta-python-ai-layer"` (verify exact collection name) to
`meta-ros-common/conf/layer.conf`.

### 5.5 Recent Yocto tooling (`OE_FRAGMENTS`/`bitbake-setup`, Walnascar/Whinlatter 2025) is not a fit yet
**Where (external research):** Yocto 5.2 "Walnascar" (Oct 2025) introduced configuration
fragments (`conf/fragments/`, `bitbake-config-build enable-fragment`) and an in-progress
`bitbake-setup` tool intended to eventually replace the combined `poky` repo checkout. Per direct
comparison against kas (sigma-star.at, Oct 2025), `bitbake-setup` currently has no multi-file
include/compose support and is explicitly less capable than kas for exactly meta-ros's situation
(many near-identical per-distro configs). Fragments themselves target `local.conf`-style toggles
(machine, sstate mirror, tuning), not meta-ros's actual duplication problem (full per-distro
recipe trees). **Opinion: not a meaningful win now; revisit in 12-18 months.**

**Effort:** N/A now. **Next step:** No action; re-evaluate once `bitbake-setup` matures past its
first release, or if kas maintenance shows signs of stalling.

### 5.6 kas composition features (`includes`/`defaults`/`overrides`) — likely under-exploited, but unverifiable from this checkout
**Where:** kas has had `defaults`/`overrides` sections and file-composition via `includes:` for
some time — exactly the mechanism that would let a base ROS2 kas config + 5 thin per-distro
overlay files replace N near-independent full kas files. **This cannot be confirmed here**: the
actual kas files live on the external `build` branch (referenced from README, not part of this
checkout), so this audit cannot say whether they already use these features or are ~10 full
copies. This is the single most actionable "go check this" item from the modernization research.

**Effort:** Medium (once accessible). **Next step:** A follow-up pass checking out the `build`
branch specifically to inspect `kas/*.yml` for `includes`/`defaults`/`overrides` usage before
drawing conclusions about onboarding duplication.

### 5.7 meta-ros is already on the OpenEmbedded Layer Index — no action needed
**Where (external research):** `meta-ros`, `meta-ros1`, `meta-ros2`, `meta-ros-common`, etc. are
already indexed at layers.openembedded.org (the index even reflects retired layers like
`meta-ros2-galactic`, confirming it's actively maintained, not stale). Standard tooling
(`bitbake-layers layerindex-fetch`) should already work. **Negative finding — this was a
plausible modernization candidate going in, but it's already done.**

**Effort:** Small (verification only). **Next step:** Spot-check that the newer sub-layers
specifically (`meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-spaceros-jazzy`) are indexed too, not
just the parent `meta-ros2`/`meta-spaceros`.

### 5.8 No new bitbake/OE-core primitive exists for collapsing the 5 parallel distro layers
**Where (external research):** Checked recent Yocto release notes (Scarthgap through Wrynose) for
anything new that would let `BBFILE_COLLECTIONS`/layer.conf definitions be templated across
near-identical layers. Nothing found — this remains a fundamentally one-layer.conf-per-collection
model. **Sets expectations correctly for the roadmap below: "collapse the 5 layers into 1" is not
a currently-available, low-effort win**, and the project already deliberately moved away from a
single variable-selected layer once before (§5's history note, also in the AGENTS.md draft) — any
future re-merge proposal needs to explain why it won't reintroduce that problem.

---

## 6. Opportunistic hygiene findings

### 6.1 `.travis.yml` is dead configuration, actively misleading
**Where:** `.travis.yml` (unchanged in substance since 2020-09-16, no badge/mention anywhere in
README/CONTRIBUTING). Confirmed dead by literally running the check it specifies (§1.5): it would
fail with 351 violations right now, yet PRs merge cleanly, meaning Travis is not actually gating
this GitHub repo. `scripts/test-all.sh` is similarly dead (hardcodes a pre-superflore directory
layout that no longer exists). No GitHub Actions equivalent exists for the patch-file check
`check-patch-files.sh` performs.

**Effort:** Small. **Next step:** Same as §1.5 — either delete `.travis.yml`/`test-all.sh`
outright, or replace with a GitHub Actions job running `check-patch-files.sh` (after fixing its
`meta-spaceros` glob gap and clearing the current backlog).

### 6.2 `docs/AUDIT_PROMPT.md` is audit scaffolding, not project documentation
**Where:** `docs/` currently contains only `AUDIT_PROMPT.md`, the task brief for this audit — not
documentation for contributors/users. Flagged only so this report and any follow-up work don't
miscount `docs/` as already having real content. If §2.4 (recipe-override guide) or §2.7
(superflore-process mirror) get written, this becomes the first genuine occupant of that
directory.

**Effort:** N/A. **Next step:** None required; informational.

---

## Phased roadmap

Fixing everything here at once isn't realistic for a layer of this size (~12,000 recipes across
11 sub-layers). Suggested phasing, ordered by value-for-effort:

### Phase 0 — This week, near-zero effort, high value
1. **Retire or replace `.travis.yml`/`test-all.sh`** (§1.5, §6.1) — dead config that actively
   misrepresents CI coverage; either delete it or port the (otherwise sound) patch-file check into
   a real GitHub Actions job.
2. **Fix the two `LAYERRECOMMENDS` omissions** (§5.4) — two one-line edits.

### Phase 1 — Next few weeks, documentation-only, no code risk
3. **Document the `dynamic-layers` mechanism and the recipe-override (bbappend) workflow**
   (§2.2, §2.4) — the two highest-friction, purely-missing pieces of documentation, both
   pure-prose additions to README or new `docs/` files.
4. **Land the root `AGENTS.md`** drafted in §3 — ready to use as-is, captures the
   generated-vs-bbappend convention, both optionality mechanisms, and the branch/DCO model.
5. **Add scheduled + matrix trigger to `generate_recipes.yml`** (§1.1) — closes the `rolling`
   drift risk (currently 3.5 months stale) without needing new tooling, just a workflow YAML change.

### Phase 2 — Next quarter, medium effort
6. **Set up a throwaway `yocto-check-layer` run** (§4) to convert the one remaining "unknown"
   checklist row into concrete, actionable findings.
7. **Write per-sub-layer READMEs** (§2.1) using the shared template from Phase 1's documentation
   work — this also closes the YP-Compatible README-format gap (§4).
8. **Audit the external `build` branch's kas files** (§5.6) for `includes`/`defaults`/`overrides`
   usage — the one modernization question this pass couldn't answer from this checkout.
9. **Wire `generate-skip-groups.py` into CI** (§1.4) so skip lists get periodically re-diffed
    instead of accumulating forever.

### Longer-term / lower urgency
- Mirror the superflore/milestone process into `docs/superflore-process.md` (§2.7), after
  confirming with a maintainer that milestones are formally superseded.
- Add a `MAINTAINERS` file (§4).
- Backfill missing `SRCREV` pin comments across the ~74 vendor-package bbappends (§1.2).
- Re-evaluate `OE_FRAGMENTS`/`bitbake-setup` in 12-18 months (§5.5) — not actionable today.

**Highest-value-for-lowest-effort starting point, if only 2-3 items are picked:** items 1, 2, and
3 above — each is small, isolated, and fixes something either actively broken (dead CI) or
actively costly to new contributors (undocumented bbappend workflow), with no risk to the recipe
corpus itself.
