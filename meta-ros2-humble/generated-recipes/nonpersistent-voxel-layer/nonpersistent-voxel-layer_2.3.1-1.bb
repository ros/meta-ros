# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "include         This package provides an implementation of a 3D costmap that takes in sensor         data from the world, builds a 3D occupancy grid of the data for only one iteration."
AUTHOR = "Steven Macenski <stevenmacenski@gmail.com>"
ROS_AUTHOR = "Steven Macenski"
HOMEPAGE = "http://wiki.ros.org/non-persisent-voxel-layer"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "nonpersistent_voxel_layer"
ROS_BPN = "nonpersistent_voxel_layer"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    nav-msgs \
    nav2-costmap-2d \
    nav2-msgs \
    nav2-voxel-grid \
    pluginlib \
    rclcpp \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    nav-msgs \
    nav2-costmap-2d \
    nav2-msgs \
    nav2-voxel-grid \
    pluginlib \
    rclcpp \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    nav-msgs \
    nav2-costmap-2d \
    nav2-msgs \
    nav2-voxel-grid \
    pluginlib \
    rclcpp \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/nonpersistent_voxel_layer-release/archive/release/humble/nonpersistent_voxel_layer/2.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/nonpersistent_voxel_layer"
SRC_URI = "git://github.com/SteveMacenski/nonpersistent_voxel_layer-release;${ROS_BRANCH};protocol=https"
SRCREV = "d1c7f6c25745fcc2dde4a3217e063be8a11978eb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
