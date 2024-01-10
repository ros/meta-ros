# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Bringup package for Leo Rover Gazebo simulation in ROS 2"
AUTHOR = "Fictionlab <support@fictionlab.pl>"
ROS_AUTHOR = "Jan Hernas <janek@fictionlab.pl>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "leo_simulator"
ROS_BPN = "leo_gz_bringup"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    leo-gz-plugins \
    leo-gz-worlds \
    robot-state-publisher \
    ros-gz-bridge \
    ros-gz-image \
    ros-gz-sim \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-black \
    ament-cmake-copyright \
    ament-cmake-lint-cmake \
    ament-cmake-mypy \
    ament-cmake-xmllint \
    ament-lint-auto \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/leo_simulator-release/archive/release/humble/leo_gz_bringup/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/leo_gz_bringup"
SRC_URI = "git://github.com/ros2-gbp/leo_simulator-release;${ROS_BRANCH};protocol=https"
SRCREV = "cd3c3c993ae5f99efb2dd69bf6f1edc616da9682"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
