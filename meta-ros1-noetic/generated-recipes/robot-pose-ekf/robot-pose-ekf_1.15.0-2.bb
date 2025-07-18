# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The Robot Pose EKF package is used to estimate the 3D pose of a robot, based on (partial) pose measurements coming from different sources. It uses an extended Kalman filter with a 6D model (3D position and 3D orientation) to combine measurements from wheel odometry, IMU sensor and visual odometry. The basic idea is to offer loosely coupled integration with different sensors, where sensor signals are received as ROS messages."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Wim Meeussen"
HOMEPAGE = "http://wiki.ros.org/robot_pose_ekf"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "robot_pose_ekf"
ROS_BPN = "robot_pose_ekf"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liborocos-bfl-dev} \
    geometry-msgs \
    message-generation \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liborocos-bfl-dev} \
    geometry-msgs \
    message-runtime \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosbag \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/robot_pose_ekf-release/archive/release/noetic/robot_pose_ekf/1.15.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/robot_pose_ekf"
SRC_URI = "git://github.com/ros-gbp/robot_pose_ekf-release;${ROS_BRANCH};protocol=https"
SRCREV = "a8fe9a9277b83e82ca96b726acbaecd32443f6ea"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
