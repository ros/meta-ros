# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Ecto bindings for common opencv functionality."
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
ROS_AUTHOR = "Ethan Rublee"
HOMEPAGE = "http://plasmodic.github.io/ecto_opencv"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ecto_opencv"
ROS_BPN = "ecto_opencv"

ROS_BUILD_DEPENDS = " \
    boost \
    ecto \
    opencv-candidate \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    ecto \
    opencv-candidate \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    ecto \
    opencv-candidate \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/ecto_opencv-release/archive/release/kinetic/ecto_opencv/0.7.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d701221e9915fdfa03b0de47ea97d88a"
SRC_URI[sha256sum] = "006226c8e58af9547e44edf9bac67ba8d1fb3d828accabc9cad227a1e039f810"
S = "${WORKDIR}/ecto_opencv-release-release-kinetic-ecto_opencv-0.7.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ecto-opencv', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ecto-opencv', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-opencv/ecto-opencv_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-opencv/ecto-opencv-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-opencv/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-opencv/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
