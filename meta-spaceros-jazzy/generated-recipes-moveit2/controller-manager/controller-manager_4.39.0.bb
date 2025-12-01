# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "The main runnable entrypoint of ros2_control and home of controller management and resource management."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "controller_manager"
ROS_BPN = "controller_manager"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    backward-ros\
    controller-interface\
    controller-manager-msgs\
    diagnostic-updater\
    hardware-interface\
    launch\
    launch-ros\
    pluginlib\
    rclcpp\
    rcpputils\
    realtime-tools\
    ros2-control-test-assets\
    ros2param\
    ros2run\
    std-msgs\
    libstatistics-collector\
    generate-parameter-library\
    fmt\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-gen-version-h-native\
    ament-cmake-python-native\
"

ROS_EXPORT_DEPENDS = "\
    backward-ros\
    controller-interface\
    controller-manager-msgs\
    diagnostic-updater\
    hardware-interface\
    launch\
    launch-ros\
    pluginlib\
    rclcpp\
    rcpputils\
    realtime-tools\
    ros2-control-test-assets\
    ros2param\
    ros2run\
    std-msgs\
    libstatistics-collector\
    generate-parameter-library\
    fmt\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    python3-filelock\
    backward-ros\
    controller-interface\
    controller-manager-msgs\
    diagnostic-updater\
    hardware-interface\
    launch\
    launch-ros\
    pluginlib\
    rclcpp\
    rcpputils\
    realtime-tools\
    ros2-control-test-assets\
    ros2param\
    ros2run\
    std-msgs\
    libstatistics-collector\
    generate-parameter-library\
    fmt\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    ament-cmake-pytest\
    hardware-interface-testing\
    launch-testing-ros\
    launch-testing\
    launch\
    python3-coverage\
    rclpy\
    robot-state-publisher\
    ros2-control-test-assets\
    sensor-msgs\
    example-interfaces\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/controller_manager"
SRC_URI = "git://github.com/ros2-gbp/ros2_control-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "031c1dc462079efa926299251cae1b1154a011c2"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
