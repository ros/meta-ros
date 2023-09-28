# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Utility functions for displaying and debugging data in Rviz via published markers"
AUTHOR = "Dave Coleman <davetcoleman@gmail.com>"
ROS_AUTHOR = "Dave Coleman <dave@picknik.ai>"
HOMEPAGE = "https://github.com/davetcoleman/rviz_visual_tools"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz_visual_tools"
ROS_BPN = "rviz_visual_tools"

ROS_BUILD_DEPENDS = " \
    eigen-stl-containers \
    geometry-msgs \
    graph-msgs \
    interactive-markers \
    ogre \
    qtx11extras \
    roscpp \
    roslint \
    rviz \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    trajectory-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    eigen-stl-containers \
    geometry-msgs \
    graph-msgs \
    interactive-markers \
    ogre \
    qtx11extras \
    roscpp \
    roslint \
    rviz \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    trajectory-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    eigen-stl-containers \
    geometry-msgs \
    graph-msgs \
    interactive-markers \
    ogre \
    qtx11extras \
    roscpp \
    roslint \
    rviz \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    trajectory-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/PickNikRobotics/rviz_visual_tools-release/archive/release/noetic/rviz_visual_tools/3.9.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rviz_visual_tools"
SRC_URI = "git://github.com/PickNikRobotics/rviz_visual_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "223918ba7ff16cc9d63808c38f05e77cdbf39dcc"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
