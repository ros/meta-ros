# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The configuration node loads a given launch configuration and offers services to       list or start the contained nodes. It provides additional description       extracted from launch file. This is used by node_manager_fkie."
AUTHOR = "Alexander Tiderko <alexander.tiderko@gmail.com>"
ROS_AUTHOR = "Alexander Tiderko"
HOMEPAGE = "http://ros.org/wiki/default_cfg_fkie"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "multimaster_fkie"
ROS_BPN = "default_cfg_fkie"

ROS_BUILD_DEPENDS = " \
    multimaster-msgs-fkie \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    multimaster-msgs-fkie \
    roslaunch \
    roslib \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    multimaster-msgs-fkie \
    roslaunch \
    roslib \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/fkie-release/multimaster_fkie-release/archive/release/kinetic/default_cfg_fkie/0.8.12-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6fa7a897b2c38bae86dfb9e19efc2b1d"
SRC_URI[sha256sum] = "6e7a0b1c6641be81c4684905c9c1fa9fa8941465db4759cf444b4a06d923a072"
S = "${WORKDIR}/multimaster_fkie-release-release-kinetic-default_cfg_fkie-0.8.12-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('multimaster-fkie', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('multimaster-fkie', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multimaster-fkie/multimaster-fkie_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multimaster-fkie/multimaster-fkie-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multimaster-fkie/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multimaster-fkie/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
