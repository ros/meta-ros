# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Provides nonlinear state estimation through sensor fusion of an abritrary number of sensors."
AUTHOR = "Tom Moore <ayrton04@gmail.com>"
ROS_AUTHOR = "Tom Moore <ayrton04@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/robot_localization"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "robot_localization"
ROS_BPN = "robot_localization"

ROS_BUILD_DEPENDS = "\
    boost\
    rclcpp\
    rmw-implementation\
    libeigen\
    geographic-msgs\
    geometry-msgs\
    diagnostic-msgs\
    diagnostic-updater\
    geographiclib\
    message-filters\
    nav-msgs\
    angles\
    sensor-msgs\
    std-msgs\
    std-srvs\
    tf2\
    tf2-eigen\
    tf2-geometry-msgs\
    tf2-ros\
    yaml-cpp-vendor\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    builtin-interfaces-native\
    rosidl-default-generators-native\
"

ROS_EXPORT_DEPENDS = "\
    boost\
    libeigen\
    geographic-msgs\
    geometry-msgs\
    diagnostic-msgs\
    diagnostic-updater\
    geographiclib\
    message-filters\
    nav-msgs\
    angles\
    sensor-msgs\
    std-msgs\
    std-srvs\
    tf2\
    tf2-eigen\
    tf2-geometry-msgs\
    tf2-ros\
    yaml-cpp-vendor\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rosidl-default-runtime\
    rclcpp\
    rmw-implementation\
    libeigen\
    geographic-msgs\
    geometry-msgs\
    diagnostic-msgs\
    diagnostic-updater\
    geographiclib\
    message-filters\
    nav-msgs\
    angles\
    sensor-msgs\
    std-msgs\
    std-srvs\
    tf2\
    tf2-eigen\
    tf2-geometry-msgs\
    tf2-ros\
    yaml-cpp-vendor\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    builtin-interfaces\
    ament-lint-auto\
    ament-lint-common\
    launch-ros\
    launch-testing-ament-cmake\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/robot_localization"
SRC_URI = "git://github.com/ros2-gbp/robot_localization-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "fb6aa7dc5b8ac4dd9f97c278f9081cbe40876da5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
