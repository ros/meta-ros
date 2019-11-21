# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A collection of tests for checking the validity and completeness of global planners."
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "robot_navigation"
ROS_BPN = "global_planner_tests"

ROS_BUILD_DEPENDS = " \
    map-server \
    nav-core2 \
    nav-msgs \
    pluginlib \
    roscpp \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    map-server \
    nav-core2 \
    nav-msgs \
    pluginlib \
    roscpp \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    map-server \
    nav-core2 \
    nav-msgs \
    pluginlib \
    roscpp \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/locusrobotics/robot_navigation-release/archive/release/kinetic/global_planner_tests/0.2.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "61e9b490868160ab1510ba4d7c36b94e"
SRC_URI[sha256sum] = "2c761414f62dd5d044ab2da756b4ad74babf71d304d5c616f1955e0d5be75615"
S = "${WORKDIR}/robot_navigation-release-release-kinetic-global_planner_tests-0.2.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robot-navigation', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robot-navigation', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-navigation/robot-navigation_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-navigation/robot-navigation-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-navigation/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robot-navigation/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
