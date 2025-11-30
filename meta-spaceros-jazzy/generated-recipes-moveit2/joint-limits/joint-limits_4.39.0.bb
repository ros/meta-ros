# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Package with interfaces for handling of joint limits in controllers or in hardware. The package also implements Saturation Joint Limiter for position-velocity-acceleration set and other individual interfaces."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
HOMEPAGE = "https://github.com/ros-controls/ros2_control/wiki"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "joint_limits"
ROS_BPN = "joint_limits"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    backward-ros\
    pluginlib\
    realtime-tools\
    rclcpp\
    rclcpp-lifecycle\
    trajectory-msgs\
    urdf\
    fmt\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-gen-version-h-native\
"

ROS_EXPORT_DEPENDS = "\
    backward-ros\
    pluginlib\
    realtime-tools\
    rclcpp\
    rclcpp-lifecycle\
    trajectory-msgs\
    urdf\
    fmt\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    backward-ros\
    pluginlib\
    realtime-tools\
    rclcpp\
    rclcpp-lifecycle\
    trajectory-msgs\
    urdf\
    fmt\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    generate-parameter-library\
    launch-ros\
    launch-testing-ament-cmake\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/joint_limits"
SRC_URI = "git://github.com/ros2-gbp/ros2_control-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "20d4dabcf1df5515f2b04926b01e4644004fc6f7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
