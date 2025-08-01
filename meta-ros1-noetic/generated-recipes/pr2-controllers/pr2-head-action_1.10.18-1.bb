# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The PR2 head action is a node that provides an action interface for   pointing the head of the PR2.  It passes trajectory goals to the   controller, and reports success when they have finished executing."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Stuart Glaser"
HOMEPAGE = "http://ros.org/wiki/pr2_head_action"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_controllers"
ROS_BPN = "pr2_head_action"

ROS_BUILD_DEPENDS = " \
    actionlib \
    geometry-msgs \
    kdl-parser \
    message-filters \
    orocos-kdl \
    pr2-controllers-msgs \
    roscpp \
    sensor-msgs \
    tf \
    tf-conversions \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    geometry-msgs \
    kdl-parser \
    message-filters \
    orocos-kdl \
    pr2-controllers-msgs \
    roscpp \
    sensor-msgs \
    tf \
    tf-conversions \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_controllers-release/archive/release/noetic/pr2_head_action/1.10.18-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_head_action"
SRC_URI = "git://github.com/pr2-gbp/pr2_controllers-release;${ROS_BRANCH};protocol=https"
SRCREV = "ae0e7bd6705f82168495ca215964ac35cbbf1d31"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
