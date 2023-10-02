# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "ROS node for rpi_ws281x LED strip driver"
AUTHOR = "Oleg Kalachev <okalachev@gmail.com>"
ROS_AUTHOR = "Alexey Rogachevskiy <sfalexrog@gmail.com>"
HOMEPAGE = "https://github.com/CopterExpress/ros_led"
SECTION = "devel"
LICENSE = "MIT & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "ros_led"
ROS_BPN = "ws281x"

ROS_BUILD_DEPENDS = " \
    led-msgs \
    message-generation \
    ros-environment \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    led-msgs \
    message-generation \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    led-msgs \
    message-generation \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/CopterExpress/ros_led-release/archive/release/noetic/ws281x/0.0.11-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ws281x"
SRC_URI = "git://github.com/CopterExpress/ros_led-release;${ROS_BRANCH};protocol=https"
SRCREV = "f3d9877b5d5787ed81a9012a738e59bfa8421097"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
