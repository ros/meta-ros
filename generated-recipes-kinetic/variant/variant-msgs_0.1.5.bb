# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Variant messages are designed to accommodate the information content     of any invariant message. They are truly generic and can freely be     converted to and from specific message objects."
AUTHOR = "Ralf Kaestner <ralf.kaestner@gmail.com>"
ROS_AUTHOR = "Ralf Kaestner"
HOMEPAGE = "http://github.com/ethz-asl/ros-topic-variant"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=146ba316845cfe6058c8baebd902a726"

ROS_CN = "variant"
ROS_BPN = "variant_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
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

SRC_URI = "https://github.com/anybotics/variant-release/archive/release/kinetic/variant_msgs/0.1.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "89061e4aa6fd4a7f29243f505328ef89"
SRC_URI[sha256sum] = "ddebb68e13b13b0a715623f622248e47f235cb8ae4b3595cf7f8c619fe7afbe7"
S = "${WORKDIR}/variant-release-release-kinetic-variant_msgs-0.1.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('variant', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('variant', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variant/variant_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variant/variant-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variant/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variant/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
