# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Examples for using KUKA external control SDK"
AUTHOR = "Gergely Kovacs <kovacsge.work@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "kuka_external_control_sdk"
ROS_BPN = "kuka_external_control_sdk_examples"

ROS_BUILD_DEPENDS = " \
    kuka-external-control-sdk \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    kuka-external-control-sdk \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake \
    kuka-external-control-sdk \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/kuka_external_control_sdk-release/archive/release/humble/kuka_external_control_sdk_examples/1.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/kuka_external_control_sdk_examples"
SRC_URI = "git://github.com/ros2-gbp/kuka_external_control_sdk-release;${ROS_BRANCH};protocol=https"
SRCREV = "c30baf86576f88717d806330bd664efb254eb7b9"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
