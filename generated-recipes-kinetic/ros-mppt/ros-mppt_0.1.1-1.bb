# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "MPPT message sender package"
AUTHOR = "aaronpb <aaronpb@todo.todo>"
ROS_AUTHOR = "Aaron PB"
HOMEPAGE = "http://wiki.ros.org/ros_mppt"
SECTION = "devel"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=336e1f8c9309b8a8a292d3e30d292ec7"

ROS_CN = "ros_mppt"
ROS_BPN = "ros_mppt"

ROS_BUILD_DEPENDS = " \
    message-generation \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/AaronPB/ros_mppt-release/archive/release/kinetic/ros_mppt/0.1.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "550663a5e23a3ee423a50dfde4be9953"
SRC_URI[sha256sum] = "ffe6fce6220f2f7d8574202edd6235916d79d60862b1b509ba9ac1bcd2176de9"
S = "${WORKDIR}/ros_mppt-release-release-kinetic-ros_mppt-0.1.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-mppt', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-mppt', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-mppt/ros-mppt_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-mppt/ros-mppt-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-mppt/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-mppt/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
