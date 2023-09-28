# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "<p>      ROS Industrial libraries/plugins for filtering trajectories.    </p>    <p>      This package is part of the ROS Industrial program and contains libraries      and moveit plugins for filtering robot trajectories.    </p>"
AUTHOR = "G.A. vd. Hoorn (TU Delft Robotics Institute) <g.a.vanderhoorn@tudelft.nl>"
ROS_AUTHOR = "Shaun Edwards"
HOMEPAGE = "http://ros.org/wiki/industrial_trajectory_filters"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "industrial_core"
ROS_BPN = "industrial_trajectory_filters"

ROS_BUILD_DEPENDS = " \
    class-loader \
    moveit-core \
    moveit-ros-planning \
    orocos-kdl \
    pluginlib \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    class-loader \
    moveit-core \
    moveit-ros-planning \
    orocos-kdl \
    pluginlib \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    class-loader \
    moveit-core \
    moveit-ros-planning \
    orocos-kdl \
    pluginlib \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/industrial_core-release/archive/release/melodic/industrial_trajectory_filters/0.7.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/industrial_trajectory_filters"
SRC_URI = "git://github.com/ros-industrial-release/industrial_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "0a8d564f14544a2464cc19b49c9d1bcd59844d4d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
