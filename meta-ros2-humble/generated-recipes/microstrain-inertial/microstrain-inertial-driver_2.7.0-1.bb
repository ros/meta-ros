# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The ros_mscl package provides a driver for the LORD/Microstrain inertial products."
AUTHOR = "Rob Fisher <rob.fisher@parker.com>"
ROS_AUTHOR = "Brian Bingham"
HOMEPAGE = "https://github.com/LORD-MicroStrain/microstrain_inertial"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "microstrain_inertial"
ROS_BPN = "microstrain_inertial_driver"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-jq} \
    curl \
    diagnostic-updater \
    geometry-msgs \
    lifecycle-msgs \
    mavros-msgs \
    microstrain-inertial-msgs \
    nav-msgs \
    nmea-msgs \
    rclcpp-lifecycle \
    ros-environment \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-updater \
    geometry-msgs \
    lifecycle-msgs \
    mavros-msgs \
    microstrain-inertial-msgs \
    nav-msgs \
    nmea-msgs \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-aggregator \
    diagnostic-updater \
    geometry-msgs \
    lifecycle-msgs \
    mavros-msgs \
    microstrain-inertial-msgs \
    nav-msgs \
    nmea-msgs \
    rclcpp-lifecycle \
    rosidl-default-runtime \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-cpplint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/microstrain_inertial-release/archive/release/humble/microstrain_inertial_driver/2.7.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/microstrain_inertial_driver"
SRC_URI = "git://github.com/ros2-gbp/microstrain_inertial-release;${ROS_BRANCH};protocol=https"
SRCREV = "d4332d9a148d4b01e0769015787e82b9a2439b32"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
