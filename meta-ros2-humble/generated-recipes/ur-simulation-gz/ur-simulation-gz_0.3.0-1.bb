# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Example and configuration files for Gazebo simulation of UR manipulators."
AUTHOR = "Felix Exner <feex@universal-robots.com>"
ROS_AUTHOR = "Lovro Ivanov"
HOMEPAGE = "https://github.com/UniversalRobots/Universal_Robots_ROS2_Ignition_Simulation/issues"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "ur_simulation_gz"
ROS_BPN = "ur_simulation_gz"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ign-ros2-control \
    joint-state-publisher \
    launch \
    launch-ros \
    ros-gz-bridge \
    ros-gz-sim \
    rviz2 \
    ur-controllers \
    ur-description \
    ur-moveit-config \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-pytest \
    launch-testing-ament-cmake \
    launch-testing-ros \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ur_simulation_gz-release/archive/release/humble/ur_simulation_gz/0.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/ur_simulation_gz"
SRC_URI = "git://github.com/ros2-gbp/ur_simulation_gz-release;${ROS_BRANCH};protocol=https"
SRCREV = "abf1bca513c1c87dc78891f7cdd038502539aa2a"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
