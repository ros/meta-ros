# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Point cloud conversions for Velodyne 3D LIDARs."
AUTHOR = "Josh Whitley <jwhitley@autonomoustuff.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://ros.org/wiki/velodyne_pointcloud"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "velodyne"
ROS_BPN = "velodyne_pointcloud"

ROS_BUILD_DEPENDS = " \
    angles \
    diagnostic-updater \
    geometry-msgs \
    message-filters \
    pcl \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    tf2 \
    tf2-ros \
    velodyne-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    diagnostic-updater \
    geometry-msgs \
    message-filters \
    pcl \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    tf2 \
    tf2-ros \
    velodyne-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    diagnostic-updater \
    geometry-msgs \
    message-filters \
    pcl \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    tf2 \
    tf2-ros \
    velodyne-msgs \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/velodyne-release/archive/release/foxy/velodyne_pointcloud/2.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/velodyne_pointcloud"
SRC_URI = "git://github.com/ros-drivers-gbp/velodyne-release;${ROS_BRANCH};protocol=https"
SRCREV = "1b34974d9c5f067d782904360a5041f686256d3b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
