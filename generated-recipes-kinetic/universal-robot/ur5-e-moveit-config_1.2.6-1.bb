# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "An automatically generated package with all the configuration and launch files for using the ur5e with the MoveIt Motion Planning Framework"
AUTHOR = "G.A. vd. Hoorn <g.a.vanderhoorn@tudelft.nl>"
ROS_AUTHOR = "Felix Messmer"
HOMEPAGE = "http://moveit.ros.org/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "universal_robot"
ROS_BPN = "ur5_e_moveit_config"

ROS_BUILD_DEPENDS = " \
    ur-description \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ur-description \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    moveit-fake-controller-manager \
    moveit-planners-ompl \
    moveit-ros-move-group \
    moveit-ros-visualization \
    moveit-simple-controller-manager \
    robot-state-publisher \
    ur-description \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-industrial-release/universal_robot-release/archive/release/kinetic/ur5_e_moveit_config/1.2.6-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d5b93e7661600e8dfeda2f335bc7d83b"
SRC_URI[sha256sum] = "d8f15fed97aa424a5f787146a7414edd48d17658288db15e60c107f536f1741d"
S = "${WORKDIR}/universal_robot-release-release-kinetic-ur5_e_moveit_config-1.2.6-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('universal-robot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('universal-robot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/universal-robot/universal-robot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/universal-robot/universal-robot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/universal-robot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/universal-robot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
