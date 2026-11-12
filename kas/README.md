# meta-ros kas configuration files

This directory contains the kas configuration files for building an embedded Linux
image with a Yocto Project release and a ROS 2 distro.

New to kas? Start with the [getting started guide](BUILD.md). To customize
builds, see the [advanced usage guide](ADVANCED.md).

## Reading a config name

`oeros-<yocto>-<ros>-<machine>.yml` picks three things:

- `<yocto>`: the Yocto release, such as `wrynose`
- `<ros>`: the ROS distro, such as `lyrical`
- `<machine>`: the board, such as `raspberrypi5`

For example, `oeros-wrynose-lyrical-raspberrypi5.yml` builds ROS 2 Lyrical on
Yocto Wrynose for a Raspberry Pi 5.

## Config files

Each ready-to-build config only includes smaller fragments, which you can mix
yourself (see [ADVANCED.md](ADVANCED.md)):

```yaml
# kas/oeros-wrynose-lyrical-raspberrypi5.yml
header:
  version: 14
  includes:
    - kas/yocto/wrynose.yml       # oe-core, bitbake, meta-yocto, meta-openembedded, pinned
    - kas/ros2/lyrical.yml        # meta-ros layers, DISTRO = ros2, target ros-image-core
    - kas/machine/raspberrypi5.yml  # MACHINE and meta-raspberrypi
    - kas/common.yml              # shared settings and layers
    - kas/layer/qt6.yml           # Qt 6 for this ROS distro
```

Include paths are relative to the root of the meta-ros `build` checkout.

| Directory or file | What it sets |
| --- | --- |
| `yocto/<release>.yml` | The default branch for every repo, plus oe-core, bitbake and meta-openembedded pinned to a Yocto point release. `master.yml` is not pinned. |
| `ros1/`, `ros2/`, `spaceros/` | Which meta-ros layers to enable, the `distro` (`ros1` or `ros2`) and the default target, `ros-image-core`. meta-ros itself follows the branch set by the Yocto file. |
| `machine/<machine>.yml` | `MACHINE` and its BSP layer: qemux86-64, qemuarm64, raspberrypi0-2w-64, raspberrypi4-64, raspberrypi5, jetson-agx-xavier-devkit, jetson-orin-nano-devkit, polarfire-soc-icicle-kit-es. |
| `layer/*.yml` | One optional third-party layer each: clang, clang-revival, lts-mixins, python-ai, qt5, qt6, realsense, tasklogger, virtualization, zenoh. |
| `common.yml` | Layers and `local.conf` settings used by every config: usrmerge, `rm_work`, `report-error`, debug-friendly image features. |
| `systemd.yml` | Switches init to systemd. |
| `visualization.yml` | Adds x11, opengl, vulkan and Tk for GUI tools such as RViz. |
| `world.yml` | Extra `DISTRO_FEATURES` needed to build `ros-image-world`. |
| `diskmon.yml` | Stops the build cleanly before a disk fills up. |
| `limit-pressure.yml` | Caps bitbake threads and uses pressure limits so a desktop stays usable. |
| `buildci.yml` | Turns on buildhistory and buildstats. |
| `awsci.yml` | The project's own S3 download and sstate mirrors. CI only; it needs credentials you will not have. |
| `oeros-devel.yml` | master + Rolling + qemux86-64, for working on the next release. |
