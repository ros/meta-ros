# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A common drone teleop interface for all drone exercises in the JdeRobot Robotics Academy"
AUTHOR = "Nikhil Khedekar <nikhilvkhedekar@gmail.com>"
ROS_AUTHOR = "Nikhil Khedekar <nikhilvkhedekar@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=1a58895467feb5b42724abbf3f0d9612"

ROS_CN = "jderobot_drones"
ROS_BPN = "rqt_drone_teleop"

ROS_BUILD_DEPENDS = " \
    ${PYTHON_PN}-rospkg \
    drone-wrapper \
    geometry-msgs \
    roslib \
    rospy \
    rqt-gui \
    rqt-gui-py \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${PYTHON_PN}-rospkg \
    drone-wrapper \
    geometry-msgs \
    roslib \
    rospy \
    rqt-gui \
    rqt-gui-py \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-rospkg \
    drone-wrapper \
    geometry-msgs \
    roslib \
    rospy \
    rqt-gui \
    rqt-gui-py \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/JdeRobot/drones-release/archive/release/noetic/rqt_drone_teleop/1.4.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rqt_drone_teleop"
SRC_URI = "git://github.com/JdeRobot/drones-release;${ROS_BRANCH};protocol=https"
SRCREV = "ef35b5e29cc9c9815c5917c3de6072233c8e3d8e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
