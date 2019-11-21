# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "SMACH is a task-level architecture for rapidly creating complex robot     behavior. At its core, SMACH is a ROS-independent Python library to build     hierarchical state machines. SMACH is a new library that takes advantage of     very old concepts in order to quickly create robust robot behavior with     maintainable and modular code."
AUTHOR = "Isaac I. Y. Saito <gm130s@gmail.com>"
ROS_AUTHOR = "Jonathan Bohren"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "executive_smach"
ROS_BPN = "smach"

ROS_BUILD_DEPENDS = ""

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

SRC_URI = "https://github.com/ros-gbp/executive_smach-release/archive/release/kinetic/smach/2.0.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ab3900a2cb47bd92b6b380ac693aa642"
SRC_URI[sha256sum] = "98763352defe3ffd8acb6866467a435578bb2510ca56f67b98e4c66b3d1143fb"
S = "${WORKDIR}/executive_smach-release-release-kinetic-smach-2.0.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('executive-smach', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('executive-smach', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/executive-smach/executive-smach_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/executive-smach/executive-smach-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/executive-smach/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/executive-smach/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
