# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The controller manager (CM) package provides the infrastructure to run controllers in a hard realtime loop."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Eric Berger berger@willowgarage.com"
HOMEPAGE = "http://ros.org/pr2_controller_manager"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_mechanism"
ROS_BPN = "pr2_controller_manager"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    diagnostic-msgs \
    pluginlib \
    pr2-controller-interface \
    pr2-description \
    pr2-hardware-interface \
    pr2-mechanism-diagnostics \
    pr2-mechanism-model \
    pr2-mechanism-msgs \
    realtime-tools \
    roscpp \
    rostest \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-msgs \
    pluginlib \
    pr2-controller-interface \
    pr2-description \
    pr2-hardware-interface \
    pr2-mechanism-diagnostics \
    pr2-mechanism-model \
    pr2-mechanism-msgs \
    realtime-tools \
    roscpp \
    rosparam \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-msgs \
    pluginlib \
    pr2-controller-interface \
    pr2-description \
    pr2-hardware-interface \
    pr2-mechanism-diagnostics \
    pr2-mechanism-model \
    pr2-mechanism-msgs \
    realtime-tools \
    roscpp \
    rosparam \
    rospy \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_mechanism-release/archive/release/melodic/pr2_controller_manager/1.8.18-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pr2_controller_manager"
SRC_URI = "git://github.com/pr2-gbp/pr2_mechanism-release;${ROS_BRANCH};protocol=https"
SRCREV = "17e62d62b6a194679536f494fcddc3e1ef8efb1b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
