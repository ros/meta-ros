# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A plugin to image_transport for transparently sending images encoded with ImageZero."
AUTHOR = "P. J. Reed <preed@swri.org>"
ROS_AUTHOR = "P. J. Reed"
HOMEPAGE = "http://www.ros.org/wiki/image_transport_plugins"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "imagezero_transport"
ROS_BPN = "imagezero_image_transport"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    image-transport \
    imagezero-ros \
    message-runtime \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    image-transport \
    imagezero-ros \
    message-runtime \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    image-transport \
    imagezero-ros \
    message-runtime \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/swri-robotics-gbp/imagezero_transport-release/archive/release/kinetic/imagezero_image_transport/0.2.4-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "75fc07e0dced5cee0d74a659721cd34c"
SRC_URI[sha256sum] = "9ed895b2065c4d0a608fb421cdd510e5b6d75f657ce93f6f08858271ce69a66e"
S = "${WORKDIR}/imagezero_transport-release-release-kinetic-imagezero_image_transport-0.2.4-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('imagezero-transport', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('imagezero-transport', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imagezero-transport/imagezero-transport_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imagezero-transport/imagezero-transport-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imagezero-transport/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imagezero-transport/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
