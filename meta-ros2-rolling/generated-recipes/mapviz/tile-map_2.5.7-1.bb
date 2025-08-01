# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Tile map provides a slippy map style interface for visualizing       OpenStreetMap and GoogleMap tiles.  A mapviz visualization plug-in is also      implemented"
AUTHOR = "Southwest Research Institute <swri-robotics@swri.org>"
ROS_AUTHOR = "Marc Alban"
HOMEPAGE = "https://github.com/swri-robotics/mapviz"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mapviz"
ROS_BPN = "tile_map"

ROS_BUILD_DEPENDS = " \
    glew \
    jsoncpp \
    mapviz \
    pluginlib \
    qtbase \
    rclcpp \
    swri-math-util \
    swri-transform-util \
    tf2 \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    qtbase-native \
"

ROS_EXPORT_DEPENDS = " \
    glew \
    mapviz \
    pluginlib \
    qtbase \
    rclcpp \
    swri-math-util \
    swri-transform-util \
    tf2 \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    glew \
    jsoncpp \
    mapviz \
    pluginlib \
    qtbase \
    rclcpp \
    swri-math-util \
    swri-transform-util \
    tf2 \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mapviz-release/archive/release/rolling/tile_map/2.5.7-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/tile_map"
SRC_URI = "git://github.com/ros2-gbp/mapviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "d705b71c6af77e72154ade863711dbcb3f3819e6"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
