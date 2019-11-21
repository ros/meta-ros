# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A common drone teleop interface for all drone exercises in the JdeRobot Robotics Academy"
AUTHOR = "Nikhil Khedekar <nikhilvkhedekar@gmail.com>"
ROS_AUTHOR = "Nikhil Khedekar <nikhilvkhedekar@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=1a58895467feb5b42724abbf3f0d9612"

ROS_CN = "jderobot_drones"
ROS_BPN = "rqt_drone_teleop"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    python-rospkg \
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
    geometry-msgs \
    python-rospkg \
    roslib \
    rospy \
    rqt-gui \
    rqt-gui-py \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    python-rospkg \
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

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/JdeRobot/drones-release/archive/release/kinetic/rqt_drone_teleop/1.0.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1385212b845f3d72da639b502881f269"
SRC_URI[sha256sum] = "ab6fb9502cd02df0777feecf745153c2949622dc1ec7c4efe2cb8ea392ad3743"
S = "${WORKDIR}/drones-release-release-kinetic-rqt_drone_teleop-1.0.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('jderobot-drones', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('jderobot-drones', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jderobot-drones/jderobot-drones_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jderobot-drones/jderobot-drones-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jderobot-drones/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jderobot-drones/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
