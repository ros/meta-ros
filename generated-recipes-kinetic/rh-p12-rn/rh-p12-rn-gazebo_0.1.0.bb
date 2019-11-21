# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package provides basic message pub and launch file to use RH-P12-RN on Gazebo"
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "SCH <sch@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/rh_p12_rn_gazebo"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "rh_p12_rn"
ROS_BPN = "rh_p12_rn_gazebo"

ROS_BUILD_DEPENDS = " \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    gazebo-ros \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/RH-P12-RN-release/archive/release/kinetic/rh_p12_rn_gazebo/0.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7733566bdd3bcd792bce4f06d4db97f0"
SRC_URI[sha256sum] = "fbd23391f70b14845c239ccea096c10cc4af66e990f46bb83d0139663640f4b1"
S = "${WORKDIR}/RH-P12-RN-release-release-kinetic-rh_p12_rn_gazebo-0.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rh-p12-rn', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rh-p12-rn', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rh-p12-rn/rh-p12-rn_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rh-p12-rn/rh-p12-rn-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rh-p12-rn/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rh-p12-rn/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
