# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "RVIZ plugin for IMU visualization"
AUTHOR = "Martin Günther <martin.guenther1980@gmail.com>"
ROS_AUTHOR = "Ivan Dryanovski"
HOMEPAGE = "http://ros.org/wiki/rviz_imu_plugin"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "imu_tools"
ROS_BPN = "rviz_imu_plugin"

ROS_BUILD_DEPENDS = " \
    qtbase \
    roscpp \
    rviz \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    qtbase \
    roscpp \
    rviz \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    qtbase \
    roscpp \
    rviz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/uos-gbp/imu_tools-release/archive/release/kinetic/rviz_imu_plugin/1.1.7-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "09c52d02a14ba391090e30e35b747848"
SRC_URI[sha256sum] = "451718edd552558e2ca746a9083c8b393a823ae5124fa61a7cd88fdb5f92ff5f"
S = "${WORKDIR}/imu_tools-release-release-kinetic-rviz_imu_plugin-1.1.7-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('imu-tools', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('imu-tools', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imu-tools/imu-tools_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imu-tools/imu-tools-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imu-tools/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/imu-tools/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
