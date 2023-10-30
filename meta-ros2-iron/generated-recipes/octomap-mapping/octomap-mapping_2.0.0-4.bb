# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "Mapping tools to be used with the <a href="https://octomap.github.io/">OctoMap library</a>, implementing a 3D occupancy grid mapping."
AUTHOR = "Wolfgang Merkt <opensource@wolfgangmerkt.com>"
ROS_AUTHOR = "Armin Hornung"
HOMEPAGE = "http://ros.org/wiki/octomap_mapping"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "octomap_mapping"
ROS_BPN = "octomap_mapping"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    octomap-server \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/octomap_mapping-release/archive/release/iron/octomap_mapping/2.0.0-4.tar.gz
ROS_BRANCH ?= "branch=release/iron/octomap_mapping"
SRC_URI = "git://github.com/ros2-gbp/octomap_mapping-release;${ROS_BRANCH};protocol=https"
SRCREV = "396201c152767caed87f479f83504428198d3777"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
