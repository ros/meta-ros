# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Refactored map server for ROS2 Navigation"
AUTHOR = "Brian Wilcox <brian.wilcox@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_map_server"
ROS_BPN = "nav2_map_server"

ROS_BUILD_DEPENDS = "\
    nav2-common\
    rclcpp-lifecycle\
    nav-msgs\
    std-msgs\
    rclcpp\
    yaml-cpp-vendor\
    launch-ros\
    launch-testing\
    tf2\
    nav2-msgs\
    nav2-util\
    graphicsmagick\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp-lifecycle\
    nav-msgs\
    std-msgs\
    rclcpp\
    yaml-cpp-vendor\
    launch-ros\
    launch-testing\
    tf2\
    nav2-msgs\
    nav2-util\
    graphicsmagick\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp-lifecycle\
    nav-msgs\
    std-msgs\
    rclcpp\
    yaml-cpp-vendor\
    launch-ros\
    launch-testing\
    tf2\
    nav2-msgs\
    nav2-util\
    graphicsmagick\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
    ament-cmake-gtest\
    ament-cmake-pytest\
    launch\
    launch-testing\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_map_server"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "f073ad9ed734307e4cd21bd2f36b4ceea101d266"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
