# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "A package to aggregate the packages required to use publish / subscribe, services, generate messages and other core ROS concepts."
AUTHOR = "Steven! Ragnarök <steven@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "variants"
ROS_BPN = "ros_core"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake \
    ament-cmake-auto \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-cmake-ros \
    ament-index-cpp \
    ament-index-python \
    ament-lint-auto \
    ament-lint-common \
    class-loader \
    common-interfaces \
    pluginlib \
    rcl-lifecycle \
    rclcpp \
    rclcpp-lifecycle \
    rclpy \
    ros-environment \
    ros2action \
    ros2component \
    ros2doctor \
    ros2interface \
    ros2launch \
    ros2lifecycle \
    ros2msg \
    ros2multicast \
    ros2node \
    ros2param \
    ros2pkg \
    ros2run \
    ros2service \
    ros2srv \
    ros2topic \
    rosidl-default-generators \
    rosidl-default-runtime \
    sros2 \
    sros2-cmake \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/variants-release/archive/release/eloquent/ros_core/0.8.4-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/ros_core"
SRC_URI = "git://github.com/ros2-gbp/variants-release;${ROS_BRANCH};protocol=https"
SRCREV = "93f9fe4ba217f78489460f66f3d7e564a3520ccd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
