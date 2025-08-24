# Building meta-ros with kas

Here are simple instructions for getting started building the releases of Yocto
and ROS 2.
Documentation for kas can be found at https://kas.readthedocs.io/en/latest/

## Installing kas

To create a Python virtual environment to install kas run these commands:
```
python3 -m venv venv
source venv/bin/activate
pip3 install kas
```

## Clone the meta-ros build branch
After you have sourced the environment where kas is installed you may get the
kas configuration by cloning the build branch of meta-ros:
```
git clone -b build https://github.com/ros/meta-ros
```

## Running kas
Create a new project directory wherever you want and set the KAS_WORK_DIR 
environment variable to point to it.  Then run kas with the configuration file
for Yocto Kirkstone release and ROS 2 Humble distribution for the
Raspberry Pi 4.
```
mkdir $PROJECT_DIR
KAS_WORK_DIR=$PROJECT_DIR
kas build meta-ros/kas/oeros-kirkstone-humble-raspberrypi4-64.yml
```

This should complete successfully and produce an image you can write to the
sdcard.

```
build/tmp-glibc/deploy/images/raspberrypi4-64/ros-image-core-humble-raspberrypi4-64.rootfs.wic.bz2
```

## Using kas menu

To configure your build with the `kas` tool and `menuconfig`:

```bash
mkdir $PROJECT_DIR
KAS_WORK_DIR=$PROJECT_DIR
kas menu meta-ros/kas/Kconfig
```

Select:

  * Yocto release
  * Machine selection (qemu86-64, raspberrypi4-64, raspberrypi5)
  * ROS release
  * Image selection (core, desktop, desktopfull, world)

This generates a configuration file: `.config.yaml`.

This file can be used as:

```
kas build .config.yaml
```

More info: https://kas.readthedocs.io/en/latest/userguide/plugins.html#module-kas.plugins.menu

## Writing the image

If using [Balena Etcher](https://etcher.balena.io/), you may provide it with
this file directly.

If using dd, you must first decompress the bzip2 file.

If using bmaptool, you may follow the instructions here:
https://docs.yoctoproject.org/dev/dev-manual/bmaptool.html

Since we have already produced the wic file you may use the following example
with the last 2 arguments replaced with the path to the wic file and to the 
SD card you wish to write:
```
oe-run-native bmaptool-native bmaptool copy <build-directory/tmp/deploy/images/machine/image.wic> </dev/sdX>
```
