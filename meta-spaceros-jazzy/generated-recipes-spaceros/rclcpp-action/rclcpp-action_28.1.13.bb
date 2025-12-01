# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Adds action APIs for C++."
AUTHOR = "Ivan Paunovic <ivanpauno@ekumenlabs.com>"
ROS_AUTHOR = "Dirk Thomas <dthomas@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rclcpp"
ROS_BPN = "rclcpp_action"

ROS_BUILD_DEPENDS = "\
    rosidl-runtime-c\
    action-msgs\
    rclcpp\
    rcl-action\
    rcl\
    rcpputils\
    ament-cmake\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
"

ROS_EXPORT_DEPENDS = "\
    rosidl-runtime-c\
    action-msgs\
    rclcpp\
    rcl-action\
    rcl\
    rcpputils\
    ament-cmake\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    action-msgs\
    rclcpp\
    rcl-action\
    rcl\
    rcpputils\
    ament-cmake\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-common\
    mimick-vendor\
    performance-test-fixture\
    test-msgs\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/rclcpp.git;${ROS_BRANCH};protocol=https"
SRCREV = "525a41818866ca44aa7418393fe5f94732ab3831"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/rclcpp_action"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
