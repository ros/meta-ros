# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "pr2_move_base"
AUTHOR = "David Feil-Seifer <dave@cse.unr.edu>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://ros.org/wiki/pr2_move_base"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_navigation"
ROS_BPN = "pr2_move_base"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    dynamic-reconfigure \
    move-base-msgs \
    pr2-common-action-msgs \
    pr2-controllers-msgs \
    pr2-msgs \
    rospy \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    dynamic-reconfigure \
    move-base-msgs \
    pr2-common-action-msgs \
    pr2-controllers-msgs \
    pr2-msgs \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    dynamic-reconfigure \
    move-base-msgs \
    pr2-common-action-msgs \
    pr2-controllers-msgs \
    pr2-msgs \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_navigation-release/archive/release/melodic/pr2_move_base/0.1.28-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pr2_move_base"
SRC_URI = "git://github.com/pr2-gbp/pr2_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "bdad5b28038c79f6b421f1d78c1c4fa3ff310b62"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
