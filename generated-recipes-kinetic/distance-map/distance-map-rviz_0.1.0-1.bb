# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Rviz plugin for the visualization of ditance maps."
AUTHOR = "Jeremie Deray <deray.jeremie@gmail.com>"
ROS_AUTHOR = "Jeremie Deray <deray.jeremie@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "distance_map"
ROS_BPN = "distance_map_rviz"

ROS_BUILD_DEPENDS = " \
    distance-map-msgs \
    qtbase \
    rviz \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    distance-map-msgs \
    rviz \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    distance-map-msgs \
    qtbase \
    rviz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/artivis/distance_map-release/archive/release/kinetic/distance_map_rviz/0.1.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3015f14a7f8fa3c3b91ead7f896e4927"
SRC_URI[sha256sum] = "300f694c2596460284c19a916576ed8a9e3fd95fb009d8c196d9e0e0b7d85eaf"
S = "${WORKDIR}/distance_map-release-release-kinetic-distance_map_rviz-0.1.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('distance-map', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('distance-map', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/distance-map/distance-map_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/distance-map/distance-map-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/distance-map/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/distance-map/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
