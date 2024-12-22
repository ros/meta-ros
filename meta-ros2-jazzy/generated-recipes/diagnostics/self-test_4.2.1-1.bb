# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "self_test"
AUTHOR = "Austin Hendrix <namniart@gmail.com>"
ROS_AUTHOR = "Jeremy Leibs and Blaise Gassend"
HOMEPAGE = "http://www.ros.org/wiki/self_test"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "diagnostics"
ROS_BPN = "self_test"

ROS_BUILD_DEPENDS = " \
    diagnostic-msgs \
    diagnostic-updater \
    rclcpp \
    ros-environment \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-msgs \
    diagnostic-updater \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-msgs \
    diagnostic-updater \
    rclcpp \
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

# matches with: https://github.com/ros2-gbp/diagnostics-release/archive/release/jazzy/self_test/4.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/self_test"
SRC_URI = "git://github.com/ros2-gbp/diagnostics-release;${ROS_BRANCH};protocol=https"
SRCREV = "7c06341055f2de2b1e15f547c4aec55aec612c46"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
