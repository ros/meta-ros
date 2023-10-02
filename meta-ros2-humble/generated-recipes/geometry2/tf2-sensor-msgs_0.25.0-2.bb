# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Small lib to transform sensor_msgs with tf. Most notably, PointCloud2"
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Vincent Rabaud"
HOMEPAGE = "http://www.ros.org/wiki/tf2_ros"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry2"
ROS_BPN = "tf2_sensor_msgs"

ROS_BUILD_DEPENDS = " \
    libeigen \
    sensor-msgs \
    tf2 \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    eigen3-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
    sensor-msgs \
    tf2 \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    eigen3-cmake-module-native \
"

ROS_EXEC_DEPENDS = " \
    sensor-msgs \
    tf2 \
    tf2-ros \
    tf2-ros-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    rclcpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/geometry2-release/archive/release/humble/tf2_sensor_msgs/0.25.0-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/tf2_sensor_msgs"
SRC_URI = "git://github.com/ros2-gbp/geometry2-release;${ROS_BRANCH};protocol=https"
SRCREV = "7bd604bc6beed95fcddb9bef3ef617ec68ebed5f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
