# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Broadcaster to publish the requested hardware interface states"
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Sai Kishor Kothakota <sai.kishor@pal-robotics.com>"
HOMEPAGE = "https://control.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "state_interfaces_broadcaster"
ROS_BPN = "state_interfaces_broadcaster"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    backward-ros\
    control-msgs\
    controller-interface\
    generate-parameter-library\
    pluginlib\
    rclcpp-lifecycle\
    rclcpp\
    realtime-tools\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    backward-ros\
    control-msgs\
    controller-interface\
    generate-parameter-library\
    pluginlib\
    rclcpp-lifecycle\
    rclcpp\
    realtime-tools\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    backward-ros\
    control-msgs\
    controller-interface\
    generate-parameter-library\
    pluginlib\
    rclcpp-lifecycle\
    rclcpp\
    realtime-tools\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    controller-manager\
    hardware-interface\
    ros2-control-test-assets\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=rpm/jazzy/state_interfaces_broadcaster"
SRC_URI = "git://github.com/ros2-gbp/ros2_controllers-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "0c595b398d11b2ba6dfcdd53dcb8a54db83b5e95"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
