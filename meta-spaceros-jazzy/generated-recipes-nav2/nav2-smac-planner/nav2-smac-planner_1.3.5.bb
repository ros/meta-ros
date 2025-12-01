# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Smac global planning plugin: A*, Hybrid-A*, State Lattice"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_smac_planner"
ROS_BPN = "nav2_smac_planner"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    visualization-msgs\
    nav2-util\
    nav2-msgs\
    nav-msgs\
    geometry-msgs\
    builtin-interfaces\
    nav2-common\
    tf2-ros\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
    eigen3-cmake-module\
    libeigen\
    ompl\
    nlohmann-json\
    angles\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    visualization-msgs\
    nav2-util\
    nav2-msgs\
    nav-msgs\
    geometry-msgs\
    builtin-interfaces\
    nav2-common\
    tf2-ros\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
    eigen3-cmake-module\
    libeigen\
    ompl\
    nlohmann-json\
    angles\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    visualization-msgs\
    nav2-util\
    nav2-msgs\
    nav-msgs\
    geometry-msgs\
    builtin-interfaces\
    nav2-common\
    tf2-ros\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
    eigen3-cmake-module\
    libeigen\
    ompl\
    nlohmann-json\
    angles\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
    ament-cmake-gtest\
    ament-cmake-pytest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_smac_planner"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "14052985924be903d02034bb8ec28ccc5364fac5"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
