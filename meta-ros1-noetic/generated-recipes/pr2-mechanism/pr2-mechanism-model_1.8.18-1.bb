# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "<p>         This package contains the robot model that is used by the realtime         controllers         inside <a href="http://www.ros.org/wiki/pr2_controller_manager">controller            manager</a>. This robot model focuses on controlling the robot         mechanism in a realtime control loop, and therefore it only contains         the components of a robot that are relevant in realtime: the robot         joints (with encoders, transmisisons and actuators) and the         kinematic/dynamic model of the robot.      </p>      <p>         The pr2_mechanism_model package is well tested and is released with a stable API.      </p>"
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Eric Berger berger@willowgarage.com"
HOMEPAGE = "http://ros.org/wiki/pr2_mechanism_model"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=21;endline=21;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_mechanism"
ROS_BPN = "pr2_mechanism_model"

ROS_BUILD_DEPENDS = " \
    angles \
    cmake-modules \
    hardware-interface \
    kdl-parser \
    pluginlib \
    pr2-hardware-interface \
    roscpp \
    rostest \
    rosunit \
    urdf \
    urdfdom \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    hardware-interface \
    kdl-parser \
    pluginlib \
    pr2-hardware-interface \
    roscpp \
    urdf \
    urdfdom \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    hardware-interface \
    kdl-parser \
    pluginlib \
    pr2-hardware-interface \
    roscpp \
    urdf \
    urdfdom \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_mechanism-release/archive/release/noetic/pr2_mechanism_model/1.8.18-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_mechanism_model"
SRC_URI = "git://github.com/pr2-gbp/pr2_mechanism-release;${ROS_BRANCH};protocol=https"
SRCREV = "1a63ae02acd83f4e9ba9b504fc7c181f03c0285e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
