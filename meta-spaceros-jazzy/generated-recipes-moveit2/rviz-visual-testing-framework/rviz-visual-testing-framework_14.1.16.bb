# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "3D testing framework for RViz."
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "Alessandro Bottero"
HOMEPAGE = "http://ros.org/wiki/rviz2"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz_visual_testing_framework"
ROS_BPN = "rviz_visual_testing_framework"

ROS_BUILD_DEPENDS = "\
    qtbase\
    geometry-msgs\
    rclcpp\
    rcutils\
    rviz-common\
    rviz-ogre-vendor\
    rviz-rendering\
    std-msgs\
    tf2\
    tf2-ros\
    ament-cmake-gtest\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    geometry-msgs\
    rclcpp\
    rcutils\
    rviz-common\
    rviz-ogre-vendor\
    rviz-rendering\
    std-msgs\
    tf2\
    tf2-ros\
    ament-cmake-gtest\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    geometry-msgs\
    rclcpp\
    rcutils\
    rviz-common\
    rviz-ogre-vendor\
    rviz-rendering\
    std-msgs\
    tf2\
    tf2-ros\
    ament-cmake-gtest\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-cppcheck\
    ament-cmake-cpplint\
    ament-cmake-gmock\
    ament-cmake-lint-cmake\
    ament-cmake-uncrustify\
    ament-cmake-xmllint\
    ament-lint-auto\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/rviz_visual_testing_framework"
SRC_URI = "git://github.com/ros2-gbp/rviz-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "37bf0599dce350b9820d4973880b188532ce554d"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/rviz_visual_testing_framework"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
