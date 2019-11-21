# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A full, but simple robot drive system. Includes skid steering joystick teleoperation, control of a panning servo, a cmd_vel multiplexer, and Arduino firmware."
AUTHOR = "Daniel Snider <danielsnider12@gmail.com>"
ROS_AUTHOR = "Daniel Snider <danielsnider12@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/simple_drive"
SECTION = "devel"
LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=c4d59f93d1cbaf4d216df2c1b2ed0dca"

ROS_CN = "simple_drive"
ROS_BPN = "simple_drive"

ROS_BUILD_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    rospy \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    rospy \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    rospy \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/danielsnider/simple_drive-release/archive/release/kinetic/simple_drive/0.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6d753738091c68bcddaaaf3a3977ab37"
SRC_URI[sha256sum] = "abe34cd8127d63aaca2d44e70634d780cbfdb6cef5b6ae9d8076a01796eaeeca"
S = "${WORKDIR}/simple_drive-release-release-kinetic-simple_drive-0.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('simple-drive', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('simple-drive', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/simple-drive/simple-drive_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/simple-drive/simple-drive-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/simple-drive/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/simple-drive/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
