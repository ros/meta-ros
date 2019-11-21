# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A ROS node that watches a given network interface and publishes      whether it is both UP and RUNNING (indicating that a cable is      plugged into it and communication is happening, for instance) or      not."
AUTHOR = "Devon Ash <dash@clearpathrobotics.com>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "http://ros.org/wiki/detect_running_network_interface"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "linux_networking"
ROS_BPN = "network_detector"

ROS_BUILD_DEPENDS = " \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/pr2-gbp/linux_networking-release/archive/release/kinetic/network_detector/1.0.15-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "63a5179d032dfab30b6533ab98034c91"
SRC_URI[sha256sum] = "1517add1961f39be682a01927313133edfa6394d67772586953d4f5b41875a29"
S = "${WORKDIR}/linux_networking-release-release-kinetic-network_detector-1.0.15-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('linux-networking', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('linux-networking', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/linux-networking/linux-networking_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/linux-networking/linux-networking-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/linux-networking/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/linux-networking/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
