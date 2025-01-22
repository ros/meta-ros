# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "YASMIN (Yet Another State MachINe) for ROS 2"
AUTHOR = "Miguel Ángel González Santamarta <mgons@unileon.es>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f7455b89fc1cd18dbf3c0518d5d21928"

ROS_CN = "yasmin"
ROS_BPN = "yasmin_ros"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-action \
    rclpy \
    ros-environment \
    yasmin \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    rclcpp-action \
    rclpy \
    yasmin \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-action \
    rclpy \
    yasmin \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
    python3-pytest-cov \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/yasmin-release/archive/release/humble/yasmin_ros/3.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/yasmin_ros"
SRC_URI = "git://github.com/ros2-gbp/yasmin-release;${ROS_BRANCH};protocol=https"
SRCREV = "27417a2d7453d38bc3879ca449d3c0c45ef0c4e2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}