# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The abseil_cpp package"
AUTHOR = "dfaconti <davide.faconti@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=211ba54883815de9f52a3dcd9f281523"

ROS_CN = "abseil_cpp"
ROS_BPN = "abseil_cpp"

ROS_BUILD_DEPENDS = " \
    rsync \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/Eurecat/abseil_cpp-release/archive/release/kinetic/abseil_cpp/0.4.2-3.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e2876759a637ebb6a2190300b48d7d77"
SRC_URI[sha256sum] = "083780d48676ac440c77547f557a27cd42746d4f7e42787ca4bf198d79cdc2ff"
S = "${WORKDIR}/abseil_cpp-release-release-kinetic-abseil_cpp-0.4.2-3"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('abseil-cpp', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('abseil-cpp', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abseil-cpp/abseil-cpp_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abseil-cpp/abseil-cpp-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abseil-cpp/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abseil-cpp/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
