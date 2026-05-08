# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Implementation of C++20's std::span"
AUTHOR = "bmagyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Tyler Weaver <maybe@tylerjw.dev>"
HOMEPAGE = "https://github.com/tcbrindle/span"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=6465d32b33c70d59e05ded7303b6c46c"

ROS_CN = "tcb_span"
ROS_BPN = "tcb_span"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=dynrpm/jazzy/tcb_span"
SRC_URI = "git://github.com/ros2-gbp/cpp_polyfills-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "861d3291435bdcf533e1f3c4ced786c1dcb557b4"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
