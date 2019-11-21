# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "<p>      ROS-Industrial nodes for interfacing with ABB robot controllers.    </p>    <p>      This package is part of the ROS-Industrial program and contains nodes       for interfacing with ABB industrial robot controllers.    </p>"
AUTHOR = "Levi Armstrong (Southwest Research Institute) <levi.armstrong@swri.org>"
ROS_AUTHOR = "Edward Venator"
HOMEPAGE = "http://ros.org/wiki/abb_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "abb"
ROS_BPN = "abb_driver"

ROS_BUILD_DEPENDS = " \
    industrial-robot-client \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    industrial-robot-client \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    industrial-robot-client \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-industrial-release/abb-release/archive/release/kinetic/abb_driver/1.3.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "470561402ec851c47be4397f40a47d0a"
SRC_URI[sha256sum] = "6966a5d8d531ba7d06f72d87267f7de73af0d80781f5b25eebe892ccff89dd7f"
S = "${WORKDIR}/abb-release-release-kinetic-abb_driver-1.3.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('abb', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('abb', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/abb_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/abb-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
