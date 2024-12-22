# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Drive-by-wire interface to the Dataspeed Inc. Polaris GEM/Ranger/RZR DBW kit"
AUTHOR = "Kevin Hallenbeck <khallenbeck@dataspeedinc.com>"
ROS_AUTHOR = "Kevin Hallenbeck <khallenbeck@dataspeedinc.com>"
HOMEPAGE = "http://dataspeedinc.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dbw_ros"
ROS_BPN = "dbw_polaris_can"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    dataspeed-can-msg-filters \
    dataspeed-dbw-common \
    dbw-polaris-msgs \
    geometry-msgs \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    dataspeed-dbw-common \
    dbw-polaris-msgs \
    geometry-msgs \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    dataspeed-can-usb \
    dataspeed-dbw-common \
    dataspeed-ulc-can \
    dbw-polaris-description \
    dbw-polaris-msgs \
    geometry-msgs \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DataspeedInc-release/dbw_ros-release/archive/release/humble/dbw_polaris_can/2.1.16-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/dbw_polaris_can"
SRC_URI = "git://github.com/DataspeedInc-release/dbw_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "04ee053010e0339edf1ad9d46497ba046097bc9c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
