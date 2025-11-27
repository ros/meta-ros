# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "This package take the joint angles of a robot as input, and publishes the 3D poses of the robot links to tf2, using a kinematic tree model of the robot."
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Karsten Knese <karsten@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "robot_state_publisher"
ROS_BPN = "robot_state_publisher"

ROS_BUILD_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    kdl-parser\
    orocos-kdl-vendor\
    rcl-interfaces\
    rclcpp\
    rclcpp-components\
    sensor-msgs\
    std-msgs\
    tf2-ros\
    urdf\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    kdl-parser\
    orocos-kdl-vendor\
    rcl-interfaces\
    rclcpp\
    rclcpp-components\
    sensor-msgs\
    std-msgs\
    tf2-ros\
    urdf\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    kdl-parser\
    orocos-kdl-vendor\
    rcl-interfaces\
    rclcpp\
    rclcpp-components\
    sensor-msgs\
    std-msgs\
    tf2-ros\
    urdf\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-common\
    launch-ros\
    launch-testing-ament-cmake\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros/robot_state_publisher.git;${ROS_BRANCH};protocol=https"
SRCREV = "e0f77e62457ae01f8dbf3b5c4cc62d15fa36dfad"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
