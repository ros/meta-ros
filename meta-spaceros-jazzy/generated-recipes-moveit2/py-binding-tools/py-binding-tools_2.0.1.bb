# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Python binding tools for C++"
AUTHOR = "Robert Haschke <rhaschke@techfak.uni-bielefeld.de>"
ROS_AUTHOR = "Robert Haschke <rhaschke@techfak.uni-bielefeld.de>"
HOMEPAGE = "http://wiki.ros.org/py_binding_tools"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "py_binding_tools"
ROS_BPN = "py_binding_tools"

ROS_BUILD_DEPENDS = "\
    pybind11-vendor\
    geometry-msgs\
    rclcpp\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
"

ROS_EXPORT_DEPENDS = "\
    pybind11-vendor\
    geometry-msgs\
    rclcpp\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    pybind11-vendor\
    geometry-msgs\
    rclcpp\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    std-msgs\
    rclpy\
    ament-cmake-pytest\
    ament-lint-auto\
    ament-lint-common\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/py_binding_tools"
SRC_URI = "git://github.com/ros-gbp/py_binding_tools-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "6bbf5eea730e839c4edc430134463a29759f9a99"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
