# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "industrial robot client contains generic clients for connecting       to industrial robot controllers with servers that adhere to the      simple message protocol."
AUTHOR = "G.A. vd. Hoorn (TU Delft Robotics Institute) <g.a.vanderhoorn@tudelft.nl>"
ROS_AUTHOR = "Jeremy Zoss"
HOMEPAGE = "http://ros.org/wiki/industrial_robot_client"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "industrial_core"
ROS_BPN = "industrial_robot_client"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    control-msgs \
    industrial-msgs \
    industrial-utils \
    roscpp \
    sensor-msgs \
    simple-message \
    std-msgs \
    trajectory-msgs \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    control-msgs \
    industrial-msgs \
    industrial-utils \
    roscpp \
    sensor-msgs \
    simple-message \
    std-msgs \
    trajectory-msgs \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    control-msgs \
    industrial-msgs \
    industrial-utils \
    robot-state-publisher \
    roscpp \
    sensor-msgs \
    simple-message \
    std-msgs \
    trajectory-msgs \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/industrial_core-release/archive/release/noetic/industrial_robot_client/0.7.2-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/industrial_robot_client"
SRC_URI = "git://github.com/ros-industrial-release/industrial_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "1242b4262a7d38fbd8d1683df67ef9d973d85e4d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
