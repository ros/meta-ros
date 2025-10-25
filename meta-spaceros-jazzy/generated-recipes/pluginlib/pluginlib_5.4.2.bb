# Recipe created by ros-generate
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit ros_generate_generated

DESCRIPTION = "\
    The pluginlib package provides tools for writing and dynamically loading plugins using the ROS build infrastructure.\
    To work, these tools require plugin providers to register their plugins in the package.xml of their package.\
"
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Dirk Thomas"
HOMEPAGE = "http://www.ros.org/wiki/pluginlib"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pluginlib"
ROS_BPN = "pluginlib"

ROS_BUILD_DEPENDS = "\
    ament-index-cpp\
    class-loader\
    rcutils\
    rcpputils\
    tinyxml2-vendor\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    ament-index-cpp\
    class-loader\
    rcutils\
    rcpputils\
    tinyxml2-vendor\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    ament-index-cpp\
    class-loader\
    rcutils\
    rcpputils\
    tinyxml2-vendor\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros/pluginlib.git;${ROS_BRANCH};protocol=https"
SRCREV = "743972e88335aa6181ad694f7fb37814ed66e8d6"
S = "${WORKDIR}/git/pluginlib"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
