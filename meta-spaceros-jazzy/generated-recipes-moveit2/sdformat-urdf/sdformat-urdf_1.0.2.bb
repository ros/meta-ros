# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "URDF plugin to parse SDFormat XML into URDF C++ DOM objects."
AUTHOR = "Shane Loretz <sloretz@osrfoundation.org>"
ROS_AUTHOR = "Shane Loretz <sloretz@openrobotics.org>"
HOMEPAGE = "https://github.com/ros/sdformat_urdf"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "sdformat_urdf"
ROS_BPN = "sdformat_urdf"

ROS_BUILD_DEPENDS = "\
    urdfdom-headers\
    pluginlib\
    rcutils\
    tinyxml2-vendor\
    urdf-parser-plugin\
    sdformat-vendor\
    urdf\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
"

ROS_EXPORT_DEPENDS = "\
    urdfdom-headers\
    pluginlib\
    rcutils\
    tinyxml2-vendor\
    urdf-parser-plugin\
    sdformat-vendor\
    urdf\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    ament-cmake-ros-native\
"

ROS_EXEC_DEPENDS = "\
    tinyxml2-vendor\
    urdf-parser-plugin\
    sdformat-vendor\
    urdf\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-common\
    sdformat-test-files\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=debian/jazzy/sdformat_urdf"
SRC_URI = "git://github.com/ros2-gbp/sdformat_urdf-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "d923456c7a3c40a1cf8b8c32e52f9838c95ddfde"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
