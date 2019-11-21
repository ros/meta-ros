# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "These are regression tests for the osm_cartography and      route_network packages. They are packaged separately to avoid      unnecessary implementation dependencies."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://ros.org/wiki/test_osm"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "open_street_map"
ROS_BPN = "test_osm"

ROS_BUILD_DEPENDS = " \
    geodesy \
    geographic-msgs \
    osm-cartography \
    route-network \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geodesy \
    geographic-msgs \
    osm-cartography \
    route-network \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geodesy \
    geographic-msgs \
    osm-cartography \
    route-network \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-geographic-info/open_street_map-release/archive/release/kinetic/test_osm/0.2.4-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f71921576f1a3ef97cd14183e9a77056"
SRC_URI[sha256sum] = "7fd6af55b0a2548b5d501882bcac1429f7ad9039be66bc07a5049b6229cdeb17"
S = "${WORKDIR}/open_street_map-release-release-kinetic-test_osm-0.2.4-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('open-street-map', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('open-street-map', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-street-map/open-street-map_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-street-map/open-street-map-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-street-map/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-street-map/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
