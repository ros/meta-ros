# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Helper functions for displaying and debugging MoveIt data in Rviz via published markers"
AUTHOR = "Dave Coleman <dave@picknik.ai>"
ROS_AUTHOR = "Dave Coleman <dave@picknik.ai>"
HOMEPAGE = "https://github.com/ros-planning/moveit_visual_tools"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit_visual_tools"
ROS_BPN = "moveit_visual_tools"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    graph-msgs \
    moveit-common \
    moveit-core \
    moveit-ros-planning \
    rclcpp \
    rviz-visual-tools \
    std-msgs \
    tf2-eigen \
    tf2-ros \
    trajectory-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    graph-msgs \
    moveit-common \
    moveit-core \
    moveit-ros-planning \
    rclcpp \
    rviz-visual-tools \
    std-msgs \
    tf2-eigen \
    tf2-ros \
    trajectory-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    graph-msgs \
    moveit-common \
    moveit-core \
    moveit-ros-planning \
    rclcpp \
    rviz-visual-tools \
    std-msgs \
    tf2-eigen \
    tf2-ros \
    trajectory-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/moveit/moveit_visual_tools-release/archive/release/rolling/moveit_visual_tools/4.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/moveit_visual_tools"
SRC_URI = "git://github.com/moveit/moveit_visual_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "9f4c9d4e91a4b76439b42c7bee9db034b096ad76"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
