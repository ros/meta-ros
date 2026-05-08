# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "ROS Support Library"
AUTHOR = "bmagyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Tyler Weaver <maybe@tylerjw.dev>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "rsl"
ROS_BPN = "rsl"

ROS_BUILD_DEPENDS = "\
    libeigen\
    fmt\
    rclcpp\
    tcb-span\
    tl-expected\
"

ROS_BUILDTOOL_DEPENDS = "\
    doxygen-native\
"

ROS_EXPORT_DEPENDS = "\
    libeigen\
    fmt\
    rclcpp\
    tcb-span\
    tl-expected\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    libeigen\
    fmt\
    rclcpp\
    tcb-span\
    tl-expected\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-ros\
    clang\
    git\
    range-v3\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/rsl"
SRC_URI = "git://github.com/ros2-gbp/RSL-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "5dd7ad86bcec61e1684c913b2584cb3ff45ea742"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
