# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS Peerjs package"
AUTHOR = "Easymov Robotics <dev@easymov.fr>"
ROS_AUTHOR = "Noel Martignoni <noel.martignoni@easymov.fr>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "ros_peerjs"
ROS_BPN = "ros_peerjs"

ROS_BUILD_DEPENDS = " \
    git \
    nodejs-legacy \
    npmaudit-sca-native \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gtk2 \
    libasound2-dev \
    libgconf2 \
    libnss3-dev \
    libxss1 \
    libxtst-dev \
    nodejs \
    xvfb \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gtk2 \
    libasound2-dev \
    libgconf2 \
    libnss3-dev \
    libxss1 \
    libxtst-dev \
    nodejs \
    xvfb \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/easymov/ros_peerjs-release/archive/release/kinetic/ros_peerjs/0.1.8-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7c8a6361ea1d470e6b308c358a217c71"
SRC_URI[sha256sum] = "a6c846552618e2a8d7a7f2ceb524d29ab9fbf1749bac9fead0b37b8cf3287f00"
S = "${WORKDIR}/ros_peerjs-release-release-kinetic-ros_peerjs-0.1.8-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-peerjs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-peerjs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-peerjs/ros-peerjs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-peerjs/ros-peerjs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-peerjs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-peerjs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
