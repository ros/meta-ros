# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Supporting utilities for ROSflight packages"
AUTHOR = "gary <gary.ellingson@byu.edu>"
HOMEPAGE = "http://rosflight.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rosflight"
ROS_BPN = "rosflight_utils"

ROS_BUILD_DEPENDS = " \
    gazebo-msgs \
    geometry-msgs \
    roscpp \
    rosflight-msgs \
    rosgraph-msgs \
    rospy \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gazebo-msgs \
    geometry-msgs \
    roscpp \
    rosflight-msgs \
    rosgraph-msgs \
    rospy \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-msgs \
    geometry-msgs \
    roscpp \
    rosflight-msgs \
    rosgraph-msgs \
    rospy \
    sensor-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/rosflight/rosflight-release/archive/release/kinetic/rosflight_utils/1.0.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e0ae2170c11693b08c70af739849c8fe"
SRC_URI[sha256sum] = "0c02106323f3f2acf92d104a193f9698c81cf557e3c4962a944c242baf5e51a2"
S = "${WORKDIR}/rosflight-release-release-kinetic-rosflight_utils-1.0.0-1"

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
