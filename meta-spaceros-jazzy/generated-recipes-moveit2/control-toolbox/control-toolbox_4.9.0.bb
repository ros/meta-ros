# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "The control toolbox contains modules that are useful across all controllers."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Melonee Wise"
HOMEPAGE = "https://control.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "control_toolbox"
ROS_BPN = "control_toolbox"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    backward-ros\
    control-msgs\
    libeigen\
    filters\
    generate-parameter-library\
    geometry-msgs\
    pluginlib\
    rclcpp\
    rcutils\
    realtime-tools\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    fmt\
    backward-ros\
    control-msgs\
    libeigen\
    filters\
    generate-parameter-library\
    geometry-msgs\
    pluginlib\
    rclcpp\
    rcutils\
    realtime-tools\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    backward-ros\
    control-msgs\
    libeigen\
    filters\
    generate-parameter-library\
    geometry-msgs\
    pluginlib\
    rclcpp\
    rcutils\
    realtime-tools\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    rclcpp-lifecycle\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/control_toolbox"
SRC_URI = "git://github.com/ros2-gbp/control_toolbox-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "7ee1b76902434b1e85dbd2afa4ddea50f4b461ed"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
