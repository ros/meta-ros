# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Nav2 behavior tree wrappers, nodes, and utilities"
AUTHOR = "Michael Jeronimo <michael.jeronimo@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_behavior_tree"
ROS_BPN = "nav2_behavior_tree"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    behaviortree-cpp\
    builtin-interfaces\
    geometry-msgs\
    sensor-msgs\
    nav2-msgs\
    nav-msgs\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
    std-msgs\
    std-srvs\
    nav2-util\
    lifecycle-msgs\
    nav2-common\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    tf2-geometry-msgs\
    std-srvs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    std-msgs\
    behaviortree-cpp\
    builtin-interfaces\
    geometry-msgs\
    sensor-msgs\
    nav2-msgs\
    nav-msgs\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
    nav2-util\
    lifecycle-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
    ament-cmake-gtest\
    test-msgs\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_behavior_tree"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "702bd25133da8c4377b385dfcd5f7e7ebeb9487d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
