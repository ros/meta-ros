# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Common support functionality used throughout the navigation 2 stack"
AUTHOR = "Carl Delsey <carl.r.delsey@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_common"
ROS_BPN = "nav2_common"

ROS_BUILD_DEPENDS = "\
    ament-cmake-python\
    launch\
    launch-ros\
    osrf-pycommon\
    rclpy\
    python3-pyyaml\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-core-native\
"

ROS_EXPORT_DEPENDS = "\
    launch\
    launch-ros\
    osrf-pycommon\
    rclpy\
    python3-pyyaml\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    ament-cmake-core-native\
"

ROS_EXEC_DEPENDS = "\
    launch\
    launch-ros\
    osrf-pycommon\
    rclpy\
    python3-pyyaml\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_common"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "a5e4bd26962f825eaaf20fe9865eccdc5d3a374f"
S = "${WORKDIR}/git/nav2_common"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
