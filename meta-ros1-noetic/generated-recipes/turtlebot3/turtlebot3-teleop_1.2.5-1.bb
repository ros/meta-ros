# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Provides teleoperation using keyboard for TurtleBot3."
AUTHOR = "Will Son <willson@robotis.com>"
ROS_AUTHOR = "Melonee Wise"
HOMEPAGE = "http://wiki.ros.org/turtlebot3_teleop"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "turtlebot3"
ROS_BPN = "turtlebot3_teleop"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    rospy \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ROBOTIS-GIT-release/turtlebot3-release/archive/release/noetic/turtlebot3_teleop/1.2.5-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/turtlebot3_teleop"
SRC_URI = "git://github.com/ROBOTIS-GIT-release/turtlebot3-release;${ROS_BRANCH};protocol=https"
SRCREV = "6374b1776ab6ab09e6d5b7e36eaa2b723a7911dd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
