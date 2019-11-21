# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "If your robot loses connection to the base station it will stop motors or navigate home."
AUTHOR = "Daniel Snider <danielsnider12@gmail.com>"
ROS_AUTHOR = "Daniel Snider <danielsnider12@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/lost_comms_recovery"
SECTION = "devel"
LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=c4d59f93d1cbaf4d216df2c1b2ed0dca"

ROS_CN = "lost_comms_recovery"
ROS_BPN = "lost_comms_recovery"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    geometry-msgs \
    move-base-msgs \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    geometry-msgs \
    move-base-msgs \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    geometry-msgs \
    move-base-msgs \
    rospy \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/danielsnider/lost_comms_recovery-release/archive/release/kinetic/lost_comms_recovery/0.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c212b16f4e2925f030f7d022489a5024"
SRC_URI[sha256sum] = "faff7f1c50aa083d57a091bb6c229b2522293fda9df8c9a2c78dce4705755623"
S = "${WORKDIR}/lost_comms_recovery-release-release-kinetic-lost_comms_recovery-0.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('lost-comms-recovery', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('lost-comms-recovery', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lost-comms-recovery/lost-comms-recovery_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lost-comms-recovery/lost-comms-recovery-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lost-comms-recovery/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/lost-comms-recovery/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
