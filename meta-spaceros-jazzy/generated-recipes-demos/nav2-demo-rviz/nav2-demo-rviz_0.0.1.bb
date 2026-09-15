# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Minimal RViz launch and config for the Space ROS Nav2 Curiosity demo"
AUTHOR = "Open Robotics <openrobotics@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "src"
ROS_BPN = "nav2_demo_rviz"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    launch\
    launch-ros\
    nav2-common\
    nav2-rviz-plugins\
    rviz2\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we
# needed them to build this package (even though we actually don't) so
# that they're guaranteed to have been staged should this package appear
# in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=main"
SRC_URI = "git://github.com/space-ros/demos.git;${ROS_BRANCH};protocol=https"
SRCREV = "925fe48e09cff6d79cc8455265bcd09b51b5ee5b"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/nav2_demo/nav2_demo_rviz"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
