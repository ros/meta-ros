# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Package with interfaces for handling of joint limits in controllers or in hardware. The package also implements Saturation Joint Limiter for position-velocity-acceleration set and other individual interfaces."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
HOMEPAGE = "https://github.com/ros-controls/ros2_control/wiki"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2_control"
ROS_BPN = "joint_limits"

ROS_BUILD_DEPENDS = " \
    backward-ros \
    fmt \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    ros2-control-cmake \
    trajectory-msgs \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-gen-version-h-native \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    backward-ros \
    fmt \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    trajectory-msgs \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    backward-ros \
    fmt \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    trajectory-msgs \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    generate-parameter-library \
    launch-ros \
    launch-testing-ament-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2_control-release/archive/release/jazzy/joint_limits/4.32.0-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/joint_limits"
SRC_URI = "git://github.com/ros2-gbp/ros2_control-release;${ROS_BRANCH};protocol=https"
SRCREV = "a50200bec5c5582ebaf2760faac41ee6cb93aa41"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
