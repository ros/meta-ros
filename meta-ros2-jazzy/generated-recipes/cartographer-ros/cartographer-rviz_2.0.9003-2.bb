# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Cartographer is a system that provides real-time simultaneous localization     and mapping (SLAM) in 2D and 3D across multiple platforms and sensor     configurations. This package provides Cartographer's RViz integration."
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "The Cartographer Authors <google-cartographer@googlegroups.com>"
HOMEPAGE = "https://github.com/cartographer-project/cartographer_ros"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=b73cebba72f83c5afebf178817283e37"

ROS_CN = "cartographer_ros"
ROS_BPN = "cartographer_rviz"

ROS_BUILD_DEPENDS = " \
    abseil-cpp \
    boost \
    cartographer \
    cartographer-ros \
    cartographer-ros-msgs \
    libeigen \
    pluginlib \
    rclcpp \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    abseil-cpp \
    boost \
    cartographer \
    cartographer-ros \
    cartographer-ros-msgs \
    libeigen \
    pluginlib \
    rclcpp \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    abseil-cpp \
    boost \
    cartographer \
    cartographer-ros \
    cartographer-ros-msgs \
    libeigen \
    pluginlib \
    rclcpp \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/cartographer_ros-release/archive/release/jazzy/cartographer_rviz/2.0.9003-2.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/cartographer_rviz"
SRC_URI = "git://github.com/ros2-gbp/cartographer_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "c0528e46728174c2c4893a6bbf43fe87ba86f2e5"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
