# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "ros2_control hardware interface for Feetech Servos"
AUTHOR = "Jafar Uruc <jafar.uruc@gmail.com>"
HOMEPAGE = "https://github.com/JafarAbdi/feetech_ros2_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "feetech_ros2_driver"
ROS_BPN = "feetech_ros2_driver"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libserial-dev} \
    fmt \
    hardware-interface \
    pkgconfig \
    pluginlib \
    range-v3 \
    rclcpp \
    spdlog \
    tl-expected \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libserial-dev} \
    fmt \
    hardware-interface \
    pkgconfig \
    pluginlib \
    range-v3 \
    rclcpp \
    spdlog \
    tl-expected \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libserial-dev} \
    fmt \
    hardware-interface \
    pkgconfig \
    pluginlib \
    range-v3 \
    rclcpp \
    spdlog \
    tl-expected \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/feetech_ros2_driver-release/archive/release/rolling/feetech_ros2_driver/0.1.0-2.tar.gz
ROS_BRANCH ?= "branch=release/rolling/feetech_ros2_driver"
SRC_URI = "git://github.com/ros2-gbp/feetech_ros2_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "c619e79809de4c3c96c1cace062704ab4b572935"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
