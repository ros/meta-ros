# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Planning components of MoveIt that use ROS"
AUTHOR = "Michael Ferguson <mferguson@fetchrobotics.com>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit"
ROS_BPN = "moveit_ros_planning"

ROS_BUILD_DEPENDS = " \
    actionlib \
    dynamic-reconfigure \
    libeigen \
    message-filters \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    pluginlib \
    rosconsole \
    roscpp \
    srdfdom \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    dynamic-reconfigure \
    message-filters \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    pluginlib \
    rosconsole \
    roscpp \
    srdfdom \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    dynamic-reconfigure \
    message-filters \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    pluginlib \
    rosconsole \
    roscpp \
    srdfdom \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    moveit-resources-panda-moveit-config \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/moveit-release/archive/release/noetic/moveit_ros_planning/1.1.5-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/moveit_ros_planning"
SRC_URI = "git://github.com/ros-gbp/moveit-release;${ROS_BRANCH};protocol=https"
SRCREV = "8245cf4729931e8a1d175e1560a9e7f117d5cd64"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
