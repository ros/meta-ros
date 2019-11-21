# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The ros_wild package"
AUTHOR = "Yuma Mihira <yuma-m@users.noreply.github.com>"
ROS_AUTHOR = "Yuma Mihira <yuma-m@users.noreply.github.com>"
HOMEPAGE = "https://github.com/yuma-m/ros_wild"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_wild"
ROS_BPN = "ros_wild"

ROS_BUILD_DEPENDS = " \
    rospy \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yuma-m/ros_wild-release/archive/release/kinetic/ros_wild/0.5.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f8447c896201c469078878af36bbbdfc"
SRC_URI[sha256sum] = "ea43f367a00c522865e27057ba95a348b032185da70b24d2da57e2c8b24d2d48"
S = "${WORKDIR}/ros_wild-release-release-kinetic-ros_wild-0.5.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-wild', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-wild', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-wild/ros-wild_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-wild/ros-wild-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-wild/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-wild/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
