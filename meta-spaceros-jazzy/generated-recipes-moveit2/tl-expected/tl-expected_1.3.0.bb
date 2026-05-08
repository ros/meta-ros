# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "C++11/14/17 std::expected with functional-style extensions"
AUTHOR = "bmagyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Sy Brand"
HOMEPAGE = "https://github.com/TartanLlama/expected"
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=6f5d8ed55114879c1a229533f1b5b91d"

ROS_CN = "tl_expected"
ROS_BPN = "tl_expected"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/tl_expected"
SRC_URI = "git://github.com/ros2-gbp/cpp_polyfills-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "40c19d8b3dc3be6fa1adadf16fbce83f0f5bc3e4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
