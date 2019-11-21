# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Rust ROS message and service generators"
AUTHOR = "Adnan Ademovic <adnanademovic100@gmail.com>"
ROS_AUTHOR = "Adnan Ademovic"
HOMEPAGE = "https://github.com/adnanademovic/genrs/issues"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "genrs"
ROS_BPN = "genrs"

ROS_BUILD_DEPENDS = " \
    genmsg \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    genmsg \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    genmsg \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/adnanademovic/genrs-release/archive/release/kinetic/genrs/0.1.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5d2d8a217c9ccd62605ce027a1dc8c0b"
SRC_URI[sha256sum] = "67c1e8dc2db9aa0c8e2f71e3c337bfc86dbc88bc5d752a854267e0aa9df0192e"
S = "${WORKDIR}/genrs-release-release-kinetic-genrs-0.1.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('genrs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('genrs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genrs/genrs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genrs/genrs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genrs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/genrs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
