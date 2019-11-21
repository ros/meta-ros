# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "OpenManipulator 3D model description for visualization and simulation"
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Darby Lim <thlim@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/open_manipulator_with_tb3_description"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "open_manipulator_with_tb3"
ROS_BPN = "open_manipulator_with_tb3_description"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    robot-state-publisher \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/open_manipulator_with_tb3-release/archive/release/kinetic/open_manipulator_with_tb3_description/1.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9e5fe5361704ab24acddfa0a5a9bffba"
SRC_URI[sha256sum] = "ce434fcff1e79522907cb768d7b10391d69829c2428d67977e212f86caa375c4"
S = "${WORKDIR}/open_manipulator_with_tb3-release-release-kinetic-open_manipulator_with_tb3_description-1.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('open-manipulator-with-tb3', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('open-manipulator-with-tb3', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-manipulator-with-tb3/open-manipulator-with-tb3_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-manipulator-with-tb3/open-manipulator-with-tb3-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-manipulator-with-tb3/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/open-manipulator-with-tb3/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
