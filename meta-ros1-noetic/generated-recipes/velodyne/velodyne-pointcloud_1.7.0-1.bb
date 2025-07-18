# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Point cloud conversions for Velodyne 3D LIDARs."
AUTHOR = "Josh Whitley <josh.whitley@autoware.org>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://ros.org/wiki/velodyne_pointcloud"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "velodyne"
ROS_BPN = "velodyne_pointcloud"

ROS_BUILD_DEPENDS = " \
    angles \
    diagnostic-updater \
    dynamic-reconfigure \
    libeigen \
    nodelet \
    roscpp \
    roslib \
    roslint \
    sensor-msgs \
    tf2-ros \
    velodyne-driver \
    velodyne-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    diagnostic-updater \
    dynamic-reconfigure \
    libeigen \
    nodelet \
    roscpp \
    roslib \
    sensor-msgs \
    tf2-ros \
    velodyne-driver \
    velodyne-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    diagnostic-updater \
    dynamic-reconfigure \
    libeigen \
    nodelet \
    roscpp \
    roslib \
    sensor-msgs \
    tf2-ros \
    velodyne-driver \
    velodyne-laserscan \
    velodyne-msgs \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rostest \
    rosunit \
    tf2-ros \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/velodyne-release/archive/release/noetic/velodyne_pointcloud/1.7.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/velodyne_pointcloud"
SRC_URI = "git://github.com/ros-drivers-gbp/velodyne-release;${ROS_BRANCH};protocol=https"
SRCREV = "8c34551bd93a2803736728eb9808118b85f1d35b"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
