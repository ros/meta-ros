# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A reverse ROS bridge for the MiR100 robot"
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
ROS_AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
HOMEPAGE = "https://github.com/dfki-ric/mir_robot"
SECTION = "devel"
LICENSE = "BSD & Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mir_robot"
ROS_BPN = "mir_driver"

ROS_BUILD_DEPENDS = " \
    actionlib-msgs \
    diagnostic-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    mir-actions \
    mir-msgs \
    move-base-msgs \
    nav-msgs \
    python-websocket-client \
    rosgraph-msgs \
    roslaunch \
    rospy \
    rospy-message-converter \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-msgs \
    diagnostic-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    mir-actions \
    mir-msgs \
    move-base-msgs \
    nav-msgs \
    python-websocket-client \
    rosgraph-msgs \
    rospy \
    rospy-message-converter \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    diagnostic-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    mir-actions \
    mir-description \
    mir-msgs \
    move-base-msgs \
    nav-msgs \
    python-websocket-client \
    robot-state-publisher \
    rosgraph-msgs \
    rospy \
    rospy-message-converter \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/uos-gbp/mir_robot-release/archive/release/kinetic/mir_driver/1.0.4-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "123be725381b6f495e985eaba4e54781"
SRC_URI[sha256sum] = "94fd8404a52b48030c960461863968b9a3466122a3f18678e3ac951beeca8869"
S = "${WORKDIR}/mir_robot-release-release-kinetic-mir_driver-1.0.4-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('mir-robot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('mir-robot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mir-robot/mir-robot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mir-robot/mir-robot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mir-robot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mir-robot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
