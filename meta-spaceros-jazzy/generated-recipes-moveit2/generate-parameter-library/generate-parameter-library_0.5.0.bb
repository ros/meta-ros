# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "CMake to generate ROS parameter library."
AUTHOR = "Paul Gesel <paul.gesel@picknik.ai>"
ROS_AUTHOR = "Paul Gesel <paul.gesel@picknik.ai>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "generate_parameter_library"
ROS_BPN = "generate_parameter_library"

ROS_BUILD_DEPENDS = "\
    fmt\
    parameter-traits\
    rclcpp\
    rclpy\
    rclcpp-lifecycle\
    rsl\
    tcb-span\
    tl-expected\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
"

ROS_EXPORT_DEPENDS = "\
    fmt\
    parameter-traits\
    rclcpp\
    rclpy\
    rclcpp-lifecycle\
    rsl\
    tcb-span\
    tl-expected\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    generate-parameter-library-py-native\
"

ROS_EXEC_DEPENDS = "\
    fmt\
    parameter-traits\
    rclcpp\
    rclpy\
    rclcpp-lifecycle\
    rsl\
    tcb-span\
    tl-expected\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
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

ROS_BRANCH ?= "branch=release/jazzy/generate_parameter_library"
SRC_URI = "git://github.com/ros2-gbp/generate_parameter_library-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "cb47b932210048ff4ec424eca1f41eb9e601ebc0"
S = "${WORKDIR}/git/generate_parameter_library"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
