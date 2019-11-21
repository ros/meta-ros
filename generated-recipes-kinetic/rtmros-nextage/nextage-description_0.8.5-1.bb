# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "As a part of rtmros_nextage package that is a ROS interface for <a href="http://nextage.kawada.jp/en/">Nextage</a> dual-armed robot from Kawada Robotics Inc, this package provides its 3D model that can be used in simulation and <a href="http://ros.org/wiki/moveit">MoveIt!</a>-based motion planning tasks."
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada"
HOMEPAGE = "http://ros.org/wiki/nextage_description"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtmros_nextage"
ROS_BPN = "nextage_description"

ROS_BUILD_DEPENDS = " \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/rtmros_nextage-release/archive/release/kinetic/nextage_description/0.8.5-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "39bc5b143688f8daed2a9f37b777ee3a"
SRC_URI[sha256sum] = "d2f769d2e613f2da55c6055688f0dee234d2e0800414065f04ce4d01cfb970f8"
S = "${WORKDIR}/rtmros_nextage-release-release-kinetic-nextage_description-0.8.5-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rtmros-nextage', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rtmros-nextage', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/rtmros-nextage_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/rtmros-nextage-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
