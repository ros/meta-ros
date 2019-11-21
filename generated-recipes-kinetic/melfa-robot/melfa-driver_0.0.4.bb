# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The melfa_driver package"
AUTHOR = "Tokyo Opensource Robotics Kyokai (TORK) Developer Team <dev@opensource-robotics.tokyo.jp>"
ROS_AUTHOR = "Ryosuke Tajima <ryosuke.tajima@opensource-robotics.tokyo.jp>"
HOMEPAGE = "http://wiki.ros.org/melfa_driver"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "melfa_robot"
ROS_BPN = "melfa_driver"

ROS_BUILD_DEPENDS = " \
    controller-manager \
    diagnostic-updater \
    hardware-interface \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-manager \
    diagnostic-updater \
    hardware-interface \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    diagnostic-updater \
    hardware-interface \
    joint-state-controller \
    joint-trajectory-controller \
    position-controllers \
    robot-state-publisher \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    roslint \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/melfa_robot-release/archive/release/kinetic/melfa_driver/0.0.4-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "688ab090fddf89a3123da753bf6bde73"
SRC_URI[sha256sum] = "916b4e29ffbe5a67a09bc81e1c6ae19179b54d93f0b97a7bd499c38086a2cea3"
S = "${WORKDIR}/melfa_robot-release-release-kinetic-melfa_driver-0.0.4-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('melfa-robot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('melfa-robot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/melfa-robot/melfa-robot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/melfa-robot/melfa-robot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/melfa-robot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/melfa-robot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
