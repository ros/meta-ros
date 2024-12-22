# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "turtlesim is a tool made for teaching ROS and ROS packages."
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "Audrow Nash <audrow@openrobotics.org>"
HOMEPAGE = "http://www.ros.org/wiki/turtlesim"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_tutorials"
ROS_BPN = "turtlesim"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    geometry-msgs \
    qtbase \
    rclcpp \
    rclcpp-action \
    std-msgs \
    std-srvs \
    turtlesim-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    geometry-msgs \
    rclcpp \
    rclcpp-action \
    std-msgs \
    std-srvs \
    turtlesim-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    geometry-msgs \
    qtbase \
    rclcpp \
    rclcpp-action \
    std-msgs \
    std-srvs \
    turtlesim-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros_tutorials-release/archive/release/rolling/turtlesim/1.9.2-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/turtlesim"
SRC_URI = "git://github.com/ros2-gbp/ros_tutorials-release;${ROS_BRANCH};protocol=https"
SRCREV = "4fa7d0da6427665fa4540503b0c5bc5cf85314db"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
