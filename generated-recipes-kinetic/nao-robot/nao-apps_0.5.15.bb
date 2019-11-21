# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Applications for NAO using the NAOqi API"
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "nao_robot"
ROS_BPN = "nao_apps"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    diagnostic-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    humanoid-nav-msgs \
    naoqi-bridge \
    naoqi-bridge-msgs \
    naoqi-driver \
    naoqi-driver-py \
    naoqi-pose \
    rospy \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    diagnostic-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    humanoid-nav-msgs \
    naoqi-bridge \
    naoqi-bridge-msgs \
    naoqi-driver \
    naoqi-driver-py \
    naoqi-pose \
    rospy \
    std-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    trajectory-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-naoqi/nao_robot-release/archive/release/kinetic/nao_apps/0.5.15-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c25a1d83975bba9416217dc0a623d2c3"
SRC_URI[sha256sum] = "6f2578725ddfbf17c8124bc5e7f85099e934806e63cef3a416eedec6667764f2"
S = "${WORKDIR}/nao_robot-release-release-kinetic-nao_apps-0.5.15-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('nao-robot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('nao-robot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-robot/nao-robot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-robot/nao-robot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-robot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-robot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
