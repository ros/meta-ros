# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The dsr_example C++ package"
AUTHOR = "Doosan Robotics <ros.robotics@doosan.com>"
ROS_AUTHOR = "Kab Kyoum Kim <kabkyoum.kim@doosan.com>"
HOMEPAGE = "http://wiki.ros.org/doosan_robotics"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "doosan_robot"
ROS_BPN = "dsr_example_cpp"

ROS_BUILD_DEPENDS = " \
    dsr-msgs \
    roscpp \
    serial \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dsr-msgs \
    roscpp \
    serial \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dsr-msgs \
    roscpp \
    serial \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/doosan-robotics/doosan-robot-release/archive/release/kinetic/dsr_example_cpp/0.9.6-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "23924d4008b6bf66d58c521b673d96e8"
SRC_URI[sha256sum] = "88ddffbe84c7e70c399dca817fdd10d1360fdb2689e6a6ffaa4c3fcc22357430"
S = "${WORKDIR}/doosan-robot-release-release-kinetic-dsr_example_cpp-0.9.6-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('doosan-robot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('doosan-robot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/doosan-robot/doosan-robot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/doosan-robot/doosan-robot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/doosan-robot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/doosan-robot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
