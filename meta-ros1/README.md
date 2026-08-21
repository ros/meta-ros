# meta-ros1

Shared configuration for ROS 1. This is the parent layer that a concrete ROS 1
distro layer (currently `meta-ros1-noetic`) depends on for ROS-1-wide
configuration; it does not itself target a specific ROS distro release.

See the [top-level README](../README.md) for how this fits into the overall
layer stack, and [`docs/recipe-overrides.md`](../docs/recipe-overrides.md) for
how to fix a generated recipe.

## Dependencies

- `core` (openembedded-core)
- `meta-python` (meta-openembedded)
- `openembedded-layer` (meta-openembedded)
- `ros-common-layer` (`meta-ros-common`)

## Compatibility

`LAYERSERIES_COMPAT_ros1-layer` is scoped per branch — this branch declares
`wrynose`. Each Yocto-release branch of this repo (`master`, `wrynose`,
`scarthgap`, ...) sets this to its own release only; see
[`AGENTS.md` § Branch model](../AGENTS.md#branch-model).

## Maintainers

See the [top-level README](../README.md#join-the-meta-ros-community) for how
to reach the maintainers and community.
