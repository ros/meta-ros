# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Wraps FMUs for co-simulation"
AUTHOR = "Ralph Lange <ralph.lange@de.bosch.com>"
HOMEPAGE = "http://wiki.ros.org/fmi_adapter"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "fmi_adapter_ros2"
ROS_BPN = "fmi_adapter"

ROS_BUILD_DEPENDS = " \
    fmilibrary-vendor \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    launch \
    launch-ros \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    launch-testing \
    rcutils \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=foxy"
SRC_URI = "git://github.com/boschresearch/fmi_adapter;${ROS_BRANCH};protocol=https"
SRCREV = "7dba74312ae6e582a02bdb307ff0f5be63364459"
S = "${WORKDIR}/git/fmi_adapter"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
