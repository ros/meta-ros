# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A package that manages information about targets in a swarm of cyber physical systems (CPSs)."
AUTHOR = "Micha Sende <sende@lakeside-labs.com>"
ROS_AUTHOR = "Micha Sende <sende@lakeside-labs.com>"
HOMEPAGE = "http://wiki.ros.org/target_monitor"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=6f91c9c2152084419f27a1b670c005fa"

ROS_CN = "swarm_functions"
ROS_BPN = "target_monitor"

ROS_BUILD_DEPENDS = " \
    cpswarm_msgs \
    geometry-msgs \
    roscpp \
    swarmros \
    tf2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cpswarm_msgs \
    geometry-msgs \
    roscpp \
    swarmros \
    tf2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cpswarm_msgs \
    geometry-msgs \
    roscpp \
    swarmros \
    tf2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/cpswarm/swarm_functions-release/archive/release/kinetic/target_monitor/1.1.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "63aa7bf9c0246cb069be848402bca26a"
SRC_URI[sha256sum] = "543537106fa90939a2c368947fec9b62db886b170d82e2ecf007a1b319ef9468"
S = "${WORKDIR}/swarm_functions-release-release-kinetic-target_monitor-1.1.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('swarm-functions', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('swarm-functions', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/swarm-functions/swarm-functions_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/swarm-functions/swarm-functions-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/swarm-functions/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/swarm-functions/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
