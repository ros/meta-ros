# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Persistent storage of ROS messages"
AUTHOR = "MoveIt Release Team <moveit_releasers@googlegroups.com>"
ROS_AUTHOR = "Bhaskara Marthi <bhaskara@willowgarage.com>"
HOMEPAGE = "http://ros.org/wiki/warehouse_ros"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "warehouse_ros"
ROS_BPN = "warehouse_ros"

ROS_BUILD_DEPENDS = "\
    boost\
    openssl\
    rclcpp\
    std-msgs\
    geometry-msgs\
    pluginlib\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    boost\
    openssl\
    rclcpp\
    std-msgs\
    geometry-msgs\
    pluginlib\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    boost\
    openssl\
    rclcpp\
    std-msgs\
    geometry-msgs\
    pluginlib\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-cmake-copyright\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/warehouse_ros"
SRC_URI = "git://github.com/ros2-gbp/warehouse_ros-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "b0ba8527e61cc2e1cb6097044a7071b9a68b4228"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
