# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "This package provides an implementation of a 2D costmap that takes in sensor     data from the world, builds a 2D or 3D occupancy grid of the data (depending     on whether a voxel based implementation is used), and inflates costs in a     2D costmap based on the occupancy grid and a user specified inflation radius.     This package also provides support for map_server based initialization of a     costmap, rolling window based costmaps, and parameter based subscription to     and configuration of sensor topics."
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause & Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "navigation2"
ROS_BPN = "nav2_costmap_2d"

ROS_BUILD_DEPENDS = " \
    angles \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    message-filters \
    nav-msgs \
    nav2-common \
    nav2-msgs \
    nav2-util \
    nav2-voxel-grid \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    message-filters \
    nav-msgs \
    nav2-msgs \
    nav2-util \
    nav2-voxel-grid \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    message-filters \
    nav-msgs \
    nav2-msgs \
    nav2-util \
    nav2-voxel-grid \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    launch \
    launch-testing \
    nav2-lifecycle-manager \
    nav2-map-server \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/navigation2-release/archive/release/iron/nav2_costmap_2d/1.2.5-2.tar.gz
ROS_BRANCH ?= "branch=release/iron/nav2_costmap_2d"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release;${ROS_BRANCH};protocol=https"
SRCREV = "d5099afb3ac268bea637dc476c5a5b97de7f3520"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}