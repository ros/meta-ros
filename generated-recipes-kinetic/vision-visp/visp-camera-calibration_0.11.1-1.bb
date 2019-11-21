# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "visp_camera_calibration allows easy calibration of      cameras using a customizable pattern and ViSP library."
AUTHOR = "Fabien Spindler <Fabien.Spindler@inria.fr>"
ROS_AUTHOR = "Filip Novotny"
HOMEPAGE = "http://wiki.ros.org/visp_camera_calibration"
SECTION = "devel"
LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=fe8b75cf0aba647401e1038bcd69ee74"

ROS_CN = "vision_visp"
ROS_BPN = "visp_camera_calibration"

ROS_BUILD_DEPENDS = " \
    camera-calibration-parsers \
    geometry-msgs \
    message-generation \
    roscpp \
    sensor-msgs \
    std-msgs \
    visp \
    visp-bridge \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-calibration-parsers \
    geometry-msgs \
    message-generation \
    message-runtime \
    roscpp \
    sensor-msgs \
    std-msgs \
    visp \
    visp-bridge \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-calibration-parsers \
    geometry-msgs \
    message-generation \
    message-runtime \
    roscpp \
    sensor-msgs \
    std-msgs \
    visp \
    visp-bridge \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/lagadic/vision_visp-release/archive/release/kinetic/visp_camera_calibration/0.11.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1bc1e6d4cc98809e4dfa8b4537b407bd"
SRC_URI[sha256sum] = "48bea444004f594c136b9877b758bde415204ea1ef8a64c919f2ad8b7c2dd9ed"
S = "${WORKDIR}/vision_visp-release-release-kinetic-visp_camera_calibration-0.11.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('vision-visp', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('vision-visp', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vision-visp/vision-visp_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vision-visp/vision-visp-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vision-visp/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vision-visp/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
