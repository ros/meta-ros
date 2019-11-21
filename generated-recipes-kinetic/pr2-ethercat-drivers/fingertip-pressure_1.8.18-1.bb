# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package provides access to the PR2 fingertip pressure sensors. This information includes:"
AUTHOR = "David Feil-Seifer <dave@cse.unr.edu>"
ROS_AUTHOR = "Blaise Gassend <blaise@willowgarage.com>"
HOMEPAGE = "http://ros.org/wiki/fingertip_pressure"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_ethercat_drivers"
ROS_BPN = "fingertip_pressure"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    rostest \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    pr2-msgs \
    rospy \
    std-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    pr2-msgs \
    rospy \
    std-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/PR2-prime/pr2_ethercat_drivers-release/archive/release/kinetic/fingertip_pressure/1.8.18-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2a5c87cbc2e8bb5a3e958fe06f228967"
SRC_URI[sha256sum] = "b35507f0ab9bd282917899968b834b8df0beeb1ab9c628d59356c37d687296ca"
S = "${WORKDIR}/pr2_ethercat_drivers-release-release-kinetic-fingertip_pressure-1.8.18-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pr2-ethercat-drivers', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pr2-ethercat-drivers', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-ethercat-drivers/pr2-ethercat-drivers_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-ethercat-drivers/pr2-ethercat-drivers-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-ethercat-drivers/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-ethercat-drivers/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
