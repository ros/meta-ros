# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Service and message definitions for rosbag_snapshot"
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
ROS_AUTHOR = "Kevin Allen <kma1660+rsp@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rosbag_snapshot"
ROS_BPN = "rosbag_snapshot_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    rosgraph-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    rosgraph-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    rosgraph-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/rosbag_snapshot-release/archive/release/noetic/rosbag_snapshot_msgs/1.0.6-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rosbag_snapshot_msgs"
SRC_URI = "git://github.com/ros-gbp/rosbag_snapshot-release;${ROS_BRANCH};protocol=https"
SRCREV = "0641e4a037c3440afeca0d0f94371a344ac3f7c4"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
