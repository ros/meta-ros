# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Define a common interface between DDS implementations of ROS middleware."
AUTHOR = "Ivan Paunovic <ivanpauno@ekumenlabs.com>"
ROS_AUTHOR = "Brandon Ong <brandon@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmw_dds_common"
ROS_BPN = "rmw_dds_common"

ROS_BUILD_DEPENDS = " \
    rcpputils \
    rcutils \
    rmw \
    rmw-security-common \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    rcpputils \
    rcutils \
    rmw \
    rmw-security-common \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rcpputils \
    rcutils \
    rmw \
    rmw-security-common \
    rosidl-default-runtime \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    ament-lint-auto \
    ament-lint-common \
    osrf-testing-tools-cpp \
    performance-test-fixture \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmw_dds_common-release/archive/release/rolling/rmw_dds_common/4.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/rmw_dds_common"
SRC_URI = "git://github.com/ros2-gbp/rmw_dds_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "0a0d7c5590887a7d33fb55a876cc9d8320b3dc74"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
