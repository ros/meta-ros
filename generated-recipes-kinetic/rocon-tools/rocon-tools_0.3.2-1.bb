# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Utilities and tools developed for rocon, but usable beyond the boundaries     of rocon."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier"
HOMEPAGE = "http://www.ros.org/wiki/rocon_tools"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rocon_tools"
ROS_BPN = "rocon_tools"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rocon-console \
    rocon-ebnf \
    rocon-interactions \
    rocon-launch \
    rocon-master-info \
    rocon-python-comms \
    rocon-python-redis \
    rocon-python-utils \
    rocon-python-wifi \
    rocon-semantic-version \
    rocon-uri \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rocon-console \
    rocon-ebnf \
    rocon-interactions \
    rocon-launch \
    rocon-master-info \
    rocon-python-comms \
    rocon-python-redis \
    rocon-python-utils \
    rocon-python-wifi \
    rocon-semantic-version \
    rocon-uri \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/rocon_tools-release/archive/release/kinetic/rocon_tools/0.3.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8a5d40497c57fceecdc0c3f95be15e78"
SRC_URI[sha256sum] = "1893069c0024177840270cd2a859df90583b28a58f8e6ce7ef39599121924d48"
S = "${WORKDIR}/rocon_tools-release-release-kinetic-rocon_tools-0.3.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rocon-tools', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rocon-tools', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/rocon-tools_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/rocon-tools-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
