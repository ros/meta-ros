# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Utility functions for displaying and debugging data in Rviz via published markers"
AUTHOR = "Mike Lautman <mike@picknik.ai>"
ROS_AUTHOR = "Mike Lautman <mike@picknik.ai>"
HOMEPAGE = "https://github.com/PickNikRobotics/rviz_visual_tools"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz_visual_tools"
ROS_BPN = "rviz_visual_tools"

ROS_BUILD_DEPENDS = " \
    eigen-stl-containers \
    geometry-msgs \
    interactive-markers \
    libeigen \
    pluginlib \
    qtbase \
    rclcpp \
    rclcpp-components \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    trajectory-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    eigen3-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    eigen-stl-containers \
    geometry-msgs \
    interactive-markers \
    libeigen \
    pluginlib \
    rclcpp \
    rclcpp-components \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    trajectory-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    eigen3-cmake-module-native \
"

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    eigen-stl-containers \
    geometry-msgs \
    interactive-markers \
    launch \
    launch-ros \
    pluginlib \
    qtbase \
    rclcpp \
    rclcpp-components \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    rviz2 \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    trajectory-msgs \
    visualization-msgs \
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

# matches with: https://github.com/ros2-gbp/rviz_visual_tools-release/archive/release/jazzy/rviz_visual_tools/4.1.4-4.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/rviz_visual_tools"
SRC_URI = "git://github.com/ros2-gbp/rviz_visual_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "2e05b97387c407ea702931822cc02c3f29dea126"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
