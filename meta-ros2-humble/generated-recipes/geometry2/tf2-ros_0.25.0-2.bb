# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "This package contains the C++ ROS bindings for the tf2 library"
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://www.ros.org/wiki/tf2_ros"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry2"
ROS_BPN = "tf2_ros"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    message-filters \
    rcl-interfaces \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    tf2 \
    tf2-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    message-filters \
    rcl-interfaces \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    tf2 \
    tf2-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    message-filters \
    rcl-interfaces \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    tf2 \
    tf2-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    rosgraph-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/geometry2-release/archive/release/humble/tf2_ros/0.25.0-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/tf2_ros"
SRC_URI = "git://github.com/ros2-gbp/geometry2-release;${ROS_BRANCH};protocol=https"
SRCREV = "6ba7b6d27b1f63b76e30e97a55191cdf69a3e33c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
