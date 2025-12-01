# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "A set of BT nodes and XMLs for docking"
AUTHOR = "Steve Macenski <steve@opennav.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "opennav_docking_bt"
ROS_BPN = "opennav_docking_bt"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    nav2-behavior-tree\
    nav2-util\
    nav2-core\
    nav2-msgs\
    nav-msgs\
    geometry-msgs\
    behaviortree-cpp\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    nav2-behavior-tree\
    nav2-util\
    nav2-core\
    nav2-msgs\
    nav-msgs\
    geometry-msgs\
    behaviortree-cpp\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    rclcpp-action\
    nav2-behavior-tree\
    nav2-util\
    nav2-core\
    nav2-msgs\
    nav-msgs\
    geometry-msgs\
    behaviortree-cpp\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/opennav_docking_bt"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "06663a901806c9d3d522c57a02e936dfb8303d22"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
