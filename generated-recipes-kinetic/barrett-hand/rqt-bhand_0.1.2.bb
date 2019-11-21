# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The rqt_bhand package is intended to test the Barrett Hand in graphical mode"
AUTHOR = "Román Navarro <rnavarro@robotnik.es>"
ROS_AUTHOR = "Román Navarro <rnavarro@robotnik.es>"
HOMEPAGE = "http://ros.org/wiki/rqt_bhand"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "barrett_hand"
ROS_BPN = "rqt_bhand"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    bhand-controller \
    python-rospkg \
    rostopic \
    rqt-gui \
    rqt-gui-py \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    bhand-controller \
    python-rospkg \
    rostopic \
    rqt-gui \
    rqt-gui-py \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/RobotnikAutomation/barrett_hand-release/archive/release/kinetic/rqt_bhand/0.1.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c2bb0eae18facd05e1a4f5c8fdf7c183"
SRC_URI[sha256sum] = "e324a9ecdcabb3c34e3658cfa19fa62afe1789e04d68a57af2b936ab6032caf0"
S = "${WORKDIR}/barrett_hand-release-release-kinetic-rqt_bhand-0.1.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('barrett-hand', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('barrett-hand', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/barrett-hand/barrett-hand_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/barrett-hand/barrett-hand-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/barrett-hand/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/barrett-hand/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
