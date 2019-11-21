# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Conversions between grid maps and Point Cloud Library (PCL) types."
AUTHOR = "Péter Fankhauser <pfankhauser@anybotics.com>"
ROS_AUTHOR = "Dominic Jud <djud@ethz.ch>"
HOMEPAGE = "http://github.com/anybotics/grid_map"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "grid_map"
ROS_BPN = "grid_map_pcl"

ROS_BUILD_DEPENDS = " \
    grid-map-core \
    pcl-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    grid-map-core \
    pcl-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    grid-map-core \
    pcl-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/anybotics/grid_map-release/archive/release/kinetic/grid_map_pcl/1.6.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aa28d836ba748e73a4d6bd7b3ccc99ed"
SRC_URI[sha256sum] = "5df44de3ea0df1daf65378bb43fea5d2345d63c6a13382ce83e8c6267022e007"
S = "${WORKDIR}/grid_map-release-release-kinetic-grid_map_pcl-1.6.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('grid-map', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('grid-map', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/grid-map/grid-map_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/grid-map/grid-map-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/grid-map/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/grid-map/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
