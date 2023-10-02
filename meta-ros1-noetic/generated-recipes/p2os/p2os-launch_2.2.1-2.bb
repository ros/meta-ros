# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Launch and config files designed for use with the p2os stack."
AUTHOR = "Hunter L. Allen <hallen@kns.com>"
ROS_AUTHOR = "Hunter L. Allen <hallen@kns.com>"
HOMEPAGE = "http://ros.org/wiki/p2os-purdue"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "p2os"
ROS_BPN = "p2os_launch"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    p2os-driver \
    p2os-msgs \
    p2os-teleop \
    p2os-urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/allenh1/p2os-release/archive/release/noetic/p2os_launch/2.2.1-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/p2os_launch"
SRC_URI = "git://github.com/allenh1/p2os-release;${ROS_BRANCH};protocol=https"
SRCREV = "0fbd60f16f85df6a328f7b6fbefc2158dd3d9f87"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
