# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
AUTHOR = "Tyler Weaver <tyler@picknik.ai>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://ros.org/wiki/geometric_shapes"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometric_shapes"
ROS_BPN = "geometric_shapes"

ROS_BUILD_DEPENDS = "\
    libeigen\
    assimp\
    libeigen\
    fcl\
    qhull\
    pkgconfig\
    boost\
    boost\
    rclcpp\
    eigen-stl-containers\
    console-bridge-vendor\
    liboctomap-dev\
    random-numbers\
    resource-retriever\
    shape-msgs\
    geometry-msgs\
    visualization-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    rosidl-default-generators-native\
    eigen3-cmake-module-native\
"

ROS_EXPORT_DEPENDS = "\
    libeigen\
    boost\
    rclcpp\
    eigen-stl-containers\
    console-bridge-vendor\
    liboctomap-dev\
    random-numbers\
    resource-retriever\
    shape-msgs\
    geometry-msgs\
    visualization-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    eigen3-cmake-module-native\
"

ROS_EXEC_DEPENDS = "\
    assimp\
    boost\
    rosidl-default-runtime\
    fcl\
    qhull\
    rclcpp\
    eigen-stl-containers\
    console-bridge-vendor\
    liboctomap-dev\
    random-numbers\
    resource-retriever\
    shape-msgs\
    geometry-msgs\
    visualization-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-cmake\
    ament-cmake-copyright\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/geometric_shapes"
SRC_URI = "git://github.com/ros2-gbp/geometric_shapes-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "e98689e54727b22082b7c1b78cb005d6f9608491"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
