# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Simple wrapper around SocketCAN"
AUTHOR = "Josh Whitley <whitleysoftwareservices@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2_socketcan"
ROS_BPN = "ros2_socketcan"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    lifecycle-msgs \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    lifecycle-msgs \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    lifecycle-msgs \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/autowarefoundation/ros2_socketcan-release/archive/release/foxy/ros2_socketcan/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/ros2_socketcan"
SRC_URI = "git://github.com/autowarefoundation/ros2_socketcan-release;${ROS_BRANCH};protocol=https"
SRCREV = "e4a47ce6601f6850c42b88b9f5e4b80d85d429f8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
