# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS driver for miscellaneous sensors on NAO.     Python bindings for camera, sonar and octomap     C++: bindings for camera only (requires NAOqi to build)"
AUTHOR = "Séverin Lemaignan <severin.lemaignan@epfl.ch>"
ROS_AUTHOR = "Séverin Lemaignan"
HOMEPAGE = "http://ros.org/wiki/naoqi_sensors"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=25;endline=25;md5=775f835d6d0cb09aa9b18a80dac33ee4"

ROS_CN = "naoqi_bridge"
ROS_BPN = "naoqi_sensors_py"

ROS_BUILD_DEPENDS = " \
    boost \
    camera-info-manager \
    dynamic-reconfigure \
    naoqi-driver-py \
    octomap \
    octomap-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    camera-info-manager \
    camera-info-manager-py \
    dynamic-reconfigure \
    naoqi-driver-py \
    octomap \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    camera-info-manager \
    camera-info-manager-py \
    dynamic-reconfigure \
    naoqi-driver-py \
    octomap \
    rospy \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-naoqi/naoqi_bridge-release/archive/release/kinetic/naoqi_sensors_py/0.5.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "adc72e3383685fd4e5ce75c134b32b98"
SRC_URI[sha256sum] = "7aaa45e944e3dc066d942c9b66e961a3282691e0c83f53c9d5a4709edfaca1a0"
S = "${WORKDIR}/naoqi_bridge-release-release-kinetic-naoqi_sensors_py-0.5.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('naoqi-bridge', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('naoqi-bridge', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/naoqi-bridge_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/naoqi-bridge-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
