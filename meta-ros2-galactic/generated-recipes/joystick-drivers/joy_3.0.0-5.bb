# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "The joy package contains joy_node, a node that interfaces a     generic joystick to ROS 2. This node publishes a &quot;Joy&quot;     message, which contains the current state of each one of the     joystick's buttons and axes."
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Mikael Arguedas"
HOMEPAGE = "https://github.com/ros2/joystick_drivers"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "joystick_drivers"
ROS_BPN = "joy"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sdl2-vendor \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sdl2-vendor \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sdl2-vendor \
    sensor-msgs \
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

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/joystick_drivers-release/archive/release/galactic/joy/3.0.0-5.tar.gz
ROS_BRANCH ?= "branch=release/galactic/joy"
SRC_URI = "git://github.com/ros2-gbp/joystick_drivers-release;${ROS_BRANCH};protocol=https"
SRCREV = "861bffb4e61a0c12fa1bc1ba161c381ee43d787b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
