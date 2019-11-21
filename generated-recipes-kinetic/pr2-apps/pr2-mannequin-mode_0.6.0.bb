# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The pr2_mannequin_mode package"
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Vijay Pradeep"
HOMEPAGE = "http://wiki.ros.org/pr2_mannequin_mode"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "pr2_apps"
ROS_BPN = "pr2_mannequin_mode"

ROS_BUILD_DEPENDS = " \
    pr2-controller-manager \
    pr2-controllers-msgs \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    pr2-controller-manager \
    pr2-controllers-msgs \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pr2-controller-manager \
    pr2-controllers-msgs \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/pr2-gbp/pr2_apps-release/archive/release/kinetic/pr2_mannequin_mode/0.6.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cf447f853f09d164c9bff6e304ca3a6a"
SRC_URI[sha256sum] = "7ee4d843071f900cf92e96c1e4008568115276bb1f7cbcdd5ef39c32f19529cf"
S = "${WORKDIR}/pr2_apps-release-release-kinetic-pr2_mannequin_mode-0.6.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pr2-apps', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pr2-apps', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-apps/pr2-apps_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-apps/pr2-apps-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-apps/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-apps/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
