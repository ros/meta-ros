# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Plugin based global planner implementing the nav_core2::GlobalPlanner interface."
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "robot_navigation"
ROS_BPN = "dlux_global_planner"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core2 \
    nav-grid \
    nav-grid-pub-sub \
    nav-msgs \
    pluginlib \
    roscpp \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core2 \
    nav-grid \
    nav-grid-pub-sub \
    nav-msgs \
    pluginlib \
    roscpp \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core2 \
    nav-grid \
    nav-grid-pub-sub \
    nav-msgs \
    pluginlib \
    roscpp \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslint \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DLu/robot_navigation-release/archive/release/noetic/dlux_global_planner/0.3.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/dlux_global_planner"
SRC_URI = "git://github.com/DLu/robot_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "1c755a38b211e1c02582dc4b4e5a496caa930113"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
