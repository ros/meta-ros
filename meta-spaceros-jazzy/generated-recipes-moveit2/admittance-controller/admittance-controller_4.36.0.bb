# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Implementation of admittance controllers for different input and output interface."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Denis Štogl <denis@stogl.de>"
HOMEPAGE = "https://control.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "admittance_controller"
ROS_BPN = "admittance_controller"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    angles\
    backward-ros\
    control-msgs\
    control-toolbox\
    controller-interface\
    generate-parameter-library\
    geometry-msgs\
    hardware-interface\
    kinematics-interface\
    pluginlib\
    rclcpp-lifecycle\
    rclcpp\
    realtime-tools\
    tf2-eigen\
    tf2-geometry-msgs\
    tf2-kdl\
    tf2-ros\
    tf2\
    trajectory-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    angles\
    backward-ros\
    control-msgs\
    control-toolbox\
    controller-interface\
    generate-parameter-library\
    geometry-msgs\
    hardware-interface\
    kinematics-interface\
    pluginlib\
    rclcpp-lifecycle\
    rclcpp\
    realtime-tools\
    tf2-eigen\
    tf2-geometry-msgs\
    tf2-kdl\
    tf2-ros\
    tf2\
    trajectory-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    angles\
    backward-ros\
    control-msgs\
    control-toolbox\
    controller-interface\
    generate-parameter-library\
    geometry-msgs\
    hardware-interface\
    kinematics-interface\
    pluginlib\
    rclcpp-lifecycle\
    rclcpp\
    realtime-tools\
    tf2-eigen\
    tf2-geometry-msgs\
    tf2-kdl\
    tf2-ros\
    tf2\
    trajectory-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    controller-manager\
    hardware-interface-testing\
    kinematics-interface-kdl\
    ros2-control-test-assets\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/admittance_controller"
SRC_URI = "git://github.com/ros2-gbp/ros2_controllers-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "ebe492cdf7b753127b77a5c5f73a87b4bbba598b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
