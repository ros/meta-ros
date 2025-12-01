# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Rotation Shim Controller"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_rotation_shim_controller"
ROS_BPN = "nav2_rotation_shim_controller"

ROS_BUILD_DEPENDS = "\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    rclcpp\
    geometry-msgs\
    nav2-msgs\
    angles\
    pluginlib\
    tf2\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    rclcpp\
    geometry-msgs\
    nav2-msgs\
    angles\
    pluginlib\
    tf2\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    rclcpp\
    geometry-msgs\
    nav2-msgs\
    angles\
    pluginlib\
    tf2\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-common\
    ament-lint-auto\
    nav2-regulated-pure-pursuit-controller\
    nav2-controller\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_rotation_shim_controller"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "29f83f661018584733c384f6d3486eb0f93733ab"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
