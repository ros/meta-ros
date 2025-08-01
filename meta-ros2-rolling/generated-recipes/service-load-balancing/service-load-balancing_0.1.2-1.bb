# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "This package helps ROS2 services implement load balancing functionality."
AUTHOR = "Barry Xu <barry.xu@sony.com>"
ROS_AUTHOR = "Barry Xu <barry.xu@sony.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "service_load_balancing"
ROS_BPN = "service_load_balancing"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rosidl-typesupport-introspection-cpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rosidl-default-runtime \
    rosidl-typesupport-introspection-cpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    example-interfaces \
    rclcpp \
    std-srvs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/service_load_balancing-release/archive/release/rolling/service_load_balancing/0.1.2-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/service_load_balancing"
SRC_URI = "git://github.com/ros2-gbp/service_load_balancing-release;${ROS_BRANCH};protocol=https"
SRCREV = "4a69dff2b365238a443159d41d3dcb692947de2d"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
