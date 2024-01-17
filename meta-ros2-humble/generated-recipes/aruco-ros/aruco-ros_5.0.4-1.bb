# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The ARUCO Library has been developed by the Ava group of the Univeristy of Cordoba(Spain).     It provides real-time marker based 3D pose estimation using AR markers."
AUTHOR = "Sai Kishor Kothakota <sai.kishor@pal-robotics.com>"
ROS_AUTHOR = "Rafael Muñoz Salinas <rmsalinas@uco.es>"
HOMEPAGE = "http://www.uco.es/investiga/grupos/ava/node/26"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "aruco_ros"
ROS_BPN = "aruco_ros"

ROS_BUILD_DEPENDS = " \
    aruco \
    aruco-msgs \
    cv-bridge \
    geometry-msgs \
    image-transport \
    rclcpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    aruco \
    aruco-msgs \
    cv-bridge \
    geometry-msgs \
    image-transport \
    rclcpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    aruco \
    aruco-msgs \
    cv-bridge \
    geometry-msgs \
    image-transport \
    rclcpp \
    sensor-msgs \
    tf2 \
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

# matches with: https://github.com/pal-gbp/aruco_ros-release/archive/release/humble/aruco_ros/5.0.4-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/aruco_ros"
SRC_URI = "git://github.com/pal-gbp/aruco_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "9c5640963e16fe715011ae9ca49ecf6150e84af2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}