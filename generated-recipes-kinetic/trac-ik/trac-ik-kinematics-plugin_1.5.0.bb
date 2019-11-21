# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A MoveIt! Kinematics plugin using TRAC-IK"
AUTHOR = "Patrick Beeson <pbeeson@traclabs.com>"
ROS_AUTHOR = "Patrick Beeson"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "trac_ik"
ROS_BPN = "trac_ik_kinematics_plugin"

ROS_BUILD_DEPENDS = " \
    moveit-core \
    pluginlib \
    roscpp \
    tf-conversions \
    trac-ik-lib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    moveit-core \
    pluginlib \
    roscpp \
    tf-conversions \
    trac-ik-lib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    moveit-core \
    pluginlib \
    roscpp \
    tf-conversions \
    trac-ik-lib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/traclabs/trac_ik-release/archive/release/kinetic/trac_ik_kinematics_plugin/1.5.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "bea3924912888858a058a8f0d4714a4c"
SRC_URI[sha256sum] = "d9546126a9f9a68fae95aa0333164b70e194022d8bc2340e947d615717852adc"
S = "${WORKDIR}/trac_ik-release-release-kinetic-trac_ik_kinematics_plugin-1.5.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('trac-ik', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('trac-ik', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/trac-ik/trac-ik_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/trac-ik/trac-ik-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/trac-ik/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/trac-ik/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
