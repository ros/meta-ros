# meta-ros: `build` branch

This branch holds the [kas](https://kas.readthedocs.io/) configuration used to
build [meta-ros](https://github.com/ros/meta-ros), the OpenEmbedded layers that
add the Robot Operating System (ROS) to Yocto Project based Linux images. It
contains no recipes. The layers themselves live on the release branches
(`scarthgap`, `wrynose`, `blacksail`, `master`, and so on), and kas fetches the
matching one for you.

Builds use kas rather than `bitbake-setup` or hand-written `bblayers.conf` files.
Each config pins a Yocto release, a ROS distro, and a machine.

## Where to start

| If you want to... | Read |
| --- | --- |
| Build your first image | [Getting started guide](kas/BUILD.md) |
| Understand the config files | [kas configuration files](kas/README.md) |
| Customize builds, use forks or CI | [Advanced usage](kas/ADVANCED.md) |

## Quick start

If you already have [kas installed](kas/BUILD.md#set-up) and a Yocto build host
(or Docker/Podman with `kas-container`), this builds a ROS 2 Lyrical image for
QEMU on Yocto Wrynose (both are LTS releases):

```sh
git clone -b build https://github.com/ros/meta-ros
kas build meta-ros/kas/oeros-wrynose-lyrical-qemux86-64.yml
```

New to Yocto? Follow the [getting started guide](kas/BUILD.md) instead.

## What can be built

Ready-to-build configs are named `kas/oeros-<yocto>-<ros>-<machine>.yml`.
Run `ls meta-ros/kas/oeros-*.yml` for the exact list; not every machine exists
for every Yocto release and ROS distro pair.

| Yocto release      | ROS distros with configs                         | Machines (varies by distro) |
| ---                | ---                                              | ---      |
| Scarthgap (LTS)    | Humble, Jazzy, Kilted, Lyrical, Rolling          | qemux86-64, raspberrypi0-2w-64, raspberrypi4-64, raspberrypi5 |
| Wrynose (LTS)      | Humble, Jazzy, Kilted, Lyrical, Rolling, Noetic¹ | qemux86-64, raspberrypi4-64, raspberrypi5 |
| Blacksail          | Humble, Jazzy, Kilted, Lyrical, Rolling          | qemux86-64, raspberrypi4-64, raspberrypi5 |
| master (in development) | Humble, Jazzy, Kilted, Lyrical, Rolling, Space ROS Jazzy² | qemux86-64, raspberrypi4-64, raspberrypi5 |

¹ ROS 1 Noetic: Raspberry Pi 5 only (`oeros-wrynose-noetic-raspberrypi5.yml`).

² Space ROS: Raspberry Pi 5 only (`oeros-master-spaceros-jazzy-raspberrypi5.yml`).

Support dates for each pair are in the
[Supported Combinations](https://github.com/ros/meta-ros#supported-combinations)
table on the default branch.