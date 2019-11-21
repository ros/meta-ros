# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The pr2_calibration_controllers package contains the controllers      used to bring all the joints in the PR2 to a calibrated state."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Stuart Glaser"
HOMEPAGE = "http://ros.org/wiki/pr2_calibration_controllers"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_controllers"
ROS_BPN = "pr2_calibration_controllers"

ROS_BUILD_DEPENDS = " \
    pluginlib \
    pr2-controller-interface \
    pr2-mechanism-controllers \
    pr2-mechanism-model \
    realtime-tools \
    robot-mechanism-controllers \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    pluginlib \
    pr2-controller-interface \
    pr2-mechanism-controllers \
    pr2-mechanism-model \
    realtime-tools \
    robot-mechanism-controllers \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pluginlib \
    pr2-controller-interface \
    pr2-mechanism-controllers \
    pr2-mechanism-model \
    realtime-tools \
    robot-mechanism-controllers \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/pr2-gbp/pr2_controllers-release/archive/release/kinetic/pr2_calibration_controllers/1.10.14-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "28ed7b4c176a7a5bc2032e1994aa5c68"
SRC_URI[sha256sum] = "e5277d6f28bd2320220e4919f18a20be95082acb76f0eec2d96e73db9e1c793c"
S = "${WORKDIR}/pr2_controllers-release-release-kinetic-pr2_calibration_controllers-1.10.14-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pr2-controllers', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pr2-controllers', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/pr2-controllers_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/pr2-controllers-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
