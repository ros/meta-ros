# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "This package implements the franka gripper of type Franka Hand for the use in ROS2"
AUTHOR = "Franka Robotics GmbH <support@franka.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "franka_ros2"
ROS_BPN = "franka_gripper"

ROS_BUILD_DEPENDS = " \
    control-msgs \
    franka-msgs \
    libfranka \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
"

ROS_EXPORT_DEPENDS = " \
    control-msgs \
    franka-msgs \
    libfranka \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    control-msgs \
    franka-msgs \
    libfranka \
    rclcpp \
    rclcpp-action \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-clang-format \
    ament-cmake-copyright \
    ament-cmake-cppcheck \
    ament-cmake-flake8 \
    ament-cmake-lint-cmake \
    ament-cmake-pep257 \
    ament-cmake-xmllint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/franka_ros2-release/archive/release/humble/franka_gripper/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/franka_gripper"
SRC_URI = "git://github.com/ros2-gbp/franka_ros2-release;${ROS_BRANCH};protocol=https"
SRCREV = "98e20cc91ea253c5e2b975e5e3aa91a2afd9ec57"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
