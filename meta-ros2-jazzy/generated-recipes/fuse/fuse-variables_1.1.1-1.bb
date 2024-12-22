# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "The fuse_variables package provides a set of commonly used variable types, such as 2D and 3D positions, \     orientations, velocities, and accelerations."
AUTHOR = "Stephen Williams <swilliams@locusrobotics.com>"
ROS_AUTHOR = "Stephen Williams <swilliams@locusrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fuse"
ROS_BPN = "fuse_variables"

ROS_BUILD_DEPENDS = " \
    ceres-solver \
    fuse-core \
    pluginlib \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ceres-solver \
    fuse-core \
    pluginlib \
    rclcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    rclcpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/fuse-release/archive/release/jazzy/fuse_variables/1.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/fuse_variables"
SRC_URI = "git://github.com/ros2-gbp/fuse-release;${ROS_BRANCH};protocol=https"
SRCREV = "145adf8242958fb6fcd560f0dd2290831f56b5c3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
