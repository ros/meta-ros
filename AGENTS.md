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
  matching `recipes-bbappends*` directory of the same sub-layer. See
  [`docs/recipe-overrides.md`](docs/recipe-overrides.md) for the full
  naming convention and worked example. Prefer the `_%.bbappend` wildcard
  form over an exact-version filename where the fix isn't version-specific
  — exact-version bbappends silently stop applying (no error) once
  superflore bumps the recipe's `PV`. `scripts/rename-bbappend.sh`
  mechanically renames pinned bbappends when recipes are regenerated, but
  verify the underlying fix still makes sense against the new version
  before trusting the rename.
- Patch files carried in a bbappend must include an `Upstream-Status:`
  line and must actually be referenced by a recipe
  (`scripts/check-patch-files.sh` checks both; run it locally before
  submitting a patch-adding PR — it is not currently wired into CI).
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
  wired up via `BBFILES_DYNAMIC` in `conf/layer.conf` — see
  [README.md § Optional / Dynamic Layers](README.md#optional--dynamic-layers)
  for the full table. If you add a new recipe that should only build when
  some other optional layer is present, put it under
  `dynamic-layers/<that-layer>/...` and add a matching `BBFILES_DYNAMIC`
  line — don't add a hard `LAYERDEPENDS` for something most users won't
  have.
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
  don't rebase/rewrite it. **Each branch's `conf/layer.conf` sets
  `LAYERSERIES_COMPAT` to that branch's own release only** (e.g. the
  `scarthgap` branch is `"scarthgap"`, `master`/`wrynose` are
  `"wrynose"`) — this is deliberate per-branch scoping, not something to
  "fix" by unioning values across branches.
- `<branch>-next` branches stage commits pending merge into the
  corresponding unsuffixed branch; history there *may* be rewritten, so
  treat it as unstable.
- `build` (a separate branch) carries the `mcf`/`kas`-based
  getting-started tooling, including the `kas/layer/*.yml` definitions
  for the optional layers referenced above.
- Recipe-regeneration PRs land on branches named
  `superflore/<yocto-release>/<ros_distro>/<date>`, opened by
  `.github/workflows/generate_recipes.yml`.
- **A change to a repo-wide file (README, this file, a script) usually
  needs to be ported to every active branch**, not just the one you're
  on — check `scripts/ros-cherrypick.sh` before doing this by hand.

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
   `meta-ros-common`, see above). Full walkthrough:
   [`docs/recipe-overrides.md`](docs/recipe-overrides.md).
2. Does the fix belong in one distro's layer, or is it common to all ROS
   distros? Common fixes belong in `meta-ros-common`; distro-specific
   ones in that distro's sub-layer.
3. If adding a dependency on a layer that isn't `core`/`meta-python`/
   `openembedded-layer`/`ros-common-layer` (the current hard
   `LAYERDEPENDS` set), it should almost certainly be a `dynamic-layers`
   optional dependency instead of a hard one — check first.

## Further reading

- [`docs/meta-ros-layer-audit-2026-08.md`](docs/meta-ros-layer-audit-2026-08.md) —
  the audit this file and the linked docs were drafted from.
- [`docs/meta-ros-audit-remediation-spec.md`](docs/meta-ros-audit-remediation-spec.md) —
  the milestone-by-milestone remediation plan.
