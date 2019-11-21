# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A simple USB camera driver for the FLIR BOSON using OpenCV"
AUTHOR = "AutonomouStuff Software Development Team <software@autonomoustuff.com>"
ROS_AUTHOR = "Joe Driscoll <jdriscoll@autonomoustuff.com>"
HOMEPAGE = "http://wiki.ros.org/flir_boson_usb"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "flir_boson_usb"
ROS_BPN = "flir_boson_usb"

ROS_BUILD_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    image-transport \
    nodelet \
    roscpp \
    roslint \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    image-transport \
    nodelet \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    image-transport \
    nodelet \
    roscpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/astuff/flir_boson_usb-release/archive/release/kinetic/flir_boson_usb/1.2.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "70f9885240726742ff40c272fe51890c"
SRC_URI[sha256sum] = "acc7d8181cb7b0caa72414bc70e99e76583669a799914a6f1c0a95867df816fc"
S = "${WORKDIR}/flir_boson_usb-release-release-kinetic-flir_boson_usb-1.2.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('flir-boson-usb', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('flir-boson-usb', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/flir-boson-usb/flir-boson-usb_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/flir-boson-usb/flir-boson-usb-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/flir-boson-usb/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/flir-boson-usb/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
