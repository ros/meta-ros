# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A simple script that aggregates all of the topics that a &quot;pr2_dashboard&quot; app might be interested in."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Rob Wheeler"
HOMEPAGE = "http://ros.org/wiki/pr2_dashboard_aggregator"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_common"
ROS_BPN = "pr2_dashboard_aggregator"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    pr2-msgs \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pr2-msgs \
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

# matches with: https://github.com/pr2-gbp/pr2_common-release/archive/release/noetic/pr2_dashboard_aggregator/1.13.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_dashboard_aggregator"
SRC_URI = "git://github.com/pr2-gbp/pr2_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "17a4d13d979c3631737c465a5b58d87204f88d2a"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
