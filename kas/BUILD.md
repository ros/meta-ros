# Building meta-ros with kas

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Create build storage](#create-build-storage)
- [Create workspace](#create-workspace)
- [Install kas](#install-kas)
- [Clone the meta-ros build configs](#clone-the-meta-ros-build-configs)
- [Configure kas workspace](#configure-kas-workspace)
- [Verify environment](#verify-environment)
- [Build image](#build-image)
- [Verify output](#verify-output)
- [Writing SD Card](#writing-sd-card)
- [Verify ROS installation](#verify-ros-installation)
- [Clean-up](#clean-up)

## Introduction

This is the getting started guide for building Robot Operating System (ROS) distros for Yocto Project releases.

Every build is driven by [kas](https://kas.readthedocs.io/), which clones the layers, writes the configuration files, and runs bitbake.

This guide builds the ros-image-core-lyrical image for Raspberry Pi 5 using the Yocto Project Wrynose release and ROS 2 Lyrical. The result is a bootable SD-card image for the Raspberry Pi 5.

## Prerequisites

A [supported Linux distribution](https://docs.yoctoproject.org/wrynose/ref-manual/system-requirements.html#supported-linux-distributions) for Wrynose, with
the Yocto [build host packages](https://docs.yoctoproject.org/wrynose/ref-manual/system-requirements.html#required-packages-for-the-build-host)
installed.

If your Linux distro is not supported by that Yocto release, use the container method instead. These instructions have been tested on Ubuntu 24.04 (LTS).

The initial build may download tens of gigabytes of source code and build thousands of packages. On a modern workstation the first build may take many hours. Subsequent builds are typically much faster because downloads and shared-state artifacts are reused. Plan for at least 100 GB of free disk space and 16 GB RAM as a minimum.  

Required tools:
* git
* python3
* python3-venv
* Docker or Podman (required for kas-container)


NOTE: You may build without containers by substituting the `kas`
command with `kas-container`. However, this requires installation of a container runtime.
Before building with kas-container, ensure your container runtime (Docker or
Podman) is installed and running.


Full details on system requirements can be found in the [Yocto Project manual](https://docs.yoctoproject.org/wrynose/ref-manual/system-requirements.html).

## Create build storage

Yocto downloads and builds a large number of source packages. To avoid downloading and rebuilding everything each time, create shared storage directories for:

* downloads (source archives)
* sstate-cache (reusable build outputs)
* hash database (build metadata)

```bash
export DL_DIR="$HOME/yocto/downloads"
export SSTATE_DIR="$HOME/yocto/sstate-cache"
export BB_HASHSERVE_DB_DIR="$HOME/yocto/shared-hashserve-db"

mkdir -p "$DL_DIR" "$SSTATE_DIR" "$BB_HASHSERVE_DB_DIR"
```

These directories are intended to be shared across multiple Yocto Project workspaces. Keeping them outside the project directory allows downloads and build artifacts to be reused across different builds.

## Create workspace

Create a project directory:

```bash
mkdir -p "$HOME/yocto/project"
cd "$HOME/yocto/project"
```

## Install kas

Create a Python virtual environment to install kas:
```bash
python3 -m venv venv
source venv/bin/activate
pip install --upgrade pip
pip install kas
```

If you wish to use kas-container, install the option `containers` module:
```
pip install kas[containers]
```

NOTE: if you open a new terminal later, reactivate the virtual environment and export the environment variables (see above).
```bash
cd "$HOME/yocto/project"
source venv/bin/activate
```

## Clone the meta-ros build configs

The build branch contains kas configuration files used to compose Yocto and ROS
release combinations. Clone it locally:
```bash
git clone -b build https://github.com/ros/meta-ros
```

The repository will be cloned into a local meta-ros directory.

## Configure kas workspace

The KAS_WORK_DIR controls where kas creates the build environment and stores
build output.
```bash
export KAS_WORK_DIR="$PWD/build"
mkdir -p "$KAS_WORK_DIR"
```

## Verify environment

Check that the environment variables are set.
```bash
for VAR in DL_DIR SSTATE_DIR BB_HASHSERVE_DB_DIR KAS_WORK_DIR; do echo "$VAR : ${!VAR} : $(test -d ${!VAR} && echo "FOUND" || echo "MISSING")"; done
```

## Build image

Run the following command to build with kas.

```bash
kas build meta-ros/kas/oeros-master-lyrical-raspberrypi5.yml
```

NOTE: To build in a container replace `kas` with `kas-contaienr`. The first invocation of kas-container may also download a container image before the build begins.


This configuration selects:
* Yocto Project Wrynose release
* ROS 2 Lyrical
* Raspberry Pi 5

The kas tool will automatically fetch all required Yocto Project layers and source repositories referenced by the configuration.

To see the available build configurations:
```bash
ls meta-ros/kas/*.yml
```

The initial build may take several hours depending on your system and network connection.
It is normal for some recipes to take a long time to compile.

Subsequent builds are significantly faster because downloads and shared state artifacts are
reused.

If the build is interrupted, simply rerun the same command. BitBake will reuse completed work and continue building.

NOTE: Additional documentation for kas commands can be found at https://kas.readthedocs.io/en/latest/

## Verify output

After the build completes successfully, it should produce an image that can be written to the
SD card. For the Raspberry Pi 5 this is located in build/tmp-glibc/deploy/images/raspberrypi5/:

```bash
ls build/tmp-glibc/deploy/images/raspberrypi5/
...
ros-image-core-lyrical-raspberrypi5.rootfs.wic.bz2
```

## Writing SD Card

You may then write it to an SD card using one of the following tools:
* [Raspberry Pi Imager](#raspberry-pi-imager)
* [Balena Etcher](#balena-etcher)
* [bmaptool](#bmaptool)
* [dd](#dd)

### Raspberry Pi Imager

[Raspberry Pi Imager](https://github.com/raspberrypi/rpi-imager), can write
the .wic image directly.  Decompress it first with bunzip2.

If it has the bz2 extension, you may decompress it with the bunzip2 command:
```bash
bunzip2 "$KAS_WORK_DIR/tmp-glibc/deploy/images/raspberrypi5/ros-image-core-lyrical-raspberrypi5.rootfs.wic.bz2"
```

### Balena Etcher

If using [Balena Etcher](https://etcher.balena.io/), you may provide it with
the wic.bz2 file directly.

### bmaptool

The bmaptool tool is a command-line tool that is endorsed by the Yocto Project.
It can copy large files like raw system image files much faster than traditional
tools.

If using bmaptool, additional instructions may be found in the Yocto manual
here: https://docs.yoctoproject.org/dev/dev-manual/bmaptool.html

Find the block device for the SD card using the lsblk command:
```bash
NAME        MAJ:MIN RM   SIZE RO TYPE MOUNTPOINTS
sda           8:0    1  59.5G  0 disk 
└─sda1        8:1    1  59.5G  0 part /media/user/DATACARD
nvme0n1     259:0    0 476.9G  0 disk 
├─nvme0n1p1 259:1    0   512M  0 part /boot/efi
└─nvme0n1p2 259:2    0 476.4G  0 part /
```

In the example above, the SD card is plugged into the machine via an SD card reader and accessible
via /dev/sda. Replace the last argument below (/dev/sdX) with the path to the block device for the SD card (/dev/sda).

You may choose to install and use the bmap-tools package for your Linux distro.  
```bash
sudo apt install bmap-tools
bmaptool copy  --removable-device "$KAS_WORK_DIR/tmp-glibc/deploy/images/raspberrypi5/ros-image-core-lyrical-raspberrypi5.rootfs.wic.bz2" /dev/sdX
```

This launches a Yocto development shell. From inside that shell, run:
```bash
kas shell meta-ros/kas/oeros-master-lyrical-raspberrypi5.yml
```

Inside the development shell, you may then execute the bmaptool with oe-run-native:
```bash
oe-run-native bmaptool-native bmaptool copy --removable-device "$KAS_WORK_DIR/tmp-glibc/deploy/images/raspberrypi5/ros-image-core-lyrical-raspberrypi5.rootfs.wic.bz2" /dev/sdX
```

### dd

This low-level tool does not have the built-in safety mechanisms found in
the other tools.

If using dd, you must first decompress the bzip2 file. If it has the bz2
extension, you may decompress it with the bunzip2 command:
```bash
bunzip2 "$KAS_WORK_DIR/tmp-glibc/deploy/images/raspberrypi5/ros-image-core-lyrical-raspberrypi5.rootfs.wic.bz2"
```

Then write it to the SD card device with:
```bash
dd if="$KAS_WORK_DIR/tmp-glibc/deploy/images/raspberrypi5/ros-image-core-lyrical-raspberrypi5.rootfs.wic" of=/dev/sdX bs=1M status=progress conv=fsync
```

WARNING: Verify the SD card device path before running dd.  Specifying the wrong
device can overwrite data on your system.

## Verify ROS installation

After the system boots:

```bash
source /opt/ros/lyrical/setup.bash
ros2 --help
```

A successful result confirms that ROS 2 Lyrical was installed correctly.

You may also run the diagnostic tool:
```bash
ros2 doctor
```

This command checks the ROS 2 installation and running system for configuration issues, warnings, and errors.

## Clean-up

To reclaim hard disk space, first copy any build artifacts you need out of the deploy directory.

To remove temporary build output while preserving downloads and shared state, delete the build/ directory:

```bash
rm -rf build
```

Subsequent builds will continue to reuse `DL_DIR` and `SSTATE_DIR` to build new filesystem images.

For advanced usage of `kas` including ways to customize the configuration files, check out the [advanced usage guide](ADVANCED.md).