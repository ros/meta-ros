# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "This package provides a set of simple math utilities to work         with angles. The utilities cover simple things like         normalizing an angle and conversion between degrees and         radians. But even if you're trying to calculate things like         the shortest angular distance between two joint space         positions of your robot, but the joint motion is constrained         by joint limits, this package is what you need. The code in         this package is stable and well tested. There are no plans for         major changes in the near future."
AUTHOR = "Tully Foote <tfoote@osrfoundation.org>"
ROS_AUTHOR = "John Hsu <hsu@osrfoundation.org>"
HOMEPAGE = "http://wiki.ros.org/angles"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "angles"
ROS_BPN = "angles"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/angles-release/archive/release/eloquent/angles/1.12.2-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/angles"
SRC_URI = "git://github.com/ros2-gbp/angles-release;${ROS_BRANCH};protocol=https"
SRCREV = "9beb9afdddb83b5134d4d8144071cbfd7b71b395"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
