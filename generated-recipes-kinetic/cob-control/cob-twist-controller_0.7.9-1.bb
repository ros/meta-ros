# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The main purpose of the cob_twist_controller is to convert target twists into joint velocities.    Therefore it makes use of several implemented inverse kinematics approaches at the first order differential level.    The inverse differential kinematics solver considers kinematic chain extensions, singularity robustness,    redundancy resolution and priority-based methods.   To avoid hardware destruction there is a limiter interface active as well.    Via parameter server users can dynamically configure the solving strategy."
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
ROS_AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_control"
ROS_BPN = "cob_twist_controller"

ROS_BUILD_DEPENDS = " \
    boost \
    cmake-modules \
    cob-control-msgs \
    cob-srvs \
    dynamic-reconfigure \
    eigen-conversions \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    libeigen \
    nav-msgs \
    orocos-kdl \
    pluginlib \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
    tf \
    tf-conversions \
    trajectory-msgs \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    cmake-modules \
    cob-control-msgs \
    cob-srvs \
    dynamic-reconfigure \
    eigen-conversions \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    libeigen \
    nav-msgs \
    orocos-kdl \
    pluginlib \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
    tf-conversions \
    trajectory-msgs \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    cmake-modules \
    cob-control-msgs \
    cob-frame-tracker \
    cob-srvs \
    dynamic-reconfigure \
    eigen-conversions \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    libeigen \
    nav-msgs \
    orocos-kdl \
    pluginlib \
    robot-state-publisher \
    roscpp \
    rospy \
    rviz \
    sensor-msgs \
    std-msgs \
    tf \
    tf-conversions \
    topic-tools \
    trajectory-msgs \
    urdf \
    visualization-msgs \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/cob_control-release/archive/release/kinetic/cob_twist_controller/0.7.9-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d9f9259f8a5243d597117b99511c9a09"
SRC_URI[sha256sum] = "d8bc0759fa0c8a26ee1bc412e01600e0b61a3cfa800133df8e7ebd85b3d26273"
S = "${WORKDIR}/cob_control-release-release-kinetic-cob_twist_controller-0.7.9-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cob-control', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cob-control', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/cob-control_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/cob-control-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
