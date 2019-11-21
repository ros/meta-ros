# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package contains a set of conversion functions to convert common tf datatypes (point, vector, pose, etc) into semantically identical datatypes used by other libraries. The conversion functions make it easier for users of the transform library (tf) to work with the datatype of their choice. Currently this package has support for the Kinematics and Dynamics Library (KDL) and the Eigen matrix library. This package is stable, and will get integrated into tf in the next major release cycle (see roadmap)."
AUTHOR = "Tully Foote <tfoote@osrfoundation.org>"
ROS_AUTHOR = "Tully Foote"
HOMEPAGE = "http://www.ros.org/wiki/tf_conversions"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry"
ROS_BPN = "tf_conversions"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    geometry-msgs \
    kdl-conversions \
    libeigen \
    orocos-kdl \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    kdl-conversions \
    libeigen \
    orocos-kdl \
    python-orocos-kdl \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    kdl-conversions \
    libeigen \
    orocos-kdl \
    python-orocos-kdl \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/geometry-release/archive/release/kinetic/tf_conversions/1.11.9-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e089a8c839a78d21be692251cf3c0b6a"
SRC_URI[sha256sum] = "8fee2dbf9f0fe32faf00d36aaaebb9a5d311b2ff9838c5ef8a7b409b4d655e86"
S = "${WORKDIR}/geometry-release-release-kinetic-tf_conversions-1.11.9-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('geometry', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('geometry', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/geometry_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/geometry-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
