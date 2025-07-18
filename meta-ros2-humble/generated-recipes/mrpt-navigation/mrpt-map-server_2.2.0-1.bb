# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "This package provides a ROS 2 node that publishes a static map for other nodes to use it. Unlike classic ROS 1 ``map_server``, this node can publish a range of different metric maps, not only occupancy grids."
AUTHOR = "Markus Bader <markus.bader@tuwien.ac.at>"
HOMEPAGE = "https://github.com/mrpt-ros-pkg/mrpt_navigation/tree/ros2/mrpt_map_server"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrpt_navigation"
ROS_BPN = "mrpt_map_server"

ROS_BUILD_DEPENDS = " \
    ament-cmake-lint-cmake \
    ament-cmake-xmllint \
    ament-lint-auto \
    mp2p-icp \
    mrpt-libmaps \
    mrpt-libobs \
    mrpt-libros-bridge \
    mrpt-msgs \
    mrpt-nav-interfaces \
    rclcpp-components \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-cmake-lint-cmake \
    ament-cmake-xmllint \
    ament-lint-auto \
    mp2p-icp \
    mrpt-libmaps \
    mrpt-libobs \
    mrpt-libros-bridge \
    mrpt-msgs \
    mrpt-nav-interfaces \
    rclcpp-components \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake-lint-cmake \
    ament-cmake-xmllint \
    ament-lint-auto \
    mp2p-icp \
    mrpt-libmaps \
    mrpt-libobs \
    mrpt-libros-bridge \
    mrpt-msgs \
    mrpt-nav-interfaces \
    rclcpp-components \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mrpt_navigation-release/archive/release/humble/mrpt_map_server/2.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/mrpt_map_server"
SRC_URI = "git://github.com/ros2-gbp/mrpt_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "bb7880cd811b4deb3f28050ee8c3ffd8cd95a638"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
