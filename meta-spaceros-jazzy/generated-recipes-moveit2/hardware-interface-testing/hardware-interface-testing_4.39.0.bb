# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Commonly used test fixtures for the ros2_control framework"
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "hardware_interface_testing"
ROS_BPN = "hardware_interface_testing"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    control-msgs\
    hardware-interface\
    lifecycle-msgs\
    pluginlib\
    rclcpp-lifecycle\
    ros2-control-test-assets\
    fmt\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    control-msgs\
    hardware-interface\
    lifecycle-msgs\
    pluginlib\
    rclcpp-lifecycle\
    ros2-control-test-assets\
    fmt\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    control-msgs\
    hardware-interface\
    lifecycle-msgs\
    pluginlib\
    rclcpp-lifecycle\
    ros2-control-test-assets\
    fmt\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/hardware_interface_testing"
SRC_URI = "git://github.com/ros2-gbp/ros2_control-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "7fe0b024f8583ccee58c57425c0f360f9b70c615"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
