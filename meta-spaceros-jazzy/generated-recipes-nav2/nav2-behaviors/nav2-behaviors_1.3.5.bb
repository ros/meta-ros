# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Nav2 behavior server"
AUTHOR = "Carlos Orduno <carlos.a.orduno@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_behaviors"
ROS_BPN = "nav2_behaviors"

ROS_BUILD_DEPENDS = "\
    nav2-common\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    nav2-behavior-tree\
    nav2-util\
    nav2-msgs\
    nav-msgs\
    tf2\
    tf2-geometry-msgs\
    geometry-msgs\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    nav2-behavior-tree\
    nav2-util\
    nav2-msgs\
    nav-msgs\
    geometry-msgs\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
    ament-cmake-gtest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_behaviors"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "3c6c89a086d11fa4d1d1cc81673dc1d35167a167"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
