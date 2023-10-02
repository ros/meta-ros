# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Meta package for khi_robot"
AUTHOR = "nakamichi_d <nakamichi_d@khi.co.jp>"
ROS_AUTHOR = "nakamichi_d <nakamichi_d@khi.co.jp>"
HOMEPAGE = "http://ros.org/wiki/khi_robot"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "khi_robot"
ROS_BPN = "khi_robot"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    khi-duaro-description \
    khi-duaro-gazebo \
    khi-duaro-ikfast-plugin \
    khi-duaro-moveit-config \
    khi-robot-bringup \
    khi-robot-control \
    khi-robot-msgs \
    khi-rs-description \
    khi-rs-gazebo \
    khi-rs-ikfast-plugin \
    khi-rs007l-moveit-config \
    khi-rs007n-moveit-config \
    khi-rs080n-moveit-config \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    khi-duaro-description \
    khi-duaro-gazebo \
    khi-duaro-ikfast-plugin \
    khi-duaro-moveit-config \
    khi-robot-bringup \
    khi-robot-control \
    khi-robot-msgs \
    khi-rs-description \
    khi-rs-gazebo \
    khi-rs-ikfast-plugin \
    khi-rs007l-moveit-config \
    khi-rs007n-moveit-config \
    khi-rs080n-moveit-config \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/Kawasaki-Robotics/khi_robot-release/archive/release/melodic/khi_robot/1.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/khi_robot"
SRC_URI = "git://github.com/Kawasaki-Robotics/khi_robot-release;${ROS_BRANCH};protocol=https"
SRCREV = "d225c0fbc0a762710ccf002b99747caedcfa4e00"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
