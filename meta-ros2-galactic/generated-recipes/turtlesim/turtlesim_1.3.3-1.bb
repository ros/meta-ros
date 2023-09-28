# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "turtlesim is a tool made for teaching ROS and ROS packages."
AUTHOR = "Mabel Zhang <mabel@openrobotics.org>"
ROS_AUTHOR = "Josh Faust"
HOMEPAGE = "http://www.ros.org/wiki/turtlesim"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "turtlesim"
ROS_BPN = "turtlesim"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    geometry-msgs \
    qtbase \
    rclcpp \
    rclcpp-action \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    geometry-msgs \
    rclcpp \
    rclcpp-action \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    geometry-msgs \
    qtbase \
    rclcpp \
    rclcpp-action \
    rosidl-default-runtime \
    std-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros_tutorials-release/archive/release/galactic/turtlesim/1.3.3-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/turtlesim"
SRC_URI = "git://github.com/ros2-gbp/ros_tutorials-release;${ROS_BRANCH};protocol=https"
SRCREV = "19e8f866a1fbbe05b678c2302d71f62f17b46b8d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
