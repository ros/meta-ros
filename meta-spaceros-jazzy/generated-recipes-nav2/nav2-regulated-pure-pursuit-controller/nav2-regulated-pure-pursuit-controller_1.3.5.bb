# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Regulated Pure Pursuit Controller"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_regulated_pure_pursuit_controller"
ROS_BPN = "nav2_regulated_pure_pursuit_controller"

ROS_BUILD_DEPENDS = "\
    angles\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    rclcpp\
    geometry-msgs\
    nav2-msgs\
    pluginlib\
    tf2\
    tf2-geometry-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    angles\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    rclcpp\
    geometry-msgs\
    nav2-msgs\
    pluginlib\
    tf2\
    tf2-geometry-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    angles\
    nav2-common\
    nav2-core\
    nav2-util\
    nav2-costmap-2d\
    rclcpp\
    geometry-msgs\
    nav2-msgs\
    pluginlib\
    tf2\
    tf2-geometry-msgs\
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

ROS_BRANCH ?= "branch=release/jazzy/nav2_regulated_pure_pursuit_controller"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "17296a5ef16a1593900a5217228599128d815282"
S = "${WORKDIR}/git/nav2_regulated_pure_pursuit_controller"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
