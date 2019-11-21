# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Launch files and code for autonomous navigation of the Ridgeback"
AUTHOR = "Tony Baltovski <tbaltovski@clearpathrobotics.com>"
ROS_AUTHOR = "Shokoofeh Pourmehr <spourmehr@clearpathrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ridgeback"
ROS_BPN = "ridgeback_navigation"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    amcl \
    gmapping \
    map-server \
    move-base \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/ridgeback-release/archive/release/kinetic/ridgeback_navigation/0.2.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "882db41d5dbe4564b1d3f0e3e76047cf"
SRC_URI[sha256sum] = "2f8b096bdb890d3ebe3b4dc31039075bd226a65530ba3f0b83c49192ddf8dbf3"
S = "${WORKDIR}/ridgeback-release-release-kinetic-ridgeback_navigation-0.2.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ridgeback', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ridgeback', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback/ridgeback_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback/ridgeback-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
