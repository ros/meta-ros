# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Package containing models of KUKA LBR iisy family"
AUTHOR = "Aron Svastits <svastits1@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "kuka_robot_descriptions"
ROS_BPN = "kuka_lbr_iisy_support"

ROS_BUILD_DEPENDS = " \
    urdf \
    xacro \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    urdf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher-gui \
    kuka-resources \
    launch-ros \
    robot-state-publisher \
    rviz2 \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    launch-testing-ament-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/kuka_robot_descriptions-release/archive/release/humble/kuka_lbr_iisy_support/0.9.0-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/kuka_lbr_iisy_support"
SRC_URI = "git://github.com/ros2-gbp/kuka_robot_descriptions-release;${ROS_BRANCH};protocol=https"
SRCREV = "bf7cbf841a949c2dcc065ce94dc7cfc4d445d790"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
