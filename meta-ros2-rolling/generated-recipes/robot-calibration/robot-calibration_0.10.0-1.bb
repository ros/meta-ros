# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Calibrate a Robot"
AUTHOR = "Michael Ferguson <mike@vanadiumlabs.com>"
ROS_AUTHOR = "Michael Ferguson"
HOMEPAGE = "http://ros.org/wiki/robot_calibration"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=c93e37fc0c6f510db5735eb91dcc1550"

ROS_CN = "robot_calibration"
ROS_BPN = "robot_calibration"

ROS_BUILD_DEPENDS = " \
    boost \
    camera-calibration-parsers \
    ceres-solver \
    control-msgs \
    cv-bridge \
    geometric-shapes \
    geometry-msgs \
    gflags \
    kdl-parser \
    libeigen \
    libtinyxml2 \
    moveit-msgs \
    nav-msgs \
    orocos-kdl \
    pluginlib \
    protobuf \
    rclcpp \
    rclcpp-action \
    robot-calibration-msgs \
    rosbag2-cpp \
    sensor-msgs \
    std-msgs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2-geometry-msgs \
    tf2-ros \
    tinyxml2-vendor \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-calibration-parsers \
    ceres-solver \
    control-msgs \
    cv-bridge \
    geometric-shapes \
    geometry-msgs \
    gflags \
    kdl-parser \
    libtinyxml2 \
    moveit-msgs \
    nav-msgs \
    orocos-kdl \
    pluginlib \
    protobuf \
    rclcpp \
    rclcpp-action \
    robot-calibration-msgs \
    rosbag2-cpp \
    sensor-msgs \
    std-msgs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2-geometry-msgs \
    tf2-ros \
    tinyxml2-vendor \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-calibration-parsers \
    ceres-solver \
    control-msgs \
    cv-bridge \
    geometric-shapes \
    geometry-msgs \
    gflags \
    kdl-parser \
    libtinyxml2 \
    moveit-msgs \
    nav-msgs \
    orocos-kdl \
    pluginlib \
    protobuf \
    rclcpp \
    rclcpp-action \
    robot-calibration-msgs \
    rosbag2-cpp \
    sensor-msgs \
    std-msgs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2-geometry-msgs \
    tf2-ros \
    tinyxml2-vendor \
    visualization-msgs \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    launch \
    launch-ros \
    launch-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/robot_calibration-release/archive/release/rolling/robot_calibration/0.10.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/robot_calibration"
SRC_URI = "git://github.com/ros2-gbp/robot_calibration-release;${ROS_BRANCH};protocol=https"
SRCREV = "ecf22054652e655a068620ed6ffbc85b0fabf389"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}