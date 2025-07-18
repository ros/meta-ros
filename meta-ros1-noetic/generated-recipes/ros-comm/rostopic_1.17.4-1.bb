# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "rostopic contains the rostopic command-line tool for displaying     debug information about     ROS <a href="http://wiki.ros.org/Topics">Topics</a>, including     publishers, subscribers, publishing rate,     and ROS <a href="http://wiki.ros.org/Messages">Messages</a>. It also     contains an experimental Python library for getting information about     and interacting with topics dynamically. This library is for     internal-use only as the code API may change, though it does provide     examples of how to implement dynamic subscription and publication     behaviors in ROS."
AUTHOR = "Michael Carroll <michael@openrobotics.org>"
ROS_AUTHOR = "Ken Conley"
HOMEPAGE = "http://ros.org/wiki/rostopic"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_comm"
ROS_BPN = "rostopic"

ROS_BUILD_DEPENDS = " \
    rostest \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    genpy \
    rosbag \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    genpy \
    rosbag \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/ros_comm-release/archive/release/noetic/rostopic/1.17.4-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rostopic"
SRC_URI = "git://github.com/ros-gbp/ros_comm-release;${ROS_BRANCH};protocol=https"
SRCREV = "7885b8ad2bc98c3f8a7a1ce724cab7f689ebc60d"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
