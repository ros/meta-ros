# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Message and service definitions for the ROSflight ROS stack"
AUTHOR = "Daniel Koch <daniel.p.koch@gmail.com>"
ROS_AUTHOR = "Daniel Koch <daniel.p.koch@gmail.com>"
HOMEPAGE = "http://rosflight.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rosflight"
ROS_BPN = "rosflight_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/rosflight/rosflight-release/archive/release/kinetic/rosflight_msgs/1.0.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d6d50f68cc015979dc03b23f673f5030"
SRC_URI[sha256sum] = "c14dec48c1306792d18490e5b388a4199656e1c434d8fa7f3ea7e22a3e306a5c"
S = "${WORKDIR}/rosflight-release-release-kinetic-rosflight_msgs-1.0.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rosflight', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rosflight', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosflight/rosflight_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosflight/rosflight-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosflight/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosflight/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
