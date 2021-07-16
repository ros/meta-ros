# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Monitors the computer's processor and hard drives of the PR2 and publishes data to diagnostics."
AUTHOR = "Dave Feil-Seifer <dave@cse.unr.edu>"
ROS_AUTHOR = "Kevin Watts (watts@willowgarage.com)"
HOMEPAGE = "http://www.ros.org/wiki/pr2_computer_monitor"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_robot"
ROS_BPN = "pr2_computer_monitor"

ROS_BUILD_DEPENDS = " \
    diagnostic-msgs \
    pr2-msgs \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-msgs \
    pr2-msgs \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-msgs \
    pr2-msgs \
    roscpp \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_robot-release/archive/release/noetic/pr2_computer_monitor/1.6.32-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_computer_monitor"
SRC_URI = "git://github.com/pr2-gbp/pr2_robot-release;${ROS_BRANCH};protocol=https"
SRCREV = "23158ca46fa8481709bf11d477996421e198b888"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
