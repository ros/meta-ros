# Recipe created by ros-generate
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit ros_generate_generated

DESCRIPTION = "Parse a YAML parameter file and populate the C data structure."
AUTHOR = "Audrow Nash <audrow@openrobotics.org>"
ROS_AUTHOR = "Anup Pemmaiah <anup.pemmaiah@apex.ai>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rcl"
ROS_BPN = "rcl_yaml_param_parser"

ROS_BUILD_DEPENDS = "\
    libyaml-vendor\
    rcutils\
    rmw\
    libyaml\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
    ament-cmake-gen-version-h-native\
"

ROS_EXPORT_DEPENDS = "\
    libyaml-vendor\
    rcutils\
    rmw\
    libyaml\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    libyaml-vendor\
    rcutils\
    rmw\
    libyaml\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-common\
    ament-lint-auto\
    mimick-vendor\
    osrf-testing-tools-cpp\
    performance-test-fixture\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/rcl.git;${ROS_BRANCH};protocol=https"
SRCREV = "0c4a71a5f27d52bfbbce17e2ba55bf5a6dc744b6"
S = "${WORKDIR}/git/rcl_yaml_param_parser"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
