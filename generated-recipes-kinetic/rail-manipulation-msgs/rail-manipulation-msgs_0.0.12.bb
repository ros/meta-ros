# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Common Manipulation Messages and Services Used in RAIL Manipulation Packages"
AUTHOR = "David Kent <dekent@gatech.edu>"
ROS_AUTHOR = "David Kent <dekent@gatech.edu>"
HOMEPAGE = "http://ros.org/wiki/rail_manipulation_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rail_manipulation_msgs"
ROS_BPN = "rail_manipulation_msgs"

ROS_BUILD_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    message-generation \
    sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/gt-rail-release/rail_manipulation_msgs-release/archive/release/kinetic/rail_manipulation_msgs/0.0.12-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cb9c8948305d58834957346d13714f63"
SRC_URI[sha256sum] = "4a20e3f9b80d5c1000960774d78558c54a35232fe2f611cefa0d0246bb4b9ba7"
S = "${WORKDIR}/rail_manipulation_msgs-release-release-kinetic-rail_manipulation_msgs-0.0.12-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rail-manipulation-msgs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rail-manipulation-msgs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rail-manipulation-msgs/rail-manipulation-msgs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rail-manipulation-msgs/rail-manipulation-msgs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rail-manipulation-msgs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rail-manipulation-msgs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
