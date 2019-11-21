# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The rtt_actionlib package"
AUTHOR = "Orocos Developers <orocos-dev@lists.mech.kuleuven.be>"
ROS_AUTHOR = "Jonathan Bohren"
HOMEPAGE = "http://ros.org/wiki/rtt_ros_integration"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtt_ros_integration"
ROS_BPN = "rtt_actionlib"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    roscpp \
    rtt-actionlib-msgs \
    rtt-ros \
    rtt-rosclock \
    rtt-roscomm \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    roscpp \
    rtt-actionlib-msgs \
    rtt-ros \
    rtt-rosclock \
    rtt-roscomm \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    roscpp \
    rtt-actionlib-msgs \
    rtt-ros \
    rtt-rosclock \
    rtt-roscomm \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/orocos-gbp/rtt_ros_integration-release/archive/release/kinetic/rtt_actionlib/2.9.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eaf7e839467fcbf930e8d85975af4cd3"
SRC_URI[sha256sum] = "ef743ad3d15721cd8ed9da6b32e29c3d951d414d6b8215f4abc45cc258783f72"
S = "${WORKDIR}/rtt_ros_integration-release-release-kinetic-rtt_actionlib-2.9.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rtt-ros-integration', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rtt-ros-integration', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtt-ros-integration/rtt-ros-integration_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtt-ros-integration/rtt-ros-integration-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtt-ros-integration/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtt-ros-integration/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
