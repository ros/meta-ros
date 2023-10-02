# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "simple_message defines a simple messaging connection and protocol for communicating  	with an industrial robot controller.  Additional handler and manager classes are  	included for handling connection limited systems.  This package is part of the ROS-Industrial  	program."
AUTHOR = "G.A. vd. Hoorn (TU Delft Robotics Institute) <g.a.vanderhoorn@tudelft.nl>"
ROS_AUTHOR = "Shaun Edwards"
HOMEPAGE = "http://ros.org/wiki/simple_message"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "industrial_core"
ROS_BPN = "simple_message"

ROS_BUILD_DEPENDS = " \
    industrial-msgs \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    industrial-msgs \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    industrial-msgs \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/industrial_core-release/archive/release/melodic/simple_message/0.7.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/simple_message"
SRC_URI = "git://github.com/ros-industrial-release/industrial_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "666fd8823121578b6a0b046e60f9c9e1b009fb6f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
