# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "ROS 2 package suite for Raspberry Pi Mouse Simulator"
AUTHOR = "RT Corporation <shop@rt-net.jp>"
ROS_AUTHOR = "Daisuke Sato <tiryoh@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "raspimouse_sim"
ROS_BPN = "raspimouse_sim"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    raspimouse-fake \
    raspimouse-gazebo \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/raspimouse_sim-release/archive/release/jazzy/raspimouse_sim/3.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/raspimouse_sim"
SRC_URI = "git://github.com/ros2-gbp/raspimouse_sim-release;${ROS_BRANCH};protocol=https"
SRCREV = "ee72984e39d6937aebc83f18e1acd5472014e271"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
