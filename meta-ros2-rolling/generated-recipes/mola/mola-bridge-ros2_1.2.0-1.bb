# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Bidirectional bridge ROS2-MOLA"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://github.com/MOLAorg/mola/tree/develop/mola_bridge_ros2"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=c1feec27682903a4270dbb401e443f91"

ROS_CN = "mola"
ROS_BPN = "mola_bridge_ros2"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    mola-common \
    mola-kernel \
    mola-msgs \
    mrpt-libmaps \
    mrpt-libros-bridge \
    nav-msgs \
    rclcpp \
    ros-environment \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-gmock-native \
    ament-cmake-gtest-native \
    ament-cmake-native \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    mola-common \
    mola-kernel \
    mola-msgs \
    mrpt-libmaps \
    mrpt-libros-bridge \
    nav-msgs \
    rclcpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    mola-common \
    mola-kernel \
    mola-msgs \
    mrpt-libmaps \
    mrpt-libros-bridge \
    nav-msgs \
    rclcpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-xmllint \
    ament-lint-auto \
    ament-lint-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mola-release/archive/release/rolling/mola_bridge_ros2/1.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/mola_bridge_ros2"
SRC_URI = "git://github.com/ros2-gbp/mola-release;${ROS_BRANCH};protocol=https"
SRCREV = "cb9c5c2fdb6507c1a80fd7c6dc3ce31fad224276"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
