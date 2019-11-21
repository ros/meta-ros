# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Visualization and rviz helpers for Heron."
AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "heron_desktop"
ROS_BPN = "heron_viz"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    heron-description \
    joint-state-publisher \
    rviz \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    heron-description \
    joint-state-publisher \
    rviz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/heron_desktop-release/archive/release/kinetic/heron_viz/0.0.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "463176e947d60327275181b23b8a6042"
SRC_URI[sha256sum] = "b7620ebe892cc9b2442770c55bdb90c5953236cfdad5fbaf8165c7a8b3c01f62"
S = "${WORKDIR}/heron_desktop-release-release-kinetic-heron_viz-0.0.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('heron-desktop', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('heron-desktop', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/heron-desktop/heron-desktop_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/heron-desktop/heron-desktop-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/heron-desktop/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/heron-desktop/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
