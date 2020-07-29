# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Wrapper around console_bridge, providing nothing but a dependency on console_bridge, on some systems.     On others, it provides an ExternalProject build of console_bridge."
AUTHOR = "Steven! Ragnarök <steven@osrfoundation.org>"
HOMEPAGE = "https://github.com/ros/console_bridge"
SECTION = "devel"
LICENSE = "Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=f12ef8c0445c08084ae92cf2dcb7ee92"

ROS_CN = "console_bridge_vendor"
ROS_BPN = "console_bridge_vendor"

ROS_BUILD_DEPENDS = " \
    console-bridge \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    console-bridge \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    console-bridge \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/console_bridge_vendor-release/archive/release/rolling/console_bridge_vendor/1.2.1-2.tar.gz
ROS_BRANCH ?= "branch=release/rolling/console_bridge_vendor"
SRC_URI = "git://github.com/ros2-gbp/console_bridge_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "ec9a52f75146200f5e3f62718b22f44072e7a4cf"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
