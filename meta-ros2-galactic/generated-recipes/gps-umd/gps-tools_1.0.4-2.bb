# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "GPS routines for use in GPS drivers"
AUTHOR = "P. J. Reed <preed@swri.org>"
HOMEPAGE = "http://ros.org/wiki/gps_common"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "gps_umd"
ROS_BPN = "gps_tools"

ROS_BUILD_DEPENDS = " \
    gps-msgs \
    nav-msgs \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
"

ROS_EXPORT_DEPENDS = " \
    gps-msgs \
    nav-msgs \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gps-msgs \
    nav-msgs \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/gps_umd-release/archive/release/galactic/gps_tools/1.0.4-2.tar.gz
ROS_BRANCH ?= "branch=release/galactic/gps_tools"
SRC_URI = "git://github.com/ros2-gbp/gps_umd-release;${ROS_BRANCH};protocol=https"
SRCREV = "2cd2f7f66dc05f95c7df150ea158ff4fc8e452b2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
