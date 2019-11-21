# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ProAut parameter package"
AUTHOR = "Peter Weissig <wepet@hrz.tu-chemnitz.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "parameter_pa"
ROS_BPN = "parameter_pa"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    libeigen \
    message-generation \
    roscpp \
    roslib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cmake-modules \
    libeigen \
    message-runtime \
    roscpp \
    roslib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cmake-modules \
    libeigen \
    message-runtime \
    roscpp \
    roslib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tuc-proaut/ros_parameter-release/archive/release/kinetic/parameter_pa/1.2.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ca47c46ff5d071db294be00e828896d4"
SRC_URI[sha256sum] = "162edff86d570c52e71d78b56a3c076bc91556bd4fba5613f4714f0a65ecaf84"
S = "${WORKDIR}/ros_parameter-release-release-kinetic-parameter_pa-1.2.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('parameter-pa', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('parameter-pa', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/parameter-pa/parameter-pa_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/parameter-pa/parameter-pa-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/parameter-pa/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/parameter-pa/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
