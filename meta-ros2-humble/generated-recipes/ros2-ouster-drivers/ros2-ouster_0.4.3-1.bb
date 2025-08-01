# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "ROS2 Drivers for the Ouster OS-1 Lidar"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "ros2_ouster_drivers"
ROS_BPN = "ros2_ouster"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libtins-dev} \
    builtin-interfaces \
    geometry-msgs \
    launch \
    launch-ros \
    ouster-msgs \
    pcl \
    pcl-conversions \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    sensor-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libtins-dev} \
    builtin-interfaces \
    geometry-msgs \
    launch \
    launch-ros \
    ouster-msgs \
    pcl \
    pcl-conversions \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    sensor-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libtins-dev} \
    builtin-interfaces \
    geometry-msgs \
    launch \
    launch-ros \
    ouster-msgs \
    pcl \
    pcl-conversions \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    sensor-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
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

# matches with: https://github.com/ros2-gbp/ros2_ouster_drivers-release/archive/release/humble/ros2_ouster/0.4.3-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/ros2_ouster"
SRC_URI = "git://github.com/ros2-gbp/ros2_ouster_drivers-release;${ROS_BRANCH};protocol=https"
SRCREV = "013c97cd80754a7defc79795457047c5d49ba16d"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
