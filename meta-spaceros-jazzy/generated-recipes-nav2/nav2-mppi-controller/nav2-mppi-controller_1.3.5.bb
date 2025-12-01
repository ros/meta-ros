# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "nav2_mppi_controller"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "nav2_mppi_controller"
ROS_BPN = "nav2_mppi_controller"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    geometry-msgs\
    visualization-msgs\
    nav2-msgs\
    pluginlib\
    tf2-geometry-msgs\
    tf2\
    tf2-eigen\
    tf2-ros\
    std-msgs\
    xtensor\
    openmp\
    google-benchmark\
    xsimd\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-ros-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    geometry-msgs\
    visualization-msgs\
    nav2-msgs\
    pluginlib\
    tf2-geometry-msgs\
    tf2\
    tf2-eigen\
    tf2-ros\
    std-msgs\
    xtensor\
    openmp\
    google-benchmark\
    xsimd\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    geometry-msgs\
    visualization-msgs\
    nav2-msgs\
    pluginlib\
    tf2-geometry-msgs\
    tf2\
    tf2-eigen\
    tf2-ros\
    std-msgs\
    xtensor\
    openmp\
    google-benchmark\
    xsimd\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-common\
    ament-cmake-gtest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_mppi_controller"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "c4d49f492c7bf8ec6f32a3d939b42d5478390240"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
