# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Controller for executing joint-space trajectories on a group of joints"
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
HOMEPAGE = "https://control.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2_controllers"
ROS_BPN = "joint_trajectory_controller"

ROS_BUILD_DEPENDS = " \
    angles \
    backward-ros \
    control-msgs \
    control-toolbox \
    controller-interface \
    generate-parameter-library \
    hardware-interface \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    rsl \
    tl-expected \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    backward-ros \
    control-msgs \
    control-toolbox \
    controller-interface \
    generate-parameter-library \
    hardware-interface \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    rsl \
    tl-expected \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    backward-ros \
    control-msgs \
    control-toolbox \
    controller-interface \
    generate-parameter-library \
    hardware-interface \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    rsl \
    tl-expected \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    controller-manager \
    hardware-interface-testing \
    ros2-control-test-assets \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2_controllers-release/archive/release/humble/joint_trajectory_controller/2.47.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/joint_trajectory_controller"
SRC_URI = "git://github.com/ros2-gbp/ros2_controllers-release;${ROS_BRANCH};protocol=https"
SRCREV = "aa1cc821422b18e2fc4034945c45d311c3482c07"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
