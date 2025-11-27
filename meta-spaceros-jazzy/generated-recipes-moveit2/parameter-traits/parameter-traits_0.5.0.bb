# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Functions and types for rclcpp::Parameter"
AUTHOR = "Tyler Weaver <maybe@tylerjw.dev>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "parameter_traits"
ROS_BPN = "parameter_traits"

ROS_BUILD_DEPENDS = "\
    fmt\
    rclcpp\
    rsl\
    tcb-span\
    tl-expected\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    fmt\
    rclcpp\
    rsl\
    tcb-span\
    tl-expected\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    fmt\
    rclcpp\
    rsl\
    tcb-span\
    tl-expected\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-common\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/parameter_traits"
SRC_URI = "git://github.com/ros2-gbp/generate_parameter_library-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "b499d6df7e606e9e79090c6eece0e40a5ba6c7e4"
S = "${WORKDIR}/git/parameter_traits"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
