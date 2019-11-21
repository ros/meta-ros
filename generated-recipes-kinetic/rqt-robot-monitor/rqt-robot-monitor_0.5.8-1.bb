# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "rqt_robot_monitor displays diagnostics_agg topics messages that    are published by <a href="http://www.ros.org/wiki/diagnostic_aggregator">diagnostic_aggregator</a>.    rqt_robot_monitor is a direct port to rqt of    <a href="http://www.ros.org/wiki/robot_monitor">robot_monitor</a>. All    diagnostics are fall into one of three tree panes depending on the status of    diagnostics (normal, warning, error/stale). Status are shown in trees to    represent their hierarchy. Worse status dominates the higher level status.<br/>    <ul>     Ex. 'Computer' category has 3 sub devices. 2 are green but 1 is error. Then         'Computer' becomes error.    </ul>   You can look at the detail of each status by double-clicking the tree nodes.<br/>    Currently re-usable API to other pkgs are not explicitly provided."
AUTHOR = "Aaron Blasdel <ablasdel@gmail.com>"
ROS_AUTHOR = "Austin Hendrix"
HOMEPAGE = "http://wiki.ros.org/rqt_robot_monitor"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=23;endline=23;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_robot_monitor"
ROS_BPN = "rqt_robot_monitor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-msgs \
    python-qt-binding \
    python-rospkg \
    qt-gui \
    qt-gui-py-common \
    rospy \
    rqt-bag \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-msgs \
    python-qt-binding \
    python-rospkg \
    qt-gui \
    qt-gui-py-common \
    rospy \
    rqt-bag \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/rqt_robot_monitor-release/archive/release/kinetic/rqt_robot_monitor/0.5.8-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1f8263dc0ef37b3d2f00c717a4bcff8a"
SRC_URI[sha256sum] = "abb088688732aad7354f37f7deecd3350ce535017c82cbb033c25c19a27a5303"
S = "${WORKDIR}/rqt_robot_monitor-release-release-kinetic-rqt_robot_monitor-0.5.8-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rqt-robot-monitor', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rqt-robot-monitor', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-robot-monitor/rqt-robot-monitor_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-robot-monitor/rqt-robot-monitor-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-robot-monitor/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-robot-monitor/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
