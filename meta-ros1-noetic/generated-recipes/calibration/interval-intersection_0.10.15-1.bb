# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Tools for calculating the intersection of interval messages coming     in on several topics. This package is experimental and unstable.     Expect its APIs to change."
AUTHOR = "David Feil-Seifer <david.feilseifer@gmail.com>"
ROS_AUTHOR = "Romain Thibaux"
HOMEPAGE = "http://www.ros.org/wiki/interval_intersection"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "calibration"
ROS_BPN = "interval_intersection"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    calibration-msgs \
    geometry-msgs \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    calibration-msgs \
    geometry-msgs \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    calibration-msgs \
    geometry-msgs \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/calibration-release/archive/release/noetic/interval_intersection/0.10.15-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/interval_intersection"
SRC_URI = "git://github.com/ros-gbp/calibration-release;${ROS_BRANCH};protocol=https"
SRCREV = "c8aaa29025cf353e2380637e54ad223dcfd6c513"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
