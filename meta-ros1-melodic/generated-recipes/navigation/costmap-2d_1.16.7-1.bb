# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package provides an implementation of a 2D costmap that takes in sensor         data from the world, builds a 2D or 3D occupancy grid of the data (depending         on whether a voxel based implementation is used), and inflates costs in a         2D costmap based on the occupancy grid and a user specified inflation radius.         This package also provides support for map_server based initialization of a         costmap, rolling window based costmaps, and parameter based subscription to         and configuration of sensor topics."
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://wiki.ros.org/costmap_2d"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=22;endline=22;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "navigation"
ROS_BPN = "costmap_2d"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    message-filters \
    message-generation \
    nav-msgs \
    pluginlib \
    roscpp \
    rostest \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
    voxel-grid \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    message-filters \
    nav-msgs \
    pluginlib \
    roscpp \
    rostest \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
    visualization-msgs \
    voxel-grid \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    message-filters \
    message-runtime \
    nav-msgs \
    pluginlib \
    rosconsole \
    roscpp \
    rostest \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
    visualization-msgs \
    voxel-grid \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    map-server \
    rosbag \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/navigation-release/archive/release/melodic/costmap_2d/1.16.7-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/costmap_2d"
SRC_URI = "git://github.com/ros-gbp/navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "7d8415d7f1dd06b717d0edccc345ced87cc18dce"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
