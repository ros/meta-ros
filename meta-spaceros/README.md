# meta-spaceros

Shared configuration and a small number of SpaceROS-wide recipes (kernel,
support, and devtools) that don't belong to one specific ROS 2 distro. Concrete
Space ROS distro layers (currently `meta-spaceros-jazzy`) depend on this layer,
the same way `meta-ros2-<distro>` layers depend on `meta-ros2`.

See the [top-level README](../README.md) for how this fits into the overall
layer stack, and [`docs/recipe-overrides.md`](../docs/recipe-overrides.md) for
how to fix a generated recipe.

## Dependencies

- `core` (openembedded-core)
- `meta-python` (meta-openembedded)
- `openembedded-layer` (meta-openembedded)
- `ros-common-layer` (`meta-ros-common`)
- `ros2-layer` (`meta-ros2`)

## Compatibility

`LAYERSERIES_COMPAT_spaceros-layer` is scoped per branch — this branch
declares `wrynose`. Each Yocto-release branch of this repo (`master`,
`wrynose`, `scarthgap`, ...) sets this to its own release only; see
[`AGENTS.md` § Branch model](../AGENTS.md#branch-model).

## Maintainers

See the [top-level README](../README.md#join-the-meta-ros-community) for how
to reach the maintainers and community.
