# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Clearpath Husky controller configurations"
AUTHOR = "Tony Baltovski <tbaltovski@clearpathrobotics.com>"
ROS_AUTHOR = "Paul Bovbel <paul@bovbel.com>"
HOMEPAGE = "http://ros.org/wiki/husky_control"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "husky"
ROS_BPN = "husky_control"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-manager \
    diff-drive-controller \
    husky-description \
    interactive-marker-twist-server \
    joint-state-controller \
    joint-trajectory-controller \
    joy \
    robot-localization \
    robot-state-publisher \
    rostopic \
    teleop-twist-joy \
    twist-mux \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    diff-drive-controller \
    husky-description \
    interactive-marker-twist-server \
    joint-state-controller \
    joint-trajectory-controller \
    joy \
    robot-localization \
    robot-state-publisher \
    rostopic \
    teleop-twist-joy \
    twist-mux \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/clearpath-gbp/husky-release/archive/release/noetic/husky_control/0.6.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/husky_control"
SRC_URI = "git://github.com/clearpath-gbp/husky-release;${ROS_BRANCH};protocol=https"
SRCREV = "67863997e624f0306008b7e482d81bb6c250f030"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
