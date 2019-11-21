# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The package that manages device information of ROBOTIS robots.     This package is used when reading device information with the robot information file     from the robotis_controller package."
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Zerom <zerom@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/robotis_device"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "robotis_framework"
ROS_BPN = "robotis_device"

ROS_BUILD_DEPENDS = " \
    dynamixel-sdk \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamixel-sdk \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamixel-sdk \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/ROBOTIS-Framework-release/archive/release/kinetic/robotis_device/0.2.9-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d6ee65248d426bedb5d60c7d6a63edfa"
SRC_URI[sha256sum] = "aa72b1f902c9045bfd34d8baf9ff416f8ffe4af276f82294532523b933739780"
S = "${WORKDIR}/ROBOTIS-Framework-release-release-kinetic-robotis_device-0.2.9-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robotis-framework', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robotis-framework', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-framework/robotis-framework_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-framework/robotis-framework-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-framework/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-framework/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
