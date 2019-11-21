# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The pepper_robot package"
AUTHOR = "Surya Ambrose <surya.ambrose@gmail.com>"
ROS_AUTHOR = "Karsten Knese"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "pepper_robot"
ROS_BPN = "pepper_robot"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    pepper-bringup \
    pepper-description \
    pepper-sensors-py \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pepper-bringup \
    pepper-description \
    pepper-sensors-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-naoqi/pepper_robot-release/archive/release/kinetic/pepper_robot/0.1.10-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a82ec0975ab957a65e21dd4be2d9bc2a"
SRC_URI[sha256sum] = "c04062a6eeff1398dd0932c7a5051716a1e16d4ea3610a7057f0231d46293a60"
S = "${WORKDIR}/pepper_robot-release-release-kinetic-pepper_robot-0.1.10-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pepper-robot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pepper-robot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pepper-robot/pepper-robot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pepper-robot/pepper-robot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pepper-robot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pepper-robot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
