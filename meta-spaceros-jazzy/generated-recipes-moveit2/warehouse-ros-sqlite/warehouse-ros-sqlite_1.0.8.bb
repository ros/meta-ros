# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Implementation of warehouse_ros for sqlite"
AUTHOR = "MoveIt Release Team <moveit_releasers@googlegroups.com>"
ROS_AUTHOR = "Bjarne von Horn"
HOMEPAGE = "http://ros.org/wiki/warehouse_ros"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "warehouse_ros_sqlite"
ROS_BPN = "warehouse_ros_sqlite"

ROS_BUILD_DEPENDS = "\
    boost\
    warehouse-ros\
    class-loader\
    rclcpp\
    sqlite3\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    warehouse-ros\
    class-loader\
    rclcpp\
    sqlite3\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    warehouse-ros\
    class-loader\
    rclcpp\
    sqlite3\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-copyright\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-common\
    geometry-msgs\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we
# needed them to build this package (even though we actually don't) so
# that they're guaranteed to have been staged should this package appear
# in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=dynrpm/jazzy/warehouse_ros_sqlite"
SRC_URI = "git://github.com/ros2-gbp/warehouse_ros_sqlite-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "e87a63ba474e07dde5b2c7ebd0a3cb92e1964aca"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
