# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The rosbag_snapshot package"
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
ROS_AUTHOR = "Kevin Allen <kma1660+rsp@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rosbag_snapshot"
ROS_BPN = "rosbag_snapshot"

ROS_BUILD_DEPENDS = " \
    rosbag \
    rosbag-snapshot-msgs \
    roscpp \
    rosgraph-msgs \
    std-srvs \
    topic-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rosbag \
    rosbag-snapshot-msgs \
    roscpp \
    rosgraph-msgs \
    std-srvs \
    topic-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rosbag \
    rosbag-snapshot-msgs \
    roscpp \
    rosgraph-msgs \
    std-srvs \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslint \
    rospy \
    rostest \
    rostopic \
    std-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/rosbag_snapshot-release/archive/release/noetic/rosbag_snapshot/1.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rosbag_snapshot"
SRC_URI = "git://github.com/ros-gbp/rosbag_snapshot-release;${ROS_BRANCH};protocol=https"
SRCREV = "a360e8affcc2875be19e78622cebd2870c2ab314"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
