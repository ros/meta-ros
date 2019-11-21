# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "mavros_msgs defines messages for <a href="http://wiki.ros.org/mavros">MAVROS</a>."
AUTHOR = "Vladimir Ermakov <vooon341@gmail.com>"
ROS_AUTHOR = "Vladimir Ermakov <vooon341@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/mavros_msgs"
SECTION = "devel"
LICENSE = "GPL-3 & LGPL-2 & BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "mavros"
ROS_BPN = "mavros_msgs"

ROS_BUILD_DEPENDS = " \
    geographic-msgs \
    geometry-msgs \
    message-generation \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geographic-msgs \
    geometry-msgs \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geographic-msgs \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/mavlink/mavros-release/archive/release/kinetic/mavros_msgs/0.33.3-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "859a47d759b7b0193c1f4cfb587ba3a2"
SRC_URI[sha256sum] = "a7dfb08ce91ede68db275535074dc2eee791be330833e885a8e9cf41fe81c62b"
S = "${WORKDIR}/mavros-release-release-kinetic-mavros_msgs-0.33.3-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('mavros', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('mavros', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mavros/mavros_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mavros/mavros-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mavros/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mavros/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
