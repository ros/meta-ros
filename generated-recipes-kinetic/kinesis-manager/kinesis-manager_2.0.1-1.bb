# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "AWS Kinesis stream management library intended for use with the Kinesis Video Producer SDK"
AUTHOR = "AWS RoboMaker <ros-contributions@amazon.com>"
ROS_AUTHOR = "AWS RoboMaker <ros-contributions@amazon.com>"
HOMEPAGE = "http://wiki.ros.org/kinesis_manager"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "kinesis_manager"
ROS_BPN = "kinesis_manager"

ROS_BUILD_DEPENDS = " \
    aws-common \
    boost \
    curl \
    log4cplus \
    openssl \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
    pkgconfig-native \
"

ROS_EXPORT_DEPENDS = " \
    aws-common \
    boost \
    curl \
    log4cplus \
    openssl \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    aws-common \
    boost \
    curl \
    log4cplus \
    openssl \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/aws-gbp/kinesis_manager-release/archive/release/kinetic/kinesis_manager/2.0.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "758e621b985343bb3b5f0a394bd8d5f1"
SRC_URI[sha256sum] = "9f6ff5a12fc8c9cef93175befcd74a12a6b9e034f17f0cd6d15f296f0ed176ad"
S = "${WORKDIR}/kinesis_manager-release-release-kinetic-kinesis_manager-2.0.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('kinesis-manager', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('kinesis-manager', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kinesis-manager/kinesis-manager_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kinesis-manager/kinesis-manager-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kinesis-manager/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kinesis-manager/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
