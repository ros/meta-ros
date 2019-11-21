# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package provides low level IO for Robotis Dynamixel servos.     Fully supports and was tested with AX-12, AX-18, RX-24, RX-28,     MX-28, RX-64, EX-106 models. Hardware specific constants are     defined for reading and writing information from/to Dynamixel     servos. This low level package won't be used directly by most     ROS users. The higher level dynamixel_controllers and specific     robot joint controllers make use of this package."
AUTHOR = "Antons Rebguns <arebgun@gmail.com>"
ROS_AUTHOR = "Antons Rebguns"
HOMEPAGE = "http://ros.org/wiki/dynamixel_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dynamixel_motor"
ROS_BPN = "dynamixel_driver"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-msgs \
    python-pyserial \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-msgs \
    python-pyserial \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/arebgun/dynamixel_motor-release/archive/release/kinetic/dynamixel_driver/0.4.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d512346bc5249b432c58208c47531f77"
SRC_URI[sha256sum] = "8066bc94c261d3df45d2d1f3447ecd988917a341dff0e151f92c8839b7ada5b7"
S = "${WORKDIR}/dynamixel_motor-release-release-kinetic-dynamixel_driver-0.4.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('dynamixel-motor', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('dynamixel-motor', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynamixel-motor/dynamixel-motor_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynamixel-motor/dynamixel-motor-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynamixel-motor/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynamixel-motor/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
