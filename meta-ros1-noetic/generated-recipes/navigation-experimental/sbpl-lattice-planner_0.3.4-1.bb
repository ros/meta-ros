# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The sbpl_lattice_planner is a global planner plugin for move_base and wraps     the SBPL search-based planning library."
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
ROS_AUTHOR = "Michael Phillips"
HOMEPAGE = "http://wiki.ros.org/sbpl_lattice_planner"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "navigation_experimental"
ROS_BPN = "sbpl_lattice_planner"

ROS_BUILD_DEPENDS = " \
    costmap-2d \
    geometry-msgs \
    message-generation \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    sbpl \
    tf2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    costmap-2d \
    geometry-msgs \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    sbpl \
    tf2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    costmap-2d \
    geometry-msgs \
    message-runtime \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    sbpl \
    tf2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/navigation_experimental-release/archive/release/noetic/sbpl_lattice_planner/0.3.4-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/sbpl_lattice_planner"
SRC_URI = "git://github.com/ros-gbp/navigation_experimental-release;${ROS_BRANCH};protocol=https"
SRCREV = "7df1a78648af44ec795dcbe1eb6b7a7eaa9e9b21"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
