# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Theta* Global Planning Plugin"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_theta_star_planner"
ROS_BPN = "nav2_theta_star_planner"

ROS_BUILD_DEPENDS = "\
    builtin-interfaces\
    nav2-common\
    nav2-core\
    nav2-costmap-2d\
    nav2-msgs\
    nav2-util\
    pluginlib\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    tf2-ros\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    builtin-interfaces\
    nav2-common\
    nav2-core\
    nav2-costmap-2d\
    nav2-msgs\
    nav2-util\
    pluginlib\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    tf2-ros\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    builtin-interfaces\
    nav2-common\
    nav2-core\
    nav2-costmap-2d\
    nav2-msgs\
    nav2-util\
    pluginlib\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    tf2-ros\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-common\
    ament-cmake-gtest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_theta_star_planner"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "f08498eb60257c9a749e9b6c1a9ddeab79d952a2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
