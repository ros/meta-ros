# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Package containing tools for dynamically loadable components"
AUTHOR = "Ivan Paunovic <ivanpauno@ekumenlabs.com>"
ROS_AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rclcpp"
ROS_BPN = "rclcpp_components"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    class-loader \
    composition-interfaces \
    rclcpp \
    rcpputils \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    class-loader \
    composition-interfaces \
    rclcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-google-benchmark \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    launch-testing \
    std-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rclcpp-release/archive/release/jazzy/rclcpp_components/28.1.10-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/rclcpp_components"
SRC_URI = "git://github.com/ros2-gbp/rclcpp-release;${ROS_BRANCH};protocol=https"
SRCREV = "f191c6088a0ff02400ad658dc538f6218b2e6d37"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
