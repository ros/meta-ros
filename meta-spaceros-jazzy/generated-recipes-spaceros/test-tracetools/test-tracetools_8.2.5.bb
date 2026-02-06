# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Tests for the tracetools package."
AUTHOR = "Christophe Bedard <bedard.christophe@gmail.com>"
ROS_AUTHOR = "Christophe Bedard <fixed-term.christophe.bourquebedard@de.bosch.com>"
HOMEPAGE = "https://github.com/ros2/ros2_tracing"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "ros2_tracing"
ROS_BPN = "test_tracetools"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    pkgconfig-native\
"

ROS_EXPORT_DEPENDS = "\
    lttng-ust\
    lifecycle-msgs\
    rclcpp\
    rclcpp-lifecycle\
    rcpputils\
    std-msgs\
    std-srvs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-cmake-mypy\
    ament-cmake-pytest\
    ament-lint-auto\
    ament-lint-common\
    lttng-ust\
    lifecycle-msgs\
    python3-pytest\
    python3-pytest-cov\
    rclcpp\
    rclcpp-lifecycle\
    rcpputils\
    rmw-implementation-cmake\
    std-msgs\
    std-srvs\
    tracetools\
    tracetools-test\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/ros2_tracing.git;${ROS_BRANCH};protocol=https"
SRCREV = "ac16d3b61d4bbc899dc45e5d800ab1bceed10a74"
S = "${WORKDIR}/git/test_tracetools"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
