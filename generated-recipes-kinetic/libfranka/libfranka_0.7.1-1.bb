# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "libfranka is a C++ library for Franka Emika research robots"
AUTHOR = "Franka Emika GmbH <support@franka.de>"
ROS_AUTHOR = "Franka Emika GmbH"
HOMEPAGE = "https://frankaemika.github.io"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "libfranka"
ROS_BPN = "libfranka"

ROS_BUILD_DEPENDS = " \
    libeigen \
    poco \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    catkin \
    poco \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/frankaemika/libfranka-release/archive/release/kinetic/libfranka/0.7.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ef3674745b1e2a8cb8356ebe518ca36a"
SRC_URI[sha256sum] = "9d5b667fcc4238a81e88ca0ec116d1bfcb167f4967a23ac03e374abce7903fd7"
S = "${WORKDIR}/libfranka-release-release-kinetic-libfranka-0.7.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('libfranka', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('libfranka', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/libfranka/libfranka_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/libfranka/libfranka-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/libfranka/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/libfranka/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
