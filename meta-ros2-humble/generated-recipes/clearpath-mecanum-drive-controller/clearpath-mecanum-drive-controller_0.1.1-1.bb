# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Clearpath fork of mecanum drive controller for 4 wheel drive."
AUTHOR = "Luis Camero <lcamero@clearpathrobotics.com>"
ROS_AUTHOR = "Dr.-Ing. Denis Štogl <denis.stogl@stoglrobotics.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "clearpath_mecanum_drive_controller"
ROS_BPN = "clearpath_mecanum_drive_controller"

ROS_BUILD_DEPENDS = " \
    control-msgs \
    controller-interface \
    generate-parameter-library \
    geometry-msgs \
    hardware-interface \
    nav-msgs \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    rcpputils \
    realtime-tools \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    control-msgs \
    controller-interface \
    geometry-msgs \
    hardware-interface \
    nav-msgs \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    rcpputils \
    realtime-tools \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    control-msgs \
    controller-interface \
    geometry-msgs \
    hardware-interface \
    nav-msgs \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    rcpputils \
    realtime-tools \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    controller-manager \
    hardware-interface-testing \
    ros2-control-test-assets \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/clearpath-gbp/clearpath_mecanum_drive_controller-release/archive/release/humble/clearpath_mecanum_drive_controller/0.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/clearpath_mecanum_drive_controller"
SRC_URI = "git://github.com/clearpath-gbp/clearpath_mecanum_drive_controller-release;${ROS_BRANCH};protocol=https"
SRCREV = "8e1387cc494a09e18a72a76805824e9956abbe85"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
