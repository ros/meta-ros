# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The pr2_tuck_arms_action package"
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Wim Meeussen"
HOMEPAGE = "http://wiki.ros.org/pr2_tuck_arms_action"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_common_actions"
ROS_BPN = "pr2_tuck_arms_action"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    pr2-common-action-msgs \
    pr2-controllers-msgs \
    rospy \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    pr2-common-action-msgs \
    pr2-controllers-msgs \
    rospy \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    pr2-common-action-msgs \
    pr2-controllers-msgs \
    rospy \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_common_actions-release/archive/release/melodic/pr2_tuck_arms_action/0.0.11-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pr2_tuck_arms_action"
SRC_URI = "git://github.com/pr2-gbp/pr2_common_actions-release;${ROS_BRANCH};protocol=https"
SRCREV = "b4b1c9bb468ce8c3bde414d0b2129b4eb38f4304"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
