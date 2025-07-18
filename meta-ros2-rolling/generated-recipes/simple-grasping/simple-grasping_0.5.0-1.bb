# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Basic grasping applications and demos."
AUTHOR = "Michael Ferguson <mike@vanadiumlabs.com>"
ROS_AUTHOR = "Michael Ferguson"
HOMEPAGE = "http://ros.org/wiki/simple_grasping"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "simple_grasping"
ROS_BPN = "simple_grasping"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    grasping-msgs \
    libeigen \
    moveit-msgs \
    pcl \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    sensor-msgs \
    shape-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    grasping-msgs \
    moveit-msgs \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    sensor-msgs \
    shape-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    grasping-msgs \
    moveit-msgs \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    sensor-msgs \
    shape-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-cpplint \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/simple_grasping-release/archive/release/rolling/simple_grasping/0.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/simple_grasping"
SRC_URI = "git://github.com/ros2-gbp/simple_grasping-release;${ROS_BRANCH};protocol=https"
SRCREV = "188727f1f711a1349666ee9d394844789d2339c9"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
