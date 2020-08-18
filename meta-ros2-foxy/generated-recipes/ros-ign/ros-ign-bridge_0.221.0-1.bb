# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Bridge communication between ROS and Ignition Transport"
AUTHOR = "Louise Poubel <louise@openrobotics.org>"
ROS_AUTHOR = "Shivesh Khaitan"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "ros_ign"
ROS_BPN = "ros_ign_bridge"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_ignition-msgs5} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_ignition-transport8} \
    geometry-msgs \
    nav-msgs \
    rclcpp \
    rosgraph-msgs \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_ignition-msgs5} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_ignition-transport8} \
    geometry-msgs \
    nav-msgs \
    rclcpp \
    rosgraph-msgs \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_ignition-msgs5} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_ignition-transport8} \
    geometry-msgs \
    nav-msgs \
    rclcpp \
    rosgraph-msgs \
    sensor-msgs \
    std-msgs \
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

# matches with: https://github.com/ros2-gbp/ros_ign-release/archive/release/foxy/ros_ign_bridge/0.221.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/ros_ign_bridge"
SRC_URI = "git://github.com/ros2-gbp/ros_ign-release;${ROS_BRANCH};protocol=https"
SRCREV = "a8ae31a1166df8b88311d9cbb2e1e8c929125de0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
