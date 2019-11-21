# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Message definitions for the Delphi SRR"
AUTHOR = "AutonomouStuff Software Development Team <support@autonomoustuff.com>"
ROS_AUTHOR = "Josh Whitley <jwhitley@autonomoustuff.com>"
HOMEPAGE = "http://wiki.ros.org/delphi_srr_msgs"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "astuff_sensor_msgs"
ROS_BPN = "delphi_srr_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/astuff/astuff_sensor_msgs-release/archive/release/kinetic/delphi_srr_msgs/2.3.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9ed3b62af4167e276bc9c747b4dfa3a4"
SRC_URI[sha256sum] = "4a8aa34a1484075f13e2952ea936ebed5a2826b4865b2f698120464fb85eacea"
S = "${WORKDIR}/astuff_sensor_msgs-release-release-kinetic-delphi_srr_msgs-2.3.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('astuff-sensor-msgs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('astuff-sensor-msgs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/astuff-sensor-msgs/astuff-sensor-msgs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/astuff-sensor-msgs/astuff-sensor-msgs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/astuff-sensor-msgs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/astuff-sensor-msgs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
