# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Alphanumeric Viewer"
AUTHOR = "CVAR-UPM <cvar.upm3@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BDS-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=19a7d0923d7c06dcc6fee7d9de3465d1"

ROS_CN = "aerostack2"
ROS_BPN = "as2_alphanumeric_viewer"

ROS_BUILD_DEPENDS = " \
    ament-cmake \
    as2-core \
    as2-msgs \
    geometry-msgs \
    libeigen \
    ncurses \
    rclcpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-cmake \
    as2-core \
    as2-msgs \
    geometry-msgs \
    libeigen \
    ncurses \
    rclcpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake \
    as2-core \
    as2-msgs \
    geometry-msgs \
    libeigen \
    ncurses \
    rclcpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
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

# matches with: https://github.com/ros2-gbp/aerostack2-release/archive/release/humble/as2_alphanumeric_viewer/1.1.2-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/as2_alphanumeric_viewer"
SRC_URI = "git://github.com/ros2-gbp/aerostack2-release;${ROS_BRANCH};protocol=https"
SRCREV = "639e07c60fe1c3178b0df0d30a7942181afa4870"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
