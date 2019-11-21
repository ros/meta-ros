# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Common service definitions."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Morgan Quigley"
HOMEPAGE = "http://ros.org/wiki/std_srvs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_comm_msgs"
ROS_BPN = "std_srvs"

ROS_BUILD_DEPENDS = " \
    message-generation \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/ros_comm_msgs-release/archive/release/kinetic/std_srvs/1.11.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "803e1a755412bf261aac3e57aec429aa"
SRC_URI[sha256sum] = "223955e2e05e6d86f5c1f57d00c55e4a2f6ac3f9060f727ee512b2602c253184"
S = "${WORKDIR}/ros_comm_msgs-release-release-kinetic-std_srvs-1.11.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-comm-msgs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-comm-msgs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm-msgs/ros-comm-msgs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm-msgs/ros-comm-msgs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm-msgs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm-msgs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
