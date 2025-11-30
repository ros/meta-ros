# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Nav2 utilities"
AUTHOR = "Michael Jeronimo <michael.jeronimo@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_util"
ROS_BPN = "nav2_util"

ROS_BUILD_DEPENDS = "\
    nav2-common\
    bond\
    bondcpp\
    builtin-interfaces\
    geometry-msgs\
    lifecycle-msgs\
    nav2-msgs\
    nav-msgs\
    rcl-interfaces\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    std-msgs\
    tf2\
    tf2-geometry-msgs\
    tf2-msgs\
    tf2-ros\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    nav2-common\
    bond\
    bondcpp\
    builtin-interfaces\
    geometry-msgs\
    lifecycle-msgs\
    nav2-msgs\
    nav-msgs\
    rcl-interfaces\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    std-msgs\
    tf2\
    tf2-geometry-msgs\
    tf2-msgs\
    tf2-ros\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    nav2-common\
    bond\
    bondcpp\
    builtin-interfaces\
    geometry-msgs\
    lifecycle-msgs\
    nav2-msgs\
    nav-msgs\
    rcl-interfaces\
    rclcpp\
    rclcpp-action\
    rclcpp-lifecycle\
    std-msgs\
    tf2\
    tf2-geometry-msgs\
    tf2-msgs\
    tf2-ros\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
    ament-cmake-gtest\
    std-srvs\
    test-msgs\
    ament-cmake-pytest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_util"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "4595015f391a81958e8f9efc45ae1ffa3dc28b38"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
