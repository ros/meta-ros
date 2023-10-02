# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "include         This package provides an implementation of a 3D costmap that takes in sensor         data from the world, builds a 3D occupancy grid of the data for only one iteration."
AUTHOR = "Steven Macenski <stevenmacenski@gmail.com>"
ROS_AUTHOR = "Steven Macenski"
HOMEPAGE = "http://wiki.ros.org/non-persisent-voxel-layer"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "nonpersistent_voxel_layer"
ROS_BPN = "nonpersistent_voxel_layer"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    costmap-2d \
    dynamic-reconfigure \
    geometry-msgs \
    laser-geometry \
    map-msgs \
    message-filters \
    message-generation \
    nav-msgs \
    pluginlib \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
    voxel-grid \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    costmap-2d \
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
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
    voxel-grid \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    costmap-2d \
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
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
    voxel-grid \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/nonpersistent_voxel_layer-release/archive/release/noetic/nonpersistent_voxel_layer/1.3.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/nonpersistent_voxel_layer"
SRC_URI = "git://github.com/SteveMacenski/nonpersistent_voxel_layer-release;${ROS_BRANCH};protocol=https"
SRCREV = "a77995d5fa53690d9bcb4336038a5a91779b03da"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
