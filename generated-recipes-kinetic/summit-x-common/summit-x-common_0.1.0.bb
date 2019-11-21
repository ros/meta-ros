# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The summit_x_common package"
AUTHOR = "Román Navarro <rnavarro@robotnik.es>"
ROS_AUTHOR = "Roberto Guzman <rguzman@robotnik.es>"
HOMEPAGE = "https://github.com/RobotnikAutomation/summit_x_common"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "summit_x_common"
ROS_BPN = "summit_x_common"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    summit-x-description \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    summit-x-description \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/RobotnikAutomation/summit_x_common-release/archive/release/kinetic/summit_x_common/0.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6ed1ebcf53bf979da98cd07590a96437"
SRC_URI[sha256sum] = "259a74cf499c88a43459a3ae1e1a60f91311989c50bd43d8ba1a571356d08ac8"
S = "${WORKDIR}/summit_x_common-release-release-kinetic-summit_x_common-0.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('summit-x-common', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('summit-x-common', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-x-common/summit-x-common_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-x-common/summit-x-common-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-x-common/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-x-common/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
