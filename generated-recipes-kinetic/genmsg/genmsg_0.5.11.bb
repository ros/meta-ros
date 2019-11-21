# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Troy Straszheim"
HOMEPAGE = "http://www.ros.org/wiki/genmsg"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "genmsg"
ROS_BPN = "genmsg"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    catkin \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    catkin \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/genmsg-release/archive/release/kinetic/genmsg/0.5.11-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "74662d800443d813ad059601c7425c1d"
SRC_URI[sha256sum] = "24dbb7dc91d8a7c56f0c65129d80b2f05d3847a39ced744e73ccc295897afa42"
S = "${WORKDIR}/genmsg-release-release-kinetic-genmsg-0.5.11-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('genmsg', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('genmsg', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genmsg/genmsg_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genmsg/genmsg-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genmsg/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genmsg/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
