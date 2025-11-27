# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    The ROS client library common implementation.\
    This package contains an API which builds on the ROS middleware API and is optionally built upon by the other ROS client libraries.\
"
AUTHOR = "Audrow Nash <audrow@openrobotics.org>"
ROS_AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rcl"
ROS_BPN = "rcl"

ROS_BUILD_DEPENDS = "\
    libyaml-vendor\
    rcl-interfaces\
    rcl-logging-interface\
    rcl-logging-spdlog\
    rcl-yaml-param-parser\
    rcutils\
    rmw-implementation\
    rosidl-runtime-c\
    service-msgs\
    tracetools\
    type-description-interfaces\
    libyaml\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
    ament-cmake-gen-version-h-native\
"

ROS_EXPORT_DEPENDS = "\
    rmw\
    libyaml-vendor\
    rcl-interfaces\
    rcl-logging-interface\
    rcl-logging-spdlog\
    rcl-yaml-param-parser\
    rcutils\
    rmw-implementation\
    rosidl-runtime-c\
    service-msgs\
    tracetools\
    type-description-interfaces\
    libyaml\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    libyaml-vendor\
    rcl-interfaces\
    rcl-logging-interface\
    rcl-logging-spdlog\
    rcl-yaml-param-parser\
    rcutils\
    rmw-implementation\
    rosidl-runtime-c\
    service-msgs\
    tracetools\
    type-description-interfaces\
    libyaml\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-common\
    launch\
    launch-testing\
    launch-testing-ament-cmake\
    mimick-vendor\
    osrf-testing-tools-cpp\
    rmw\
    rmw-implementation-cmake\
    rosidl-runtime-cpp\
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
SRC_URI = "git://github.com/ros2/rcl.git;${ROS_BRANCH};protocol=https"
SRCREV = "d1832c576f16da1cc35d03a4f1fac4e2e0ca9182"
S = "${WORKDIR}/git/rcl"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
