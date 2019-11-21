# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Clearpath Husky Simulator bringup"
AUTHOR = "Paul Bovbel <paul@bovbel.com>"
ROS_AUTHOR = "Ryan Gariepy <rgariepy@clearpathrobotics.com>"
HOMEPAGE = "http://ros.org/wiki/husky_gazebo"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "husky"
ROS_BPN = "husky_gazebo"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-manager \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    hector-gazebo-plugins \
    husky-control \
    husky-description \
    multimaster-launch \
    pointcloud-to-laserscan \
    rostopic \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    hector-gazebo-plugins \
    husky-control \
    husky-description \
    multimaster-launch \
    pointcloud-to-laserscan \
    rostopic \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/husky-release/archive/release/kinetic/husky_gazebo/0.3.4-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8c6cecf0d205bd1f2d582ed721e5364c"
SRC_URI[sha256sum] = "6b0c9887f8d43a2ce66e86fcd4aa198c0840386e55e37ffe3acadb55e39f040f"
S = "${WORKDIR}/husky-release-release-kinetic-husky_gazebo-0.3.4-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('husky', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('husky', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/husky_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/husky-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
