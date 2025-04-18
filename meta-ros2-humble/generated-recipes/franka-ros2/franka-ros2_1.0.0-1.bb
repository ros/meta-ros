# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Meta package of franka_ros2"
AUTHOR = "Franka Robotics GmbH <support@franka.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "franka_ros2"
ROS_BPN = "franka_ros2"

ROS_BUILD_DEPENDS = " \
    franka-bringup \
    franka-description \
    franka-example-controllers \
    franka-fr3-moveit-config \
    franka-gazebo-bringup \
    franka-gripper \
    franka-hardware \
    franka-ign-ros2-control \
    franka-msgs \
    libfranka \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    franka-bringup \
    franka-description \
    franka-example-controllers \
    franka-fr3-moveit-config \
    franka-gazebo-bringup \
    franka-gripper \
    franka-hardware \
    franka-ign-ros2-control \
    franka-msgs \
    libfranka \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    franka-bringup \
    franka-description \
    franka-example-controllers \
    franka-fr3-moveit-config \
    franka-gazebo-bringup \
    franka-gripper \
    franka-hardware \
    franka-ign-ros2-control \
    franka-msgs \
    libfranka \
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

# matches with: https://github.com/ros2-gbp/franka_ros2-release/archive/release/humble/franka_ros2/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/franka_ros2"
SRC_URI = "git://github.com/ros2-gbp/franka_ros2-release;${ROS_BRANCH};protocol=https"
SRCREV = "d47aaabdb3ef2d56f4534883d3a9ab0172a84cf9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
