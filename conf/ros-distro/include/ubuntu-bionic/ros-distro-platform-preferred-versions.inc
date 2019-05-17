# ubuntu-bionic/ros-distro-platform-preferred-versions.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# Set PREFERRED_VERSION_<PN> here for platform packages for which the layers provide multiple versions.

# Ubuntu bionic has v4.15, but meta-raspberrypi thud only provides v4.9 and v4.14 => select the latter as the former is more
# likely to be missing something that other components expect to be present.
PREFERRED_VERSION_linux-raspberrypi ?= "4.14%"
# Ubuntu bionic has v4.15, but OpenEmbedded thud only provides v4.14 and v4.18 => select the former to match linux-raspberrypi.
PREFERRED_VERSION_linux-yocto ?= "4.14%"
