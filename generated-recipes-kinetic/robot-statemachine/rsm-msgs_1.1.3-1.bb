# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The rsm_msgs package features messages and services for the Robot Statemachine"
AUTHOR = "Marco Steinbrink <marco.stb1993@gmail.com>"
ROS_AUTHOR = "Marco Steinbrink <marco.stb1993@gmail.com>"
HOMEPAGE = "https://github.com/MarcoStb1993/robot_statemachine"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=75730354549103aaba72b66caf53717b"

ROS_CN = "robot_statemachine"
ROS_BPN = "rsm_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/MarcoStb1993/robot_statemachine-release/archive/release/kinetic/rsm_msgs/1.1.3-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "052d11bd7d026584c5d7325ab4ad16c6"
SRC_URI[sha256sum] = "1aafb9e74806761febf38024c26dd9d1b63bb5eebd587164794b156bda81b194"
S = "${WORKDIR}/robot_statemachine-release-release-kinetic-rsm_msgs-1.1.3-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robot-statemachine', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robot-statemachine', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-statemachine/robot-statemachine_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-statemachine/robot-statemachine-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-statemachine/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-statemachine/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
