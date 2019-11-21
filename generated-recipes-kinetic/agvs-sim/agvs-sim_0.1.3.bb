# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "agvs Gazebo simulation packages"
AUTHOR = "Roberto Guzmán <rguzman@robotnik.es>"
ROS_AUTHOR = "Roberto Guzmán <rguzman@robotnik.es>"
HOMEPAGE = "http://ros.org/wiki/agvs_sim"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "agvs_sim"
ROS_BPN = "agvs_sim"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    agvs-control \
    agvs-gazebo \
    agvs-robot-control \
    agvs-sim-bringup \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    agvs-control \
    agvs-gazebo \
    agvs-robot-control \
    agvs-sim-bringup \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/RobotnikAutomation/agvs_sim-release/archive/release/kinetic/agvs_sim/0.1.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a9a8e4240375fefb9af08e0b8b739418"
SRC_URI[sha256sum] = "a189047dc877a521a3201c2b70ec3e5db2aa6d6bba1b8896a0b5aeb8922ff360"
S = "${WORKDIR}/agvs_sim-release-release-kinetic-agvs_sim-0.1.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('agvs-sim', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('agvs-sim', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-sim/agvs-sim_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-sim/agvs-sim-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-sim/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-sim/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
