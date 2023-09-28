# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package specifies the interface to a realtime controller. A    controller that implements this interface can be executed by the     <a href="http://www.ros.org/wiki/pr2_controller_manager">controller   manager</a> in the real time control loop. The package basically   contains the C++ controller base class that all controllers need to   inherit from."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Wim Meeussen"
HOMEPAGE = "http://ros.org/wiki/pr2_controller_interface"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_mechanism"
ROS_BPN = "pr2_controller_interface"

ROS_BUILD_DEPENDS = " \
    controller-interface \
    pr2-mechanism-model \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-interface \
    pr2-mechanism-model \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-interface \
    pr2-mechanism-model \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_mechanism-release/archive/release/noetic/pr2_controller_interface/1.8.18-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_controller_interface"
SRC_URI = "git://github.com/pr2-gbp/pr2_mechanism-release;${ROS_BRANCH};protocol=https"
SRCREV = "465c8da767ff2504a4ff3645f09f2245d1cab904"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
