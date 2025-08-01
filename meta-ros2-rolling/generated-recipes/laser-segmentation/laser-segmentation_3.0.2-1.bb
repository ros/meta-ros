# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Implementation of algorithms for segmentation of laserscans."
AUTHOR = "Alberto Tudela <ajtudela@gmail.com>"
ROS_AUTHOR = "Alberto Tudela <ajtudela@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "laser_segmentation"
ROS_BPN = "laser_segmentation"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    sensor-msgs \
    slg-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    sensor-msgs \
    slg-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    sensor-msgs \
    slg-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/laser_segmentation-release/archive/release/rolling/laser_segmentation/3.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/laser_segmentation"
SRC_URI = "git://github.com/ros2-gbp/laser_segmentation-release;${ROS_BRANCH};protocol=https"
SRCREV = "18117b81054865877d943544c6036d4e1f91deb2"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
