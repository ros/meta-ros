# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "C++ implementation of bond, a mechanism for checking when     another process has terminated."
AUTHOR = "Michael Carroll <michael@openrobotics.org>"
ROS_AUTHOR = "Stuart Glaser"
HOMEPAGE = "http://www.ros.org/wiki/bondcpp"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "bond_core"
ROS_BPN = "bondcpp"

ROS_BUILD_DEPENDS = " \
    bond \
    pkgconfig \
    rclcpp \
    rclcpp-lifecycle \
    smclib \
    util-linux \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    bond \
    rclcpp \
    rclcpp-lifecycle \
    smclib \
    util-linux \
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

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/bond_core-release/archive/release/foxy/bondcpp/2.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/bondcpp"
SRC_URI = "git://github.com/ros2-gbp/bond_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "a5272a8783c064354067b79cdc7e378806a9afe3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
