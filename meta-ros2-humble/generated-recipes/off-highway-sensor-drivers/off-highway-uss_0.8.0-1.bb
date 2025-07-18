# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The off_highway_uss package"
AUTHOR = "Robin Petereit <robin.petereit@de.bosch.com>"
ROS_AUTHOR = "Robin Petereit <robin.petereit@de.bosch.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "off_highway_sensor_drivers"
ROS_BPN = "off_highway_uss"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    off-highway-can \
    off-highway-uss-msgs \
    pcl \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    off-highway-can \
    off-highway-uss-msgs \
    pcl \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    off-highway-can \
    off-highway-uss-msgs \
    pcl \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-ros \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/off_highway_sensor_drivers-release/archive/release/humble/off_highway_uss/0.8.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/off_highway_uss"
SRC_URI = "git://github.com/ros2-gbp/off_highway_sensor_drivers-release;${ROS_BRANCH};protocol=https"
SRCREV = "48bbf86cb69e89f2fe458e896e9d83b6f53aa029"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
