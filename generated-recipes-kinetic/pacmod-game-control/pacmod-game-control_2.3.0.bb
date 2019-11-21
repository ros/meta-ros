# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS Package for controlling the AStuff PACMod with a Joystick"
AUTHOR = "AutonomouStuff Software Development Team <software@autonomoustuff.com>"
ROS_AUTHOR = "Joe Driscoll <jdriscoll@autonomoustuff.com>"
HOMEPAGE = "http://wiki.ros.org/pacmod_game_control"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "pacmod_game_control"
ROS_BPN = "pacmod_game_control"

ROS_BUILD_DEPENDS = " \
    joy \
    pacmod-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joy \
    pacmod-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joy \
    pacmod-msgs \
    roscpp \
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

SRC_URI = "https://github.com/astuff/pacmod_game_control-release/archive/release/kinetic/pacmod_game_control/2.3.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cd7c6894227f1e56627e4fc2b8c394e8"
SRC_URI[sha256sum] = "4bf23d9a203f9d2a26a4222a8f2a7e3f5c21b269569c346264af867219e6a375"
S = "${WORKDIR}/pacmod_game_control-release-release-kinetic-pacmod_game_control-2.3.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pacmod-game-control', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pacmod-game-control', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pacmod-game-control/pacmod-game-control_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pacmod-game-control/pacmod-game-control-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pacmod-game-control/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pacmod-game-control/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
