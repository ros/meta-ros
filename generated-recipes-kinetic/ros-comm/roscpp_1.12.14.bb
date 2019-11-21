# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "roscpp is a C++ implementation of ROS. It provides     a <a href="http://www.ros.org/wiki/Client%20Libraries">client     library</a> that enables C++ programmers to quickly interface with     ROS <a href="http://ros.org/wiki/Topics">Topics</a>,     <a href="http://ros.org/wiki/Services">Services</a>,     and <a href="http://ros.org/wiki/Parameter Server">Parameters</a>.      roscpp is the most widely used ROS client library and is designed to     be the high-performance library for ROS."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Morgan Quigley"
HOMEPAGE = "http://ros.org/wiki/roscpp"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_comm"
ROS_BPN = "roscpp"

ROS_BUILD_DEPENDS = " \
    cpp-common \
    message-generation \
    pkgconfig \
    rosconsole \
    roscpp-serialization \
    roscpp-traits \
    rosgraph-msgs \
    roslang \
    rostime \
    std-msgs \
    xmlrpcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cpp-common \
    message-runtime \
    rosconsole \
    roscpp-serialization \
    roscpp-traits \
    rosgraph-msgs \
    rostime \
    std-msgs \
    xmlrpcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cpp-common \
    message-runtime \
    rosconsole \
    roscpp-serialization \
    roscpp-traits \
    rosgraph-msgs \
    rostime \
    std-msgs \
    xmlrpcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/kinetic/roscpp/1.12.14-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0975841937cd62f838f1c81d9e8d7ef0"
SRC_URI[sha256sum] = "4520279b2c32794d79ca4217ab61bc92cb6229d71a04312859b71d95f794e1a0"
S = "${WORKDIR}/ros_comm-release-release-kinetic-roscpp-1.12.14-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-comm', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-comm', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/ros-comm_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/ros-comm-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
