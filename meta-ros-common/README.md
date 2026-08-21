# meta-ros-common

The foundation layer every ROS distro layer in this repo depends on
(`meta-ros1`, `meta-ros2`, and transitively every `meta-ros1-<distro>` /
`meta-ros2-<distro>` / `meta-spaceros*` layer). It holds recipes that are
common across ROS versions rather than tied to one distro release: third-party
libraries, ROS image/packagegroup recipes, and infrastructure that ROS 1 and
ROS 2 both need (`recipes-bsp`, `recipes-core`, `recipes-devtools`,
`recipes-graphics`, `recipes-multimedia`, `recipes-support`, and several
`recipes-imported-*` groupings — roughly 350 recipes/bbappends in total).

Unlike the distro layers, most of this content is **hand-maintained, not
superflore-generated** — there is no `recipes-bbappends` directory here, so
fixes are made directly to the recipe rather than via a bbappend. See
[`docs/recipe-overrides.md`](../docs/recipe-overrides.md) for the full
distinction.

This layer also supplies:
- `conf/ros-distro/ros-distro.conf` — configuration shared across all ROS
  distros, required by every distro layer's `conf/layer.conf`.
- `licenses/` (via `LICENSE_PATH`) — stock license texts for packages whose
  license isn't already known to OE-core/meta-openembedded.
- `dynamic-layers/meta-python-ai/` — recipe adjustments that only activate if
  the optional `meta-python-ai` layer is present; see
  [README.md § Optional / Dynamic Layers](../README.md#optional--dynamic-layers).

See the [top-level README](../README.md) for how this fits into the overall
layer stack.

## Dependencies

- `core` (openembedded-core)
- `meta-python` (meta-openembedded)
- `openembedded-layer` (meta-openembedded)

## Compatibility

`LAYERSERIES_COMPAT_ros-common-layer` is scoped per branch — this branch
declares `wrynose`. Each Yocto-release branch of this repo (`master`,
`wrynose`, `scarthgap`, ...) sets this to its own release only; see
[`AGENTS.md` § Branch model](../AGENTS.md#branch-model).

## Maintainers

See the [top-level README](../README.md#join-the-meta-ros-community) for how
to reach the maintainers and community.
