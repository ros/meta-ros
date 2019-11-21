# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The khi_rs_ikfast_plugin package"
AUTHOR = "matsui_hiro <matsui_hiro@khi.co.jp>"
ROS_AUTHOR = "matsui_hiro <matsui_hiro@khi.co.jp>"
HOMEPAGE = "http://ros.org/wiki/khi_robot"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "khi_robot"
ROS_BPN = "khi_rs_ikfast_plugin"

ROS_BUILD_DEPENDS = " \
    lapack \
    moveit-core \
    pluginlib \
    roscpp \
    tf-conversions \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    lapack \
    moveit-core \
    pluginlib \
    roscpp \
    tf-conversions \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/Kawasaki-Robotics/khi_robot-release/archive/release/kinetic/khi_rs_ikfast_plugin/1.1.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f572a8a1cc5c4091893a09e704236461"
SRC_URI[sha256sum] = "f38eeb5fe9d9ed489432cdab4465fd90105bf0855dca96de55bfda398c3a2004"
S = "${WORKDIR}/khi_robot-release-release-kinetic-khi_rs_ikfast_plugin-1.1.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('khi-robot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('khi-robot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/khi-robot/khi-robot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/khi-robot/khi-robot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/khi-robot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/khi-robot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
