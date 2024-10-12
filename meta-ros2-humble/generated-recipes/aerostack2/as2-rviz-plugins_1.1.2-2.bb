# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Tutorials showing how to write plugins for RViz."
AUTHOR = "Mabel Zhang <mabel@openrobotics.org>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "http://ros.org/wiki/rviz_plugin_tutorials"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "aerostack2"
ROS_BPN = "as2_rviz_plugins"

ROS_BUILD_DEPENDS = " \
    as2-core \
    as2-motion-reference-handlers \
    as2-msgs \
    geometry-msgs \
    qtbase \
    rclcpp \
    rviz-common \
    rviz-rendering \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    as2-core \
    as2-motion-reference-handlers \
    as2-msgs \
    geometry-msgs \
    rclcpp \
    rviz-common \
    rviz-rendering \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    as2-core \
    as2-motion-reference-handlers \
    as2-msgs \
    geometry-msgs \
    qtbase \
    rclcpp \
    rviz-common \
    rviz-rendering \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/aerostack2-release/archive/release/humble/as2_rviz_plugins/1.1.2-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/as2_rviz_plugins"
SRC_URI = "git://github.com/ros2-gbp/aerostack2-release;${ROS_BRANCH};protocol=https"
SRCREV = "4139d43fd1a98c8ceea67915c4cb72ae471c73ae"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
