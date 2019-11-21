# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Visualization launchers and helpers for Warthog."
AUTHOR = "Tony Baltovski <tbaltovski@clearpathrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "warthog_desktop"
ROS_BPN = "warthog_viz"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joint-state-publisher \
    rviz \
    warthog-description \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    rviz \
    warthog-description \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/warthog_desktop-release/archive/release/kinetic/warthog_viz/0.0.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6c64fa608c84b237df80213aab3acb5c"
SRC_URI[sha256sum] = "f622e14b667b7d14a1db9692e8faee8bd5d7987793d383a2a5e30ada2210fdab"
S = "${WORKDIR}/warthog_desktop-release-release-kinetic-warthog_viz-0.0.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('warthog-desktop', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('warthog-desktop', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/warthog-desktop/warthog-desktop_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/warthog-desktop/warthog-desktop-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/warthog-desktop/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/warthog-desktop/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
