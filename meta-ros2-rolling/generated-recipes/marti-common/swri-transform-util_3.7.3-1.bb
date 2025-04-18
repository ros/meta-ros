# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "The swri_transform_util package contains utility functions and classes for      transforming between coordinate frames."
AUTHOR = "Southwest Research Institute <swri-robotics@swri.org>"
ROS_AUTHOR = "Marc Alban"
HOMEPAGE = "https://github.com/swri-robotics/marti_common"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "marti_common"
ROS_BPN = "swri_transform_util"

ROS_BUILD_DEPENDS = " \
    boost \
    cv-bridge \
    diagnostic-msgs \
    diagnostic-updater \
    geographic-msgs \
    geographiclib \
    geometry-msgs \
    geos \
    gps-msgs \
    marti-nav-msgs \
    proj \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    swri-math-util \
    swri-roscpp \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
    pkgconfig-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    cv-bridge \
    diagnostic-msgs \
    diagnostic-updater \
    geographic-msgs \
    geographiclib \
    geometry-msgs \
    geos \
    gps-msgs \
    marti-nav-msgs \
    proj \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    swri-math-util \
    swri-roscpp \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    cv-bridge \
    diagnostic-msgs \
    diagnostic-updater \
    geographic-msgs \
    geographiclib \
    geometry-msgs \
    geos \
    gps-msgs \
    marti-nav-msgs \
    proj \
    python3-numpy \
    python3-pyyaml \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    swri-math-util \
    swri-roscpp \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-index-cpp \
    launch-ros \
    launch-testing \
    launch-testing-ament-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/marti_common-release/archive/release/rolling/swri_transform_util/3.7.3-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/swri_transform_util"
SRC_URI = "git://github.com/ros2-gbp/marti_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "2449a87220579100817417aab1f33511f923c23d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
