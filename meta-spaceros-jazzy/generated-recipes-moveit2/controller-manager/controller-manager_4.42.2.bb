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
    fmt\
    generate-parameter-library\
    hardware-interface\
    libstatistics-collector\
    lifecycle-msgs\
    pluginlib\
    rclcpp\
    realtime-tools\
    std-msgs\
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
    fmt\
    generate-parameter-library\
    hardware-interface\
    libstatistics-collector\
    lifecycle-msgs\
    pluginlib\
    rclcpp\
    realtime-tools\
    std-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    launch-ros\
    launch-testing-ros\
    launch\
    python3-filelock\
    python3-pyyaml\
    rcl-interfaces\
    rclpy\
    ros2param\
    sensor-msgs\
    backward-ros\
    controller-interface\
    controller-manager-msgs\
    diagnostic-updater\
    fmt\
    generate-parameter-library\
    hardware-interface\
    libstatistics-collector\
    lifecycle-msgs\
    pluginlib\
    rclcpp\
    realtime-tools\
    std-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    ament-cmake-pytest\
    example-interfaces\
    hardware-interface-testing\
    launch-testing\
    python3-coverage\
    robot-state-publisher\
    ros2-control-test-assets\
    ros2pkg\
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
SRCREV = "1414de8a7f6b053168048146f9e4b6d79c414c15"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
