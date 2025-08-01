# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "A ROS driver for Puma single-channel motor control board."
AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "puma_motor_driver"
ROS_BPN = "puma_motor_driver"

ROS_BUILD_DEPENDS = " \
    clearpath-socketcan-interface \
    diagnostic-updater \
    puma-motor-msgs \
    rclcpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    clearpath-socketcan-interface \
    diagnostic-updater \
    puma-motor-msgs \
    rclcpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-utils \
    clearpath-socketcan-interface \
    diagnostic-updater \
    joy \
    puma-motor-msgs \
    rclcpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/clearpath-gbp/puma_motor_driver-release/archive/release/humble/puma_motor_driver/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/puma_motor_driver"
SRC_URI = "git://github.com/clearpath-gbp/puma_motor_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "dd40b72a1061a81a97e357f11627185b0b97aa42"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
