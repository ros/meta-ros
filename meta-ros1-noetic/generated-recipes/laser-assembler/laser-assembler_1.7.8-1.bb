# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Provides nodes to assemble point clouds from either LaserScan or PointCloud messages"
AUTHOR = "Jonathan Binney <jon.binney@gmail.com>"
ROS_AUTHOR = "Vijay Pradeep"
HOMEPAGE = "http://ros.org/wiki/laser_assembler"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "laser_assembler"
ROS_BPN = "laser_assembler"

ROS_BUILD_DEPENDS = " \
    filters \
    laser-geometry \
    message-filters \
    message-generation \
    pluginlib \
    roscpp \
    rostest \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    filters \
    laser-geometry \
    message-filters \
    message-runtime \
    pluginlib \
    roscpp \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    filters \
    laser-geometry \
    message-filters \
    message-runtime \
    pluginlib \
    roscpp \
    sensor-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/laser_assembler-release/archive/release/noetic/laser_assembler/1.7.8-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/laser_assembler"
SRC_URI = "git://github.com/ros-gbp/laser_assembler-release;${ROS_BRANCH};protocol=https"
SRCREV = "69afa4455ffd6e4982e1b260b8dc3d3d193ae61e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
