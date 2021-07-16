# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "ROS2 version of the robot_state_publisher package"
AUTHOR = "Karsten Knese <karsten@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "robot_state_publisher"
ROS_BPN = "robot_state_publisher"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    kdl-parser \
    orocos-kdl \
    rclcpp \
    sensor-msgs \
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
    geometry-msgs \
    kdl-parser \
    orocos-kdl \
    rclcpp \
    sensor-msgs \
    tf2-ros \
    urdf \
    urdfdom-headers \
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

# matches with: https://github.com/ros2-gbp/robot_state_publisher-release/archive/release/dashing/robot_state_publisher/2.2.5-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/robot_state_publisher"
SRC_URI = "git://github.com/ros2-gbp/robot_state_publisher-release;${ROS_BRANCH};protocol=https"
SRCREV = "c2e6e5ae2cc258e91e41d56f1d557fac59072a4f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
