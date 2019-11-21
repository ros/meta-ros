# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package provides a set of simple math utilities to work         with angles. The utilities cover simple things like         normalizing an angle and conversion between degrees and         radians. But even if you're trying to calculate things like         the shortest angular distance between two joinst space         positions of your robot, but the joint motion is constrained         by joint limits, this package is what you need. The code in         this packge is stable and well tested. There are no plans for         major changes in the near future."
AUTHOR = "Ioan Sucan <isucan@willowgarage.com>"
ROS_AUTHOR = "John Hsu <hsu@osrfoundation.org>"
HOMEPAGE = "http://ros.org/wiki/angles"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "angles"
ROS_BPN = "angles"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/geometry_angles_utils-release/archive/release/kinetic/angles/1.9.11-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fc207bd694608e2a1281fad4d5f1e70b"
SRC_URI[sha256sum] = "5937dd2efcb6ed58eb69a1b57c4d76c76dffad86d787f9c9374fd27faed597de"
S = "${WORKDIR}/geometry_angles_utils-release-release-kinetic-angles-1.9.11-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('angles', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('angles', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/angles/angles_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/angles/angles-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/angles/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/angles/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
