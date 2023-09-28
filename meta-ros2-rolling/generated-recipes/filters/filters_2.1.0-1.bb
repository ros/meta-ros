# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "This library provides a standardized interface for processing data as a sequence     of filters.  This package contains a base class upon which to build specific implementations     as well as an interface which dynamically loads filters based on runtime parameters."
AUTHOR = "Tully Foote <tfoote@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org/filters"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "filters"
ROS_BPN = "filters"

ROS_BUILD_DEPENDS = " \
    boost \
    pluginlib \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    pluginlib \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    pluginlib \
    rclcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-gtest \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/filters-release/archive/release/rolling/filters/2.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/filters"
SRC_URI = "git://github.com/ros2-gbp/filters-release;${ROS_BRANCH};protocol=https"
SRCREV = "b93db401eaa2648badaa59530f5a66fe64dbe8d4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
