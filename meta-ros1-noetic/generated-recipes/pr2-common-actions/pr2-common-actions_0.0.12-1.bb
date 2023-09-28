# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Various actions which help in moving the arms of the PR2     or getting data from its tilting laser."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://wiki.ros.org/pr2_common_actions"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_common_actions"
ROS_BPN = "pr2_common_actions"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joint-trajectory-action-tools \
    joint-trajectory-generator \
    pr2-arm-move-ik \
    pr2-common-action-msgs \
    pr2-tilt-laser-interface \
    pr2-tuck-arms-action \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-trajectory-action-tools \
    joint-trajectory-generator \
    pr2-arm-move-ik \
    pr2-common-action-msgs \
    pr2-tilt-laser-interface \
    pr2-tuck-arms-action \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_common_actions-release/archive/release/noetic/pr2_common_actions/0.0.12-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_common_actions"
SRC_URI = "git://github.com/pr2-gbp/pr2_common_actions-release;${ROS_BRANCH};protocol=https"
SRCREV = "1e3790bbe2fc6f3f4c9363361dcda194a895f78a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
