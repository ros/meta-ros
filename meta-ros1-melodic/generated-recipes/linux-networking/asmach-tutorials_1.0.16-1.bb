# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package containes numerous examples of how to use SMACH. See the examples directory."
AUTHOR = "Devon Ash <dash@clearpathrobotics.com>"
ROS_AUTHOR = "Jonathan Bohren"
HOMEPAGE = "http://ros.org/wiki/smach_tutorials"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "linux_networking"
ROS_BPN = "asmach_tutorials"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    asmach \
    message-generation \
    rospy \
    smach-ros \
    turtlesim \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    asmach \
    rospy \
    smach-ros \
    turtlesim \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    asmach \
    rospy \
    smach-ros \
    turtlesim \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/linux_networking-release/archive/release/melodic/asmach_tutorials/1.0.16-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/asmach_tutorials"
SRC_URI = "git://github.com/pr2-gbp/linux_networking-release;${ROS_BRANCH};protocol=https"
SRCREV = "f03d78be871e3205659af0300d31693aeef3258f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
