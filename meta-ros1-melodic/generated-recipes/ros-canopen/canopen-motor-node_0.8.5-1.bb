# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "canopen_chain_node specialization for handling of canopen_402 motor devices. It facilitates interface abstraction with ros_control."
AUTHOR = "Mathias Lüdtke <mathias.luedtke@ipa.fraunhofer.de>"
ROS_AUTHOR = "Mathias Lüdtke <mathias.luedtke@ipa.fraunhofer.de>"
HOMEPAGE = "http://wiki.ros.org/canopen_motor_node"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "LGPLv3"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=b691248d2f70cdaeeaf13696ada5d47c"

ROS_CN = "ros_canopen"
ROS_BPN = "canopen_motor_node"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-muparser} \
    canopen-402 \
    canopen-chain-node \
    canopen-master \
    controller-manager \
    controller-manager-msgs \
    filters \
    hardware-interface \
    joint-limits-interface \
    roscpp \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-muparser} \
    canopen-402 \
    canopen-chain-node \
    canopen-master \
    controller-manager \
    filters \
    hardware-interface \
    joint-limits-interface \
    roscpp \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-muparser} \
    canopen-402 \
    canopen-chain-node \
    canopen-master \
    controller-manager \
    controller-manager-msgs \
    filters \
    hardware-interface \
    joint-limits-interface \
    roscpp \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/ros_canopen-release/archive/release/melodic/canopen_motor_node/0.8.5-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/canopen_motor_node"
SRC_URI = "git://github.com/ros-industrial-release/ros_canopen-release;${ROS_BRANCH};protocol=https"
SRCREV = "cde3993d78a33a3b69df1d72d4274f9bcedf1020"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
