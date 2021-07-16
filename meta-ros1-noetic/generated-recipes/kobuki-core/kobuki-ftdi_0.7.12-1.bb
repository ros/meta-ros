# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Utilities for flashing and enabling Kobuki's USB connection. 	    This package contains tools for flashing the Kobuki's FTDI chip (usually done at the factory). 	    The special firmware for the FTDI chip (USB to serial converter) enables it to appear as 	    /dev/kobuki on the user's PC."
AUTHOR = "Younghun Ju <yhju@yujinrobot.com>"
ROS_AUTHOR = "Younghun Ju <yhju@yujinrobot.com>"
HOMEPAGE = "http://ros.org/wiki/kobuki_ftdi"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kobuki_core"
ROS_BPN = "kobuki_ftdi"

ROS_BUILD_DEPENDS = " \
    ecl-command-line \
    libftdi \
    libusb1 \
    pkgconfig \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ecl-command-line \
    libftdi \
    libusb1 \
"

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

# matches with: https://github.com/yujinrobot-release/kobuki_core-release/archive/release/noetic/kobuki_ftdi/0.7.12-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/kobuki_ftdi"
SRC_URI = "git://github.com/yujinrobot-release/kobuki_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "4adb81bf541a74361a01da1185ecb61f48c7d6f5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
