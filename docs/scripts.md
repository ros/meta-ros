# The scripts in `scripts/`

Most of these scripts belong to one of three jobs: regenerating recipes from `ros/rosdistro`,
deciding which recipes to skip, and checking the repository. Run them from the top of the
meta-ros checkout (`cd meta-ros`). Each script's header comment has its exact usage.

## Regenerating recipes (superflore)

These scripts back `.github/workflows/generate_recipes.yml`.

| Script | Purpose |
|---|---|
| `ros-generate-cache.sh` | Generates and commits `cache.yaml` (plus the rosdep files) for one release of a ROS distro, from a commit of a local `ros/rosdistro` checkout. |
| `ros-generate-recipes.sh` | Regenerates the recipes for a ROS distro from its `cache.yaml` with superflore. It aborts if the work tree has uncommitted changes. |
| `rename-bbappend.sh` | After regeneration, renames the `.bbappend` files in the distro layers to match the new recipe versions. It uses the sync commit to find the renames. |
| `rename-spaceros-bbappend.sh` | The same, for the Space ROS layer. It matches the versions of the BitBake recipes. |
| `check-rosdistro-tags.sh` | Reports which distros have a newer `rosdistro` release tag than the one recorded in their `cache.yaml`. It only reports; it does not start the workflow. |

## Skipping recipes that cannot be built

meta-ros has two scripts for this. They solve different problems and use different inputs.

### `generate-skip-groups.py` (with `update-skip-groups.py`)

- **Input:** a bitbake log from a failed `bitbake world` parse (the "Missing or unbuildable
  dependency chain was:" lines).
- **Output:** for each missing recipe, a `ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_<NAME>`
  list and an `RDEPENDS:${PN}:remove` line. These go in `packagegroup-ros-world-<distro>.bb`, and
  the line only applies when the skip group is in `ROS_WORLD_SKIP_GROUPS`.
- **Scope:** the world packagegroup only. Each missing recipe gets one skip group. Other recipes
  that depend on the missing one are not skipped.
- **Maintenance:** `update-skip-groups.py` merges new output into the packagegroup and keeps the
  hand-written comments. A person has to run both and review the result.

### `generate-world-skips.py`

- **Input:** two in-process bitbake (tinfoil) dumps. The first uses the layers that are always
  present. The second adds every optional layer (meta-qt5, meta-qt6, meta-python-ai, ...).
- **Output:** one `SKIP_RECIPE[<pn>]` entry per ROS recipe that cannot be built, in
  `conf/ros-distro/include/<distro>/generated/ros-distro-recipe-unavailable.inc`. It is a
  generated file, so it lives in the `generated/` directory. The distro's `ros-distro.inc`
  requires it.
- **Scope:** every ROS-layer recipe. The script follows build and runtime dependencies through
  the whole tree, so one missing dependency skips everything that depends on it. A recipe that
  cannot be built even with all optional layers is skipped when the `unavailable` skip group
  is in `ROS_WORLD_SKIP_GROUPS`. One that only needs an optional layer is skipped when that
  layer is absent. The `ros_world_skip` class (inherited by the packagegroups) then drops
  skipped recipes from their `RDEPENDS`, so the groups need no hand-written removal lists.
- **Why it exists:** `yocto-check-layer`'s `test_world` must succeed with only the
  mandatory layers, and no log of a failed world build can say what a different layer set
  would give.
- **Maintenance:** empty the `.inc` before dumping, then regenerate it after every recipe
  regeneration. The procedure is in the script's header. It is not part of
  `generate_recipes.yml`: it needs a bitbake environment (oe-core, bitbake, meta-openembedded
  and the optional layers), so it belongs with the CI build test. That test is run by hand for now
  and is to be automated later; the regeneration step goes in it.

| | `generate-skip-groups.py` | `generate-world-skips.py` |
|---|---|---|
| Reads | A bitbake log | Bitbake's recipe caches (needs a configured build environment) |
| Writes | Lists and `RDEPENDS:remove` lines for `packagegroup-ros-world-<distro>.bb` | `SKIP_RECIPE` entries in `generated/ros-distro-recipe-unavailable.inc` |
| Skips | World packages, grouped by the missing recipe | Every unbuildable ROS recipe and everything that depends on it |
| Optional layers | Not considered | Skips depend on which optional layers are present |
| Applied | Pasted or merged in by hand | Automatically, through `require` |

## Checking the repository

| Script | Purpose |
|---|---|
| `check-patch-files.sh <dir>` | Reports every `.patch` file under `<dir>` that has no `Upstream-Status:` line or that no recipe references. It is not run by CI. |
| `ros-cherrypick.sh` | Ports a range of commits between ROS distro layers on the same Yocto branch. It renames recipes to the new versions and drops files for packages that no longer exist. The result is a series of patch files for `git am`. |

See also `AGENTS.md` and `docs/recipe-overrides.md`.
