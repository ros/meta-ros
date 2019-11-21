# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS package for solving the Traveling Salesman Problem using the     Lin-Kernighan heuristic."
AUTHOR = "Francisco Suarez-Ruiz <fsuarez6@gmail.com>"
ROS_AUTHOR = "Francisco Suarez-Ruiz <fsuarez6@gmail.com>"
HOMEPAGE = "https://github.com/crigroup/lkh"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=f5654d47d02d927c4f7a04f0a51abaa1"

ROS_CN = "lkh"
ROS_BPN = "lkh_solver"

ROS_BUILD_DEPENDS = " \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    resource-retriever \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/crigroup/lkh-release/archive/release/kinetic/lkh_solver/0.1.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f3b849e707d9c802a17f46988f03629c"
SRC_URI[sha256sum] = "748f67711adbad6e79cecca25ce73c1156f8dfe5708828ecb000f2c81db4b4b7"
S = "${WORKDIR}/lkh-release-release-kinetic-lkh_solver-0.1.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('lkh', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('lkh', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lkh/lkh_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lkh/lkh-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lkh/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lkh/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
