# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "arm_navigation_msgs"
AUTHOR = "Devon Ash <dash@clearpathrobotics.com>"
ROS_AUTHOR = "Gil Jones"
HOMEPAGE = "http://ros.org/wiki/arm_navigation_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "openrave_planning"
ROS_BPN = "arm_navigation_msgs"

ROS_BUILD_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    message-generation \
    sensor-msgs \
    std-msgs \
    tf \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
    tf \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
    tf \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/openrave_planning-release/archive/release/kinetic/arm_navigation_msgs/0.0.6-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dfe88d365682ebcac4ccb3687e79d946"
SRC_URI[sha256sum] = "4da8f9b727646dd5d6434e80e074a72c63d572a60c3c4350d7db6eaca6c04847"
S = "${WORKDIR}/openrave_planning-release-release-kinetic-arm_navigation_msgs-0.0.6-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('openrave-planning', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('openrave-planning', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/openrave-planning_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/openrave-planning-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
