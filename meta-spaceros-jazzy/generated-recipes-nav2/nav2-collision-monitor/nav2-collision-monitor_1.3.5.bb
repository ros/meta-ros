# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Collision Monitor"
AUTHOR = "Alexey Merzlyakov <alexey.merzlyakov@samsung.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_collision_monitor"
ROS_BPN = "nav2_collision_monitor"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclcpp-components\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
    sensor-msgs\
    geometry-msgs\
    std-msgs\
    nav2-common\
    nav2-util\
    nav2-costmap-2d\
    nav2-msgs\
    visualization-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    rclcpp-components\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
    sensor-msgs\
    geometry-msgs\
    std-msgs\
    nav2-common\
    nav2-util\
    nav2-costmap-2d\
    nav2-msgs\
    visualization-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    rclcpp-components\
    tf2\
    tf2-ros\
    tf2-geometry-msgs\
    sensor-msgs\
    geometry-msgs\
    std-msgs\
    nav2-common\
    nav2-util\
    nav2-costmap-2d\
    nav2-msgs\
    visualization-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-common\
    ament-lint-auto\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_collision_monitor"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "cbadd14581df944fce338ded0d45b15e7e8084a0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
