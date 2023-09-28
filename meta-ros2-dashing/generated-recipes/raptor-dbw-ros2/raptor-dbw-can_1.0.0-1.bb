# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "CAN translator for drive-by-wire interface to the New Eagle Raptor DBW kit"
AUTHOR = "New Eagle <newagleraptorgithub@neweagle.net>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "raptor_dbw_ros2"
ROS_BPN = "raptor_dbw_can"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    geometry-msgs \
    raptor-can-dbc-parser \
    raptor-dbw-msgs \
    raptor-pdu \
    raptor-pdu-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    geometry-msgs \
    raptor-can-dbc-parser \
    raptor-dbw-msgs \
    raptor-pdu \
    raptor-pdu-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    geometry-msgs \
    raptor-can-dbc-parser \
    raptor-dbw-msgs \
    raptor-pdu \
    raptor-pdu-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/NewEagleRaptor/raptor-dbw-ros2-release/archive/release/dashing/raptor_dbw_can/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/raptor_dbw_can"
SRC_URI = "git://github.com/NewEagleRaptor/raptor-dbw-ros2-release;${ROS_BRANCH};protocol=https"
SRCREV = "d87d78946495ce4a847ddc2e0cb1df0414c506bd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
