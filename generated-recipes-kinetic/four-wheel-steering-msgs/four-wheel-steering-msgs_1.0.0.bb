# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS messages for robots using FourWheelSteering."
AUTHOR = "Vincent Rousseau <vincent.rousseau@irstea.fr>"
ROS_AUTHOR = "Vincent Rousseau <vincent.rousseau@irstea.fr>"
HOMEPAGE = "http://ros.org/wiki/four_wheel_steering_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "four_wheel_steering_msgs"
ROS_BPN = "four_wheel_steering_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
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

SRC_URI = "https://github.com/ros-drivers-gbp/four_wheel_steering_msgs-release/archive/release/kinetic/four_wheel_steering_msgs/1.0.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3397d4d945ca403a48bfc872af278c10"
SRC_URI[sha256sum] = "263c1ae8938996b3c43a53b1c6f1d33e3576d32f2bd2258c703341bce6b3eb4e"
S = "${WORKDIR}/four_wheel_steering_msgs-release-release-kinetic-four_wheel_steering_msgs-1.0.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('four-wheel-steering-msgs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('four-wheel-steering-msgs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/four-wheel-steering-msgs/four-wheel-steering-msgs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/four-wheel-steering-msgs/four-wheel-steering-msgs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/four-wheel-steering-msgs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/four-wheel-steering-msgs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
