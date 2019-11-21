# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "An action interface to MoveIt!'s pick-and-place for Care-O-bot"
AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
ROS_AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
HOMEPAGE = "http://ros.org/wiki/cob_manipulation/"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_manipulation"
ROS_BPN = "cob_pick_place_action"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    cob-grasp-generation \
    cob-moveit-interface \
    geometric-shapes \
    geometry-msgs \
    message-generation \
    moveit-msgs \
    moveit-ros-move-group \
    moveit-ros-planning-interface \
    roscpp \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    cob-grasp-generation \
    cob-moveit-interface \
    geometric-shapes \
    geometry-msgs \
    moveit-msgs \
    moveit-ros-move-group \
    moveit-ros-planning-interface \
    roscpp \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    cob-grasp-generation \
    cob-moveit-interface \
    geometric-shapes \
    geometry-msgs \
    message-runtime \
    moveit-msgs \
    moveit-ros-move-group \
    moveit-ros-planning-interface \
    roscpp \
    rospy \
    std-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/cob_manipulation-release/archive/release/kinetic/cob_pick_place_action/0.7.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d18e6c6e973e4d8719b5d74e713f58e1"
SRC_URI[sha256sum] = "c946bdbb9b3fea26d7f47be23eaae5ae24b5f9204605787ebae9f76f51d77058"
S = "${WORKDIR}/cob_manipulation-release-release-kinetic-cob_pick_place_action-0.7.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cob-manipulation', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cob-manipulation', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-manipulation/cob-manipulation_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-manipulation/cob-manipulation-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-manipulation/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-manipulation/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
