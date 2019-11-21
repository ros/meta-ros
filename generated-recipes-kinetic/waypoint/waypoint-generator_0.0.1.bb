# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Generates waypoint yaml file"
AUTHOR = "Jihoon Lee <jihoonlee.in@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/waypoint_generator"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "waypoint"
ROS_BPN = "waypoint_generator"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    rospy \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/jihoonl/waypoint-release/archive/release/kinetic/waypoint_generator/0.0.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aa3d5f084ade2b08de704970b419fbee"
SRC_URI[sha256sum] = "a6910dbbe3a5b557a592dcae66e6c6b239b63e49d69117aff907c8429899d2a4"
S = "${WORKDIR}/waypoint-release-release-kinetic-waypoint_generator-0.0.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('waypoint', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('waypoint', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/waypoint/waypoint_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/waypoint/waypoint-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/waypoint/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/waypoint/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
