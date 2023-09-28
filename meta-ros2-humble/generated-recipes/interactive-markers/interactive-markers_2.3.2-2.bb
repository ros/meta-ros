# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "3D interactive marker communication library for RViz and similar tools."
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
ROS_AUTHOR = "David Gossow"
HOMEPAGE = "http://ros.org/wiki/interactive_markers"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "interactive_markers"
ROS_BPN = "interactive_markers"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rmw \
    tf2 \
    tf2-geometry-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    rmw \
    tf2 \
    tf2-geometry-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    rclcpp \
    rclpy \
    rmw \
    tf2 \
    tf2-geometry-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    geometry-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/interactive_markers-release/archive/release/humble/interactive_markers/2.3.2-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/interactive_markers"
SRC_URI = "git://github.com/ros2-gbp/interactive_markers-release;${ROS_BRANCH};protocol=https"
SRCREV = "dace99fbd8e164b82258ba4bc7f8bc213c9140b4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
