# meta-ros2

Shared configuration and recipes common to all ROS 2 distributions (analogous
to `meta-ros1` for ROS 1, but with more of its own recipe content:
`recipes-benchmark`, `recipes-core`, `recipes-devtools`, `recipes-graphics`,
`recipes-imported-cloud-services`, `recipes-kernel`, `recipes-support`). Every
`meta-ros2-<distro>` layer (`humble`, `jazzy`, `kilted`, `lyrical`, `rolling`)
and both Space ROS layers depend on this layer.

This is also where the optional-dependency mechanism for ROS 2 lives:

## Optional / Dynamic Layers

`meta-ros2` uses bitbake's `dynamic-layers` mechanism for three optional
upstream layers — content under `dynamic-layers/meta-qt5`,
`dynamic-layers/meta-qt6`, and `dynamic-layers/meta-zenoh` only activates if
the corresponding layer (and its `BBFILE_COLLECTIONS` name — `qt5-layer`,
`qt6-layer`, `zenoh-layer`) is also present in your build. See
[README.md § Optional / Dynamic Layers](../README.md#optional--dynamic-layers)
for the full table of what each unlocks and where to get it. If you're adding
a new recipe that should only build when some other optional layer is
present, this is the pattern to follow — see
[`AGENTS.md`](../AGENTS.md#layer-layout).

See the [top-level README](../README.md) for how this fits into the overall
layer stack, and [`docs/recipe-overrides.md`](../docs/recipe-overrides.md) for
how to fix a generated recipe.

## Dependencies

- `core` (openembedded-core)
- `meta-python` (meta-openembedded)
- `openembedded-layer` (meta-openembedded)
- `ros-common-layer` (`meta-ros-common`)

## Compatibility

`LAYERSERIES_COMPAT_ros2-layer` is scoped per branch — this branch declares
`wrynose`. Each Yocto-release branch of this repo (`master`, `wrynose`,
`scarthgap`, ...) sets this to its own release only; see
[`AGENTS.md` § Branch model](../AGENTS.md#branch-model).

## Maintainers

See the [top-level README](../README.md#join-the-meta-ros-community) for how
to reach the maintainers and community.
