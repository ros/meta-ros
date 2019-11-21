# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Mapping tools to be used with the <a href="http://octomap.github.io/">OctoMap library</a>, implementing a 3D occupancy grid mapping."
AUTHOR = "Armin Hornung <armin@hornung.io>"
ROS_AUTHOR = "Armin Hornung"
HOMEPAGE = "http://ros.org/wiki/octomap_mapping"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=5ee5b8b046ae48ad94a2037ca953a67b"

ROS_CN = "octomap_mapping"
ROS_BPN = "octomap_mapping"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    octomap-server \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    octomap-server \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/octomap_mapping-release/archive/release/kinetic/octomap_mapping/0.6.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7e977b50708ad2fee7187a9c36ab5510"
SRC_URI[sha256sum] = "109367aa699fdd9057fe985315d3efb79bf8f881dd9d6f260e7a4a17d47b5fdb"
S = "${WORKDIR}/octomap_mapping-release-release-kinetic-octomap_mapping-0.6.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('octomap-mapping', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('octomap-mapping', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/octomap-mapping/octomap-mapping_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/octomap-mapping/octomap-mapping-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/octomap-mapping/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/octomap-mapping/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
