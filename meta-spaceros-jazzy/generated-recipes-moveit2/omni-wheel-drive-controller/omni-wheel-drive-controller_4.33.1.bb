# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    A chainable controller for mobile robots with omnidirectional drive with three or\
    more omni wheels.\
"
AUTHOR = "Aarav Gupta <aarav@spikonado.com>"
ROS_AUTHOR = "Aarav Gupta <aarav@spikonado.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "omni_wheel_drive_controller"
ROS_BPN = "omni_wheel_drive_controller"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    generate-parameter-library\
    controller-interface\
    libeigen\
    geometry-msgs\
    hardware-interface\
    nav-msgs\
    pluginlib\
    rclcpp\
    rclcpp-lifecycle\
    realtime-tools\
    tf2\
    tf2-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    generate-parameter-library\
    controller-interface\
    libeigen\
    geometry-msgs\
    hardware-interface\
    nav-msgs\
    pluginlib\
    rclcpp\
    rclcpp-lifecycle\
    realtime-tools\
    tf2\
    tf2-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    generate-parameter-library\
    controller-interface\
    libeigen\
    geometry-msgs\
    hardware-interface\
    nav-msgs\
    pluginlib\
    rclcpp\
    rclcpp-lifecycle\
    realtime-tools\
    tf2\
    tf2-msgs\
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

ROS_BRANCH ?= "branch=release/jazzy/omni_wheel_drive_controller"
SRC_URI = "git://github.com/ros2-gbp/ros2_controllers-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "d9fbcbce1ec7d40a757cfe566d95e6532169a2de"
S = "${WORKDIR}/git/omni_wheel_drive_controller"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
