# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "This package allows you to publish the state of a robot to     <a href="http://wiki.ros.org/tf2">tf2</a>. Once the state gets published, it is     available to all components in the system that also use <tt>tf2</tt>.     The package takes the joint angles of the robot as input     and publishes the 3D poses of the robot links, using a kinematic     tree model of the robot."
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Karsten Knese <karsten@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "robot_state_publisher"
ROS_BPN = "robot_state_publisher"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    kdl-parser \
    orocos-kdl \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
    tf2-ros \
    urdf \
    urdfdom-headers \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    kdl-parser \
    orocos-kdl \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
    tf2-ros \
    urdf \
    urdfdom-headers \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    launch-ros \
    launch-testing-ament-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/robot_state_publisher-release/archive/release/rolling/robot_state_publisher/2.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/robot_state_publisher"
SRC_URI = "git://github.com/ros2-gbp/robot_state_publisher-release;${ROS_BRANCH};protocol=https"
SRCREV = "572d8817426dbb0485f95ef1d84cd3b3ecb09112"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
