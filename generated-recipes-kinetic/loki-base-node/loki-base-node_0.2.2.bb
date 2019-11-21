# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "loki_base_node has a ROS node to communicate with the Loki robot base and allow communication with the motors and sonars"
AUTHOR = "Wayne Gramlich <Wayne@gramlich.net>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "loki_base_node"
ROS_BPN = "loki_base_node"

ROS_BUILD_DEPENDS = " \
    message-generation \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    roscpp \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/UbiquityRobotics-release/loki_base_node-release/archive/release/kinetic/loki_base_node/0.2.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3f1896e36ef15c40b9fb71e8f685b909"
SRC_URI[sha256sum] = "3a52534217926fe09476948959b9abaf8b5251e0a37f99bbbb5b2dae96c09b8f"
S = "${WORKDIR}/loki_base_node-release-release-kinetic-loki_base_node-0.2.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('loki-base-node', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('loki-base-node', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/loki-base-node/loki-base-node_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/loki-base-node/loki-base-node-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/loki-base-node/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/loki-base-node/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
