# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS packages for the ROBOTIS OP3 (meta package).     This meta package provides launch files and plug-in for Gazebo and RViz."
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "SCH <sch@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/robotis_op3_common"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "robotis_op3_common"
ROS_BPN = "robotis_op3_common"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    op3-description \
    op3-gazebo \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/ROBOTIS-OP3-Common-release/archive/release/kinetic/robotis_op3_common/0.1.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9cb17a8f4c968317528c53ab4c1a93b1"
SRC_URI[sha256sum] = "b8512812619cf37760e26a0dac1d80c288d875a2aa656f11898a7b23b1229bf3"
S = "${WORKDIR}/ROBOTIS-OP3-Common-release-release-kinetic-robotis_op3_common-0.1.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robotis-op3-common', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robotis-op3-common', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-common/robotis-op3-common_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-common/robotis-op3-common-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-common/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-common/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
