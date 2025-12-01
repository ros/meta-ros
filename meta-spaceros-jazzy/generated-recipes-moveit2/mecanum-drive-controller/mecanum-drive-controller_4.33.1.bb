# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Implementation of mecanum drive controller for 4 wheel drive."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Dr.-Ing. Denis Štogl <denis.stogl@stoglrobotics.de>"
HOMEPAGE = "https://control.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "mecanum_drive_controller"
ROS_BPN = "mecanum_drive_controller"

ROS_BUILD_DEPENDS = "\
    generate-parameter-library\
    ros2-control-cmake\
    backward-ros\
    control-msgs\
    controller-interface\
    geometry-msgs\
    hardware-interface\
    nav-msgs\
    pluginlib\
    rclcpp\
    rclcpp-lifecycle\
    realtime-tools\
    rcpputils\
    std-srvs\
    tf2\
    tf2-geometry-msgs\
    tf2-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    backward-ros\
    control-msgs\
    controller-interface\
    geometry-msgs\
    hardware-interface\
    nav-msgs\
    pluginlib\
    rclcpp\
    rclcpp-lifecycle\
    realtime-tools\
    rcpputils\
    std-srvs\
    tf2\
    tf2-geometry-msgs\
    tf2-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    backward-ros\
    control-msgs\
    controller-interface\
    geometry-msgs\
    hardware-interface\
    nav-msgs\
    pluginlib\
    rclcpp\
    rclcpp-lifecycle\
    realtime-tools\
    rcpputils\
    std-srvs\
    tf2\
    tf2-geometry-msgs\
    tf2-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    controller-manager\
    hardware-interface-testing\
    ros2-control-test-assets\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/mecanum_drive_controller"
SRC_URI = "git://github.com/ros2-gbp/ros2_controllers-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "2f7105b1998453ebf593f1ec227a481e243cd716"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
