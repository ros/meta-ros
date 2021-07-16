# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "turtle_actionlib demonstrates how to write an action server and client with the turtlesim. The shape_server provides and action interface for drawing regular polygons with the turtlesim."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Melonee Wise"
HOMEPAGE = "http://ros.org/wiki/turtle_actionlib"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "common_tutorials"
ROS_BPN = "turtle_actionlib"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    angles \
    geometry-msgs \
    message-generation \
    rosconsole \
    roscpp \
    std-msgs \
    turtlesim \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    angles \
    geometry-msgs \
    message-runtime \
    rosconsole \
    roscpp \
    std-msgs \
    turtlesim \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    angles \
    geometry-msgs \
    message-runtime \
    rosconsole \
    roscpp \
    std-msgs \
    turtlesim \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/common_tutorials-release/archive/release/noetic/turtle_actionlib/0.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/turtle_actionlib"
SRC_URI = "git://github.com/ros-gbp/common_tutorials-release;${ROS_BRANCH};protocol=https"
SRCREV = "544f7d9c48d1aab6fc44f8ac57bc6918cc29d6c8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
