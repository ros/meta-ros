# meta-ros Audit Remediation — Implementation Specification

**Purpose:** This is an execution spec derived from
[`meta-ros-layer-audit-2026-08.md`](meta-ros-layer-audit-2026-08.md). It turns that audit's
phased roadmap into discrete, independently-completable tasks grouped into milestones, so a Claude
session (or a human contributor) can pick it up and execute it without re-deriving the audit's
reasoning. Each task cites the audit section it comes from — read that section if the "why" isn't
obvious from the task alone.

**How to use this doc:** Work milestone by milestone, in order — later milestones assume earlier
ones landed (e.g. M1's `AGENTS.md` should exist before M2's per-layer READMEs reference it). Within
a milestone, tasks are independent of each other and can be done in any order or in parallel. Check
off each task's acceptance criteria before moving on; don't batch unrelated tasks into one commit.

**Environment scoping:** Every task is tagged with the environment it needs. **Milestones 0-2
require only a clone of this repo** (git, a shell, and for M1-4 access to GitHub's API/CLI) — no
Yocto/bitbake/poky checkout, no build. **Milestone 3 requires a full Yocto build environment**
(a poky/OE-core checkout capable of actually running bitbake against these layers) and is
explicitly deferred — do not start it until Milestones 0-2 are done and someone has set up that
environment. This ordering was a deliberate reprioritization: start with everything the repo clone
alone can accomplish.

---

## Standing constraints (apply to every task below)

These come from the audit's own findings (§3 `AGENTS.md` draft, §1) — restated here so this spec
is self-contained:

- **Never hand-edit a generated recipe.** Anything under `generated-recipes/` or an ungenerated
  `recipes-*` path (outside `recipes-bbappends*`) is superflore output and gets silently
  overwritten on the next regen. Fixes go in a `.bbappend` under the matching `recipes-bbappends*`
  directory instead — except `meta-ros-common`, which has no `recipes-bbappends` directory and is
  edited directly (it isn't superflore-generated the same way).
- **This is a branch-per-Yocto-release repo, not a single-branch repo.** `master` tracks the
  current dev release; branches named after Yocto releases (`scarthgap`, `wrynose`, etc.) track
  that release's support lifecycle; `<branch>-next` branches stage pending changes. **Before
  starting any task, check whether the file(s) it touches are branch-specific** (e.g.
  `conf/layer.conf`'s `LAYERSERIES_COMPAT` is deliberately different per branch — do not
  "normalize" it across branches) **or repo-wide and need porting to every active branch** (e.g. a
  root `README.md` or `AGENTS.md` addition likely needs to land on `master` and then be
  cherry-picked or independently applied to `wrynose`/`scarthgap` and their `-next` counterparts —
  check `scripts/ros-cherrypick.sh` before doing this by hand). Flag ambiguous cases rather than
  guessing.
- **Every commit needs a DCO sign-off** (`git commit -s`), per `CONTRIBUTING.md`.
- **Don't scope-creep.** Each task below is deliberately narrow. If a task surfaces a related but
  out-of-scope issue, note it rather than fixing it inline — add it to a future milestone instead.
- **This spec does not authorize pushing branches, opening PRs, merging, or dispatching workflows
  against the live repo.** Prepare commits/workflow changes locally and stop for review unless
  explicitly told otherwise. This especially applies to M1-4 — do not enable it against the real
  `ros/rosdistro` repo and the real `generate_recipes.yml` workflow without an explicit go-ahead,
  since it can trigger real automated PRs.

---

## Milestone 0 — Immediate, near-zero risk

**Environment:** repo clone only.

Goal: remove actively-misleading signals with no code risk. No recipe or build-behavior changes.

### Task M0-1: Retire or replace dead CI (`.travis.yml` / `test-all.sh`)
- **Audit ref:** §1.5, §6.1
- **Problem:** `.travis.yml` invokes `scripts/check-patch-files.sh 'meta-ros*'`, which currently
  fails with 351 violations (148 orphaned patches, 203 missing `Upstream-Status:` lines) — proof
  Travis isn't actually gating this repo, since PRs merge cleanly despite this. `scripts/test-all.sh`
  is dead: it hardcodes a pre-superflore `./meta-ros/recipes-ros/` path that no longer exists.
  Also note: the `'meta-ros*'` glob in `.travis.yml` never matched `meta-spaceros`/
  `meta-spaceros-jazzy` even when the check was presumably live.
- **Do:**
  1. Confirm with repo history / ask the maintainer whether Travis is intentionally retained for
     some external reason before deleting anything (the audit inferred it's dead from behavior, not
     from a maintainer statement).
  2. Choose one:
     - **(a) Delete:** remove `.travis.yml` and `scripts/test-all.sh`.
     - **(b) Replace:** add a GitHub Actions workflow (e.g.
       `.github/workflows/check-patch-files.yml`) that runs `scripts/check-patch-files.sh` against
       all layers, fixing the glob to also cover `meta-spaceros*`, then delete `.travis.yml` and
       `scripts/test-all.sh`.
  3. If choosing (b), the 351 existing violations must be cleared first (or the check scoped to
     only new patches) so the new job doesn't fail on day one — this is a separate, larger cleanup;
     don't silently suppress it.
- **Acceptance criteria:** `.travis.yml` and `scripts/test-all.sh` no longer exist, or are
  superseded by a working, passing GitHub Actions job covering all layers including
  `meta-spaceros*`. Either way, no dead/misleading CI config remains referencing a check that isn't
  actually enforced.
- **Branch scope:** Check whether `.travis.yml`/`test-all.sh` exist on other active branches
  (`wrynose`, `scarthgap`) and apply the same fix there if so.

### Task M0-2: Fix `LAYERRECOMMENDS` omissions
- **Audit ref:** §5.4
- **Problem:** `meta-ros2/conf/layer.conf` sets `LAYERRECOMMENDS_ros2-layer = "qt6-layer zenoh-layer"`,
  omitting `qt5-layer` even though `meta-ros2/dynamic-layers/meta-qt5/` has real content.
  `meta-ros-common/conf/layer.conf` declares `BBFILES_DYNAMIC` for `meta-python-ai` but sets no
  `LAYERRECOMMENDS_ros-common-layer` at all.
- **Do:**
  1. In `meta-ros2/conf/layer.conf`, change `LAYERRECOMMENDS_ros2-layer = "qt6-layer zenoh-layer"`
     to include `qt5-layer` as well.
  2. In `meta-ros-common/conf/layer.conf`, add a `LAYERRECOMMENDS_ros-common-layer` line
     referencing the correct collection name for `meta-python-ai` — verify the exact collection
     name declared by that layer (don't assume; check its own `layer.conf` if vendored, or the
     `BBFILES_DYNAMIC` prefix used in `meta-ros-common/conf/layer.conf`).
- **Acceptance criteria:** Both `conf/layer.conf` files' `LAYERRECOMMENDS_*` lines list every
  collection with a corresponding `dynamic-layers/` directory in that layer.
- **Branch scope:** This is layer-content, not release-compat metadata, so it should port to every
  active branch that has the same `dynamic-layers/meta-qt5` and `dynamic-layers/meta-python-ai`
  directories — check each active branch individually rather than assuming uniformity.

---

## Milestone 1 — Documentation & automation foundation

**Environment:** repo clone only (M1-4 additionally needs `git`/`gh` CLI access to query
GitHub's API for the `ros/rosdistro` repo's tags — still no Yocto build environment).

Goal: close the highest-friction, purely-missing documentation gaps, and replace manual-only
recipe regeneration triggering with an automated, tag-driven check. No bitbake execution involved
in any of these tasks.

### Task M1-1: Document the `dynamic-layers` mechanism
- **Audit ref:** §2.2
- **Problem:** No prose anywhere explains that `meta-qt5`/`meta-qt6`/`meta-zenoh`/`meta-python-ai`
  are optional layers a downstream integrator must add themselves, with exact collection names, to
  unlock Qt/Zenoh/python-ai-backed ROS packages.
- **Do:** Add a section to `README.md` (or a new `docs/dynamic-layers.md` linked from README)
  containing a table: `dynamic-layers/<name>` directory → required upstream layer (repo) → exact
  collection name (`qt5-layer`, `qt6-layer`, `zenoh-layer`, and whatever M0-2 confirms for
  `meta-python-ai`) → what functionality it unlocks. Source the collection names from the actual
  `conf/layer.conf` files, not from memory.
- **Acceptance criteria:** A reader unfamiliar with OE's `BBFILES_DYNAMIC` mechanism can, from this
  doc alone, correctly add `meta-qt6` to their `bblayers.conf` and know it will activate the right
  recipes.

### Task M1-2: Document the recipe-override (bbappend) workflow
- **Audit ref:** §2.4
- **Problem:** The only guidance today is one sentence in README. Undocumented: bbappend naming
  convention (version-pinned vs. `_%` wildcard, and why wildcard is generally preferable), what the
  various `recipes-bbappends-<topic>` directory variants are for (`-nav2`, `-moveit2`, `-demos`,
  `-spaceros` exist) and when a new one is warranted, and the `meta-ros-common` exception (no
  `recipes-bbappends` dir — edit directly).
- **Do:** Add a "Fixing a Recipe" walkthrough — either a new section in `README.md` or
  `docs/recipe-overrides.md` (linked from README). Cover: how to locate the generated recipe for a
  package, how to name a new bbappend (prefer `_%.bbappend` unless the fix is version-specific),
  when to create vs. reuse a topic-suffixed `recipes-bbappends-<topic>` directory, and the
  `meta-ros-common` direct-edit exception. Use at least one real example bbappend from the repo
  (e.g. `meta-spaceros-jazzy/recipes-bbappends-nav2/ompl/ompl_1.6.0.bbappend`, referenced in the
  audit) to ground the walkthrough concretely.
- **Acceptance criteria:** A first-time contributor with a "this generated recipe is broken, how do
  I fix it" task can follow this doc start-to-finish without reading multiple existing bbappends to
  reverse-engineer the convention.

### Task M1-3: Land the root `AGENTS.md`
- **Audit ref:** §3 (full draft included there)
- **Do:** Copy the draft `AGENTS.md` content from §3 of the audit report to a new file
  `AGENTS.md` at the repo root. Adjust wording only if it conflicts with house style; don't
  substantively rewrite it without reason — it was drafted from verified findings, not boilerplate.
  Cross-link it from `README.md`/`CONTRIBUTING.md` if there's a natural place to do so.
- **Acceptance criteria:** `AGENTS.md` exists at repo root and accurately reflects the
  generated-vs-bbappend convention, both optionality mechanisms (`dynamic-layers` vs.
  `ROS_WORLD_SKIP_GROUPS`), the branch model, and the DCO requirement.
- **Branch scope:** Land on `master` first; port to `wrynose`/`scarthgap` (and `-next` branches) as
  a repo-wide doc file, same as M1-1/M1-2.

### Task M1-4: Replace manual dispatch with a tag-driven scheduled trigger
- **Audit ref:** §1.1 (revised design per explicit follow-up direction — supersedes the audit's
  original "just add a schedule + matrix" suggestion with a real trigger mechanism)
- **Problem:** `.github/workflows/generate_recipes.yml` only has a `workflow_dispatch` trigger — a
  human must manually pick a branch and a ROS distro and click "Run workflow," per combination.
  `rolling` was 3.5 months stale at time of audit; `humble`/`jazzy`/`kilted`/`lyrical` were
  4.5-7.5 weeks stale. The real signal that new recipes *should* be generated is upstream:
  `ros/rosdistro` (https://github.com/ros/rosdistro) tags each ROS distro release as
  `<ROS_DISTRO>/<RELEASE_DATE>` (e.g. `humble/2026-07-15`) — `generate_recipes.yml` already reads
  this exact tag format today (`git tag --list "${ROS_DISTRO}/*" | sort | tail -n1`, then
  `cut -d/ -f2` for the date) when a run is manually dispatched. What's missing is a trigger that
  *notices a new tag exists* without a human checking.

- **Design:**
  1. **New workflow**, e.g. `.github/workflows/check-rosdistro-tags.yml`, with two triggers:
     `schedule:` (daily cron, e.g. `cron: '17 6 * * *'` — avoid the top-of-hour stampede other
     repos' cron jobs pile onto) and `workflow_dispatch:` (for manual testing/debugging).
  2. **List candidate tags** without a full clone of `ros/rosdistro` — `git ls-remote --tags
     https://github.com/ros/rosdistro.git` is enough to get tag names (and the `rosdistro` repo is
     large; avoid a full checkout for this check). Filter tag names to the ones matching
     `^(noetic|humble|jazzy|kilted|lyrical|rolling)/[0-9]{4}-[0-9]{2}-[0-9]{2}$` (confirm the exact
     date format rosdistro actually uses by inspecting a handful of real tags before hardcoding a
     regex).
  3. **Recency filter — use the date embedded in the tag name itself, not a separate commit-date
     lookup.** The release date is literally the second path segment of the tag
     (`<distro>/<date>`), which is exactly what `generate_recipes.yml` already extracts. No need to
     `git log`/query commit timestamps for this step — parse the tag name, compare the date to
     "today." Keep only tags within a **configurable window** (start with 30 days, not 7 — see
     rationale below) to bound how many tags get considered per run.
     - **Window sizing rationale:** the ask was "within the past calendar week or month" — use the
       *month*-scale window (~30 days) rather than a week. A daily cron with only a 7-day window
       means any outage/failure of the cron job for more than a week causes a tag to silently age
       out of the window and never get picked up at all. A 30-day window gives real slack for
       missed runs while still keeping the tag list small (rosdistro doesn't produce many
       per-distro tags in a 30-day span). This is a judgment call, not a hard requirement — flag it
       for maintainer sign-off, don't treat 30 as final without confirming.
  4. **Dedup — compare the candidate tag's date against what this repo has already processed for
     that distro, per target branch.** Preferred source of truth: `ros-generate-cache.sh` already
     records `ROS_DISTRO_RELEASE_DATE` (and `ROS_SUPERFLORE_GENERATION_COMMIT`) into a committed
     `.inc` file as part of every prior sync (confirmed present in this repo — locate the exact
     path per distro, e.g. under `<layer>/files/<distro>/generated/`, before wiring this up). Read
     that file's recorded release date for the branch/distro being checked; if the candidate tag's
     date is not newer than the recorded date, skip — this distro is already up to date with that
     tag. Fallback, if the `.inc` value is awkward to parse in a lightweight cron job: derive the
     same information from `git log --grep="{<distro>} Sync to files"` on the target branch (the
     recipe-currency audit used this same grep to compute per-distro staleness) and parse the
     recorded date out of that commit's message/diff instead. Prefer the `.inc` file if both are
     viable — it's the value the pipeline itself already treats as authoritative.
  5. **In-flight check — don't double-trigger while a previous run's PR is still open.** Before
     dispatching, check for an existing open PR / pushed branch matching
     `superflore/<yocto-release>/<ros_distro>/*` (`gh pr list --state open --search
     "superflore/<branch>/<distro>"` or equivalent). If one exists, skip dispatching again for that
     distro this run — let the open PR get reviewed/merged first, rather than piling up duplicate
     regeneration branches for the same distro.
  6. **Dispatch** the existing `generate_recipes.yml` workflow for each distro that is (a) recent,
     (b) newer than what's recorded as last-processed, and (c) has no open in-flight PR — via
     `gh workflow run generate_recipes.yml -f ros_distro=<distro> -f dry_run=false` (or the
     equivalent REST call). **Note the token-permission question below before assuming this
     works as-is.**

- **Open design questions to resolve before enabling this against the real repo** (flag these,
  don't silently guess):
  - **Cross-branch fan-out:** `generate_recipes.yml` runs in the context of one Yocto-release
    branch and opens its PR against `$GITHUB_REF_NAME`. Does the new tag-watcher need to check
    and dispatch across *every* active branch (`master`, `wrynose`, `scarthgap`, ...), or only the
    current-dev-release branch (with older branches staying on manual/best-effort dispatch, which
    seems to match today's actual usage pattern per the audit's per-distro staleness table)? This
    materially changes the workflow's fan-out logic and needs a maintainer decision, not an
    assumption.
  - **Token permissions:** the default `GITHUB_TOKEN` often cannot trigger `workflow_dispatch` on
    another workflow (this is a common GitHub Actions gotcha, to avoid recursive-workflow abuse).
    Confirm whether a PAT/secret is already available (`generate_recipes.yml` already uses
    `secrets.GITHUB_TOKEN` for PR creation — check whether that scope is sufficient for
    `workflow_dispatch` too, or whether a separate token is needed) before assuming the dispatch
    step will just work.
  - **`.inc` file path/format:** confirm the exact per-distro path and field name for the recorded
    `ROS_DISTRO_RELEASE_DATE` by reading `scripts/ros-generate-cache.sh` and a real committed
    example, rather than guessing the path in the workflow YAML.

- **Acceptance criteria:** A scheduled (daily) run, with no manual action, correctly identifies
  which distros have a genuinely new (recent, not-yet-processed, not-already-in-flight)
  `ros/rosdistro` release tag, and dispatches `generate_recipes.yml` only for those — verified by
  a dry run (`workflow_dispatch` with a controlled/mocked tag list, or a `dry_run: true` pass)
  that shows correct skip/dispatch decisions against a few known real tags before it's ever run
  live and unattended.
- **Branch scope:** Per the open design question above, confirm whether this new workflow file
  itself needs to exist on every active branch or just `master` before assuming a single addition
  covers the whole repo.
- **Do not enable this against the live repo** (real cron, real dispatch) without explicit
  sign-off — per the standing constraints, this task produces a reviewed, tested workflow file,
  not a live-triggered automation, until someone explicitly approves turning it on.

---

## Milestone 2 — Structural work, repo clone only

**Environment:** repo clone only. (Distinguish this from Milestone 3, which needs a Yocto build
environment — these two were split apart specifically so Milestone 2 can proceed without one.)

Goal: close remaining repo-only documentation/structure gaps.

### Task M2-1: Write per-sub-layer READMEs
- **Audit ref:** §2.1, §4 (README-format checklist gap)
- **Problem:** None of the 11 sub-layers has its own README. This is both a discoverability gap and
  a YP-Compatible-checklist gap (standard layer READMEs are expected to cover description,
  dependencies, patches, and maintainer contact).
- **Depends on:** M1-1, M1-2, M1-3 landing first (per-layer READMEs should link back to the
  root-level docs those tasks create, not duplicate them).
- **Do:**
  1. Draft one shared template covering: what this layer is, its `LAYERSERIES_COMPAT` (per-branch,
     see standing constraints), a link to the root `README.md`, and a link to the recipe-override
     workflow doc from M1-2.
  2. Apply the template to the 9 "thin" layers (`meta-ros1`, `meta-ros1-noetic`, `meta-ros2-humble`,
     `meta-ros2-jazzy`, `meta-ros2-kilted`, `meta-ros2-lyrical`, `meta-ros2-rolling`, `meta-spaceros`,
     `meta-spaceros-jazzy`).
  3. Write unique, fuller content for `meta-ros2` and `meta-ros-common` — these host the
     `dynamic-layers` mechanism and warrant more than the shared template (link to M1-1's doc
     specifically).
- **Acceptance criteria:** All 11 sub-layers have a `README.md` (or `README.md` file at their root)
  covering at minimum: description, dependencies, and a maintainer/contact pointer.

### Task M2-2: Audit the `build` branch's kas files — DONE
- **Audit ref:** §5.6
- **Status:** Completed. `git show origin/build:kas/...` was used to inspect the composition
  without switching this working tree's branch. Result: **already well-composed**, not the ~10
  independent full copies the audit worried about. `kas/oeros-<yocto>-<distro>-<machine>.yml`
  combo files are thin `header.includes:` lists over reusable fragments
  (`kas/yocto/<release>.yml`, `kas/ros2/<distro>.yml`, `kas/machine/<machine>.yml`,
  `kas/common.yml`, `kas/layer/<optional-layer>.yml`), using kas's `defaults:` for shared repo
  branch settings. No refactor is warranted. Full detail recorded in audit report §5.6 (updated in
  place rather than left as the original "unverifiable from this checkout" finding).
- **Minor unrelated defect noticed:** `kas/oeros-scarthgap-lyrical-raspberrypi4-64..yml` on the
  `build` branch has a double-dot typo in its filename. Not fixed here — out of scope for a
  `master`-branch remediation pass — but worth a one-line fix next time someone is on `build`.

---

## Milestone 3 — Deferred: requires a full Yocto build environment

**Environment:** requires a working poky/OE-core checkout capable of actually running bitbake
against meta-ros layers (fetching sources, resolving `world`, etc.). **Do not start these until
Milestones 0-2 are complete and that environment has been set up** — they were deliberately
separated out so the repo-clone-only work isn't blocked waiting on it.

### Task M3-1: Run `yocto-check-layer` and record results
- **Audit ref:** §4
- **Problem:** `yocto-check-layer` isn't available in a bare checkout of this repo — it requires a
  full poky/OE-core build environment. The audit could not verify parse-error, signature/
  reproducibility, or README-format compliance directly.
- **Do:**
  1. Check out `poky` (or standalone `bitbake` + `openembedded-core` + `meta-openembedded`)
     matching the `LAYERSERIES_COMPAT` of the branch being tested (e.g. use a `scarthgap`-series
     poky checkout to test the `scarthgap` meta-ros branch).
  2. Add all relevant meta-ros sub-layers for that branch to `bblayers.conf`.
  3. Run `yocto-check-layer` (and `--with-software-layer-check` if applicable) against each
     sub-layer.
  4. Record the output — pass/fail per layer, and the specific messages for any failures.
- **Acceptance criteria:** A results record (e.g. `docs/yocto-check-layer-results-<date>.md`) exists
  showing which layers pass and which don't, with concrete failure messages for the latter. This
  task's job is to produce that record, not necessarily to fix every failure it surfaces — file
  follow-up tasks for anything found.

### Task M3-2: Wire `generate-skip-groups.py` into CI
- **Audit ref:** §1.4
- **Problem:** Skip-group lists (875 entries in noetic, 180-196 per ROS2 distro) are regenerated by
  hand (build `world`, capture cooker log, run `scripts/generate-skip-groups.py`, paste output into
  `packagegroup-ros-world-<distro>.bb`) with no periodic re-check for packages that have since
  become buildable. Actually producing the cooker log this task depends on requires a real bitbake
  `world` build, which is why this is in the deferred milestone rather than Milestone 1/2.
- **Do:**
  1. Design a workflow (new GitHub Actions job, or an extension of `generate_recipes.yml`) that
     builds `packagegroup-ros-world-<distro>` per distro, captures the cooker log, runs
     `scripts/generate-skip-groups.py` against it, and diffs the result against the currently
     committed skip block.
  2. On diff, open a PR (same pattern as `generate_recipes.yml`) rather than auto-committing,
     so a human reviews newly-resolvable (or newly-broken) packages before they're added/removed.
  3. Fix the minor bug noted in the audit: `generate-skip-groups.py`'s `usage()` call site doesn't
     `sys.exit()`/`return` after printing usage on a bad arg count — it falls through and crashes
     instead of exiting cleanly. (This specific sub-fix is trivial and repo-only — it can be done
     early/opportunistically even before the rest of this task, if convenient.)
- **Acceptance criteria:** A scheduled or on-demand job exists that regenerates and diffs the skip
  block per distro and surfaces changes as a reviewable PR; `generate-skip-groups.py` exits cleanly
  on incorrect invocation.

---

## Milestone 4 — Backlog (no fixed timeline)

**Environment:** repo clone only, except where noted.

These are lower-urgency or require a maintainer decision before work starts. Don't schedule these
without explicit go-ahead.

### Task M4-1: Mirror the superflore/milestone process into the repo
- **Audit ref:** §2.7
- **Blocked on:** Confirming with a maintainer whether the milestone-batch process (last milestone:
  2022-06-05 per README) is formally superseded by the per-distro `generate_recipes.yml` workflow —
  the audit inferred this from workflow behavior but found no explicit statement confirming it.
- **Do (once confirmed):** Add an interim caveat note to README's "Tags" section marking milestones
  as legacy and linking `generate_recipes.yml` as the active mechanism; then write
  `docs/superflore-process.md` describing the current pipeline in full, explicitly separating
  "historical/wiki-only" (milestones) from "current/in-repo" (per-distro regeneration) content.

### Task M4-2: Add a `MAINTAINERS` file
- **Audit ref:** §4
- **Do:** Add a `MAINTAINERS` file at repo root listing current maintainers and contact method,
  matching whatever the YP-Compatible checklist expects structurally (name + contact, at minimum).
  Requires maintainer input — don't guess names/contacts.

### Task M4-3: Backfill missing `SRCREV` pin comments
- **Audit ref:** §1.2
- **Do:** Across the ~74 `.bbappend` files that pin a `SRCREV` (vendor-package fetch workaround
  pattern), add a one-line comment above each pin stating what release/tag it corresponds to
  (following the good existing example in
  `meta-ros2-kilted/.../rosbag2-storage-mcap/mcap-vendor_0.32.0-2.bbappend`, which documents
  `# releases/cpp/v1.4.0`). Where the original rationale can't be determined from the upstream repo
  history, note that explicitly rather than fabricating a reason.

### Task M4-4: Re-evaluate `OE_FRAGMENTS` / `bitbake-setup`
- **Audit ref:** §5.5
- **Do:** Not actionable now — `bitbake-setup` is too immature and doesn't address meta-ros's actual
  duplication problem (per-distro recipe trees, not `local.conf` toggles). Revisit in 12-18 months
  or if kas maintenance shows signs of stalling. No action until then.

---

## Task index

| ID | Title | Milestone | Environment | Effort | Status |
|---|---|---|---|---|---|
| M0-1 | Retire or replace dead CI (Travis/test-all.sh) | 0 | Repo clone | Small | Done |
| M0-2 | Fix `LAYERRECOMMENDS` omissions | 0 | Repo clone | Small | Done |
| M1-1 | Document `dynamic-layers` mechanism | 1 | Repo clone | Small | Done |
| M1-2 | Document recipe-override (bbappend) workflow | 1 | Repo clone | Medium | Done |
| M1-3 | Land root `AGENTS.md` | 1 | Repo clone | Small | Done |
| M1-4 | Tag-driven scheduled trigger for `generate_recipes.yml` | 1 | Repo clone + GH API | Medium | Done |
| M2-1 | Write per-sub-layer READMEs | 2 | Repo clone | Medium | Done |
| M2-2 | Audit `build` branch kas files | 2 | Repo clone | Medium | Done — no refactor needed |
| M3-1 | Run `yocto-check-layer`, record results | 3 (deferred) | Full Yocto build env | Medium | Not started |
| M3-2 | Wire `generate-skip-groups.py` into CI | 3 (deferred) | Full Yocto build env | Medium | Not started |
| M4-1 | Mirror superflore/milestone process in-repo | 4 | Repo clone (blocked) | Medium | Not started |
| M4-2 | Add `MAINTAINERS` file | 4 | Repo clone (blocked) | Small | Not started |
| M4-3 | Backfill `SRCREV` pin comments | 4 | Repo clone | Small | Not started |
| M4-4 | Re-evaluate `OE_FRAGMENTS`/`bitbake-setup` | 4 | N/A — deferred | N/A | Not started |

All of Milestones 0-2 (repo-clone-only work) are complete as of this update. Milestone 3 remains
deferred pending a full Yocto build environment; Milestone 4 is backlog, several items blocked on
maintainer input.
