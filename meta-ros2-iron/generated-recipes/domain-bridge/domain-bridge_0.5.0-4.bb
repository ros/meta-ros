# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "ROS 2 Domain Bridge"
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "domain_bridge"
ROS_BPN = "domain_bridge"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rcutils \
    rosbag2-cpp \
    rosidl-typesupport-cpp \
    yaml-cpp \
    zstd-vendor \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rcutils \
    rosbag2-cpp \
    rosidl-typesupport-cpp \
    yaml-cpp \
    zstd-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rcutils \
    rosbag2-cpp \
    rosidl-default-runtime \
    rosidl-typesupport-cpp \
    yaml-cpp \
    zstd-vendor \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    ament-lint-auto \
    ament-lint-common \
    example-interfaces \
    launch \
    launch-testing \
    launch-testing-ament-cmake \
    rmw-connextdds \
    rmw-cyclonedds-cpp \
    rmw-fastrtps-cpp \
    rmw-implementation-cmake \
    rosgraph-msgs \
    test-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/domain_bridge-release/archive/release/iron/domain_bridge/0.5.0-4.tar.gz
ROS_BRANCH ?= "branch=release/iron/domain_bridge"
SRC_URI = "git://github.com/ros2-gbp/domain_bridge-release;${ROS_BRANCH};protocol=https"
SRCREV = "f6a9d8a10ec8385d76dd2602748c32657d11fd74"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
