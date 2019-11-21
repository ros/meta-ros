# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "tools for streaming JPEG-formatted CompressedImage topics over HTTP"
AUTHOR = "Ken Tossell <ken@tossell.net>"
ROS_AUTHOR = "Ken Tossell <ken@tossell.net>"
HOMEPAGE = "http://ros.org/wiki/jpeg_streamer"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "camera_umd"
ROS_BPN = "jpeg_streamer"

ROS_BUILD_DEPENDS = " \
    image-transport \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    image-transport \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    image-transport \
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

SRC_URI = "https://github.com/ros-drivers-gbp/camera_umd-release/archive/release/kinetic/jpeg_streamer/0.2.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "169d54581ac30d6792301e1f23a71372"
SRC_URI[sha256sum] = "bc0ec3ece34d11640edfd7538271d5f5233d3d41157e2859b9010fb6edc8e18b"
S = "${WORKDIR}/camera_umd-release-release-kinetic-jpeg_streamer-0.2.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('camera-umd', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('camera-umd', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/camera-umd/camera-umd_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/camera-umd/camera-umd-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/camera-umd/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/camera-umd/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
