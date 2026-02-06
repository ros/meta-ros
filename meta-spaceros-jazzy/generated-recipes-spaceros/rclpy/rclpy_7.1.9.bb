# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Package containing the Python client."
AUTHOR = "Shane Loretz <sloretz@openrobotics.org>"
ROS_AUTHOR = "Esteve Fernandez <esteve@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rclpy"
ROS_BPN = "rclpy"

ROS_BUILD_DEPENDS = "\
    pybind11-vendor\
    rcpputils\
    rcutils\
    rmw-implementation-cmake\
    lifecycle-msgs\
    rcl\
    rcl-interfaces\
    rcl-lifecycle\
    rcl-logging-interface\
    rcl-action\
    rcl-yaml-param-parser\
    rmw\
    rmw-implementation\
    rosidl-runtime-c\
    unique-identifier-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    python-cmake-module-native\
"

ROS_EXPORT_DEPENDS = "\
    lifecycle-msgs\
    rcl\
    rcl-interfaces\
    rcl-lifecycle\
    rcl-logging-interface\
    rcl-action\
    rcl-yaml-param-parser\
    rmw\
    rmw-implementation\
    rosidl-runtime-c\
    unique-identifier-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    action-msgs\
    ament-index-python\
    builtin-interfaces\
    python3-pyyaml\
    rosgraph-msgs\
    rpyutils\
    lifecycle-msgs\
    rcl\
    rcl-interfaces\
    rcl-lifecycle\
    rcl-logging-interface\
    rcl-action\
    rcl-yaml-param-parser\
    rmw\
    rmw-implementation\
    rosidl-runtime-c\
    unique-identifier-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-cmake-pytest\
    ament-lint-auto\
    ament-lint-common\
    python3-pytest\
    rosidl-generator-py\
    test-msgs\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/rclpy.git;${ROS_BRANCH};protocol=https"
SRCREV = "0216a1aa9e16c6a8ea1861d3c241a2b19909a1b5"
S = "${WORKDIR}/git/rclpy"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
