# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The VRPN is a library and set of servers that interfaces with virtual-reality systems, such as VICON, OptiTrack, and others."
AUTHOR = "Paul Bovbel <paul@bovbel.com>"
ROS_AUTHOR = "Russell M. Taylor"
HOMEPAGE = "https://github.com/vrpn/vrpn/wiki"
SECTION = "devel"
LICENSE = "BSL1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=1c7945be8716a98e36e855a20dc9b844"

ROS_CN = "vrpn"
ROS_BPN = "vrpn"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    catkin \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    catkin \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/vrpn-release/archive/release/melodic/vrpn/7.34.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/vrpn"
SRC_URI = "git://github.com/ros-drivers-gbp/vrpn-release;${ROS_BRANCH};protocol=https"
SRCREV = "2c191f6336f5b6568616375c3fb6a1c6f0c2fe0d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
