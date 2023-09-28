# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "Utilities for flashing and enabling Kobuki's USB connection. 	    This package contains tools for flashing the Kobuki's FTDI chip (usually done at the factory). 	    The special firmware for the FTDI chip (USB to serial converter) enables it to appear as 	    /dev/kobuki on the user's PC."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Younghun Ju"
HOMEPAGE = "http://ros.org/wiki/kobuki_ftdi"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kobuki_ftdi"
ROS_BPN = "kobuki_ftdi"

ROS_BUILD_DEPENDS = " \
    ecl-build \
    ecl-command-line \
    libftdi \
    libusb1 \
    pkgconfig \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecl-command-line \
    libftdi \
    libusb1 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/stonier/kobuki_ftdi-release/archive/release/eloquent/kobuki_ftdi/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/kobuki_ftdi"
SRC_URI = "git://github.com/stonier/kobuki_ftdi-release;${ROS_BRANCH};protocol=https"
SRCREV = "ad06741ec7e2bcfa1677f430bcec718f8d49cfae"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
