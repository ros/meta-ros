# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Controllers used in PR2 hardware testing. For testing counterbalance of PR2, and for internal WG use."
AUTHOR = "David Feil-Seifer <dave@cse.unr.edu>"
ROS_AUTHOR = "Kevin Watts"
HOMEPAGE = "http://www.ros.org/wiki/joint_qualification_controllers"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_self_test"
ROS_BPN = "joint_qualification_controllers"

ROS_BUILD_DEPENDS = " \
    control-toolbox \
    message-generation \
    pluginlib \
    pr2-controller-interface \
    pr2-hardware-interface \
    pr2-mechanism-model \
    realtime-tools \
    robot-mechanism-controllers \
    roscpp \
    sensor-msgs \
    std-msgs \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    control-toolbox \
    message-runtime \
    pluginlib \
    pr2-controller-interface \
    pr2-hardware-interface \
    pr2-mechanism-model \
    realtime-tools \
    robot-mechanism-controllers \
    roscpp \
    sensor-msgs \
    std-msgs \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    control-toolbox \
    message-runtime \
    pluginlib \
    pr2-controller-interface \
    pr2-hardware-interface \
    pr2-mechanism-model \
    realtime-tools \
    robot-mechanism-controllers \
    roscpp \
    sensor-msgs \
    std-msgs \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_self_test-release/archive/release/noetic/joint_qualification_controllers/1.0.15-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/joint_qualification_controllers"
SRC_URI = "git://github.com/pr2-gbp/pr2_self_test-release;${ROS_BRANCH};protocol=https"
SRCREV = "b1800487bdd09b32810f18f12a763cb0ffd20612"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
