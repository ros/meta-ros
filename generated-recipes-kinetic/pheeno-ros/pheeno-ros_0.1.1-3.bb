# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The pheeno_ros package contains necessary files for run and control an individual Pheeno unit with ROS."
AUTHOR = "zmk5 <zkakish@gmail.com>"
ROS_AUTHOR = "Zahi Kakish"
HOMEPAGE = "https://acslaboratory.github.io"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "pheeno_ros"
ROS_BPN = "pheeno_ros"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    geometry-msgs \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    geometry-msgs \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    geometry-msgs \
    roscpp \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ACSLaboratory/pheeno_ros-release/archive/release/kinetic/pheeno_ros/0.1.1-3.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c3769b73269b93875573890db28e19b6"
SRC_URI[sha256sum] = "9d165abb22eaf98d7893fcaf513823645576ad076115be5b4a285d193febaecc"
S = "${WORKDIR}/pheeno_ros-release-release-kinetic-pheeno_ros-0.1.1-3"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pheeno-ros', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pheeno-ros', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros/pheeno-ros_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros/pheeno-ros-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
