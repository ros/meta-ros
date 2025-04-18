# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Takes GNSS (GPS) readings, a MOLA georeferenced map, and publishes markers to visualize the datums as ellipsoids on the map"
AUTHOR = "José Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "mola_gnss_to_markers"
ROS_BPN = "mola_gnss_to_markers"

ROS_BUILD_DEPENDS = " \
    mrpt-libobs \
    mrpt-nav-interfaces \
    rclcpp \
    std-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    mrpt-libobs \
    mrpt-nav-interfaces \
    rclcpp \
    std-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mrpt-libobs \
    mrpt-nav-interfaces \
    rclcpp \
    std-msgs \
    visualization-msgs \
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

# matches with: https://github.com/ros2-gbp/mola_gnss_to_markers-release/archive/release/rolling/mola_gnss_to_markers/0.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/mola_gnss_to_markers"
SRC_URI = "git://github.com/ros2-gbp/mola_gnss_to_markers-release;${ROS_BRANCH};protocol=https"
SRCREV = "137f59f537526840509444f8129089f69cd05431"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
