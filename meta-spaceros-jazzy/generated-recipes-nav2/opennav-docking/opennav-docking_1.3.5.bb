# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "A Task Server for robot charger docking"
AUTHOR = "Steve Macenski <steve@opennav.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "opennav_docking"
ROS_BPN = "opennav_docking"

ROS_BUILD_DEPENDS = "\
    angles\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    nav2-graceful-controller\
    nav2-msgs\
    nav2-util\
    nav-msgs\
    geometry-msgs\
    builtin-interfaces\
    sensor-msgs\
    pluginlib\
    yaml-cpp-vendor\
    opennav-docking-core\
    tf2-ros\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    angles\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    nav2-graceful-controller\
    nav2-msgs\
    nav2-util\
    nav-msgs\
    geometry-msgs\
    builtin-interfaces\
    sensor-msgs\
    pluginlib\
    yaml-cpp-vendor\
    opennav-docking-core\
    tf2-ros\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    angles\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    nav2-graceful-controller\
    nav2-msgs\
    nav2-util\
    nav-msgs\
    geometry-msgs\
    builtin-interfaces\
    sensor-msgs\
    pluginlib\
    yaml-cpp-vendor\
    opennav-docking-core\
    tf2-ros\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-cmake-pytest\
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

ROS_BRANCH ?= "branch=release/jazzy/opennav_docking"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "435ead6e35f21d4602bd6361f48d617c989b4224"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
