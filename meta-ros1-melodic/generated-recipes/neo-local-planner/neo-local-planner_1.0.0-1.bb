# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package provides a spline based implementation to local robot navigation on a plane.  		This package's ROS wrapper adheres to the         BaseLocalPlanner interface specified in the <a href="http://wiki.ros.org/nav_core">nav_core</a> package."
AUTHOR = "Neobotix GmbH <ros@neobotix.de>"
ROS_AUTHOR = "Max Wittal"
HOMEPAGE = "http://wiki.ros.org/base_local_planner"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "neo_local_planner"
ROS_BPN = "neo_local_planner"

ROS_BUILD_DEPENDS = " \
    base-local-planner \
    cmake-modules \
    costmap-2d \
    dynamic-reconfigure \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    base-local-planner \
    costmap-2d \
    dynamic-reconfigure \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    base-local-planner \
    costmap-2d \
    dynamic-reconfigure \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/neobotix/neo_local_planner-release/archive/release/melodic/neo_local_planner/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/neo_local_planner"
SRC_URI = "git://github.com/neobotix/neo_local_planner-release;${ROS_BRANCH};protocol=https"
SRCREV = "7ce6654fdc632c10c1dec60ab3ddd878305f6032"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
