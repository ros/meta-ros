# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "liblttng-ctl Python bindings"
AUTHOR = "Christophe Bedard <christophe.bedard@apex.ai>"
ROS_AUTHOR = "Christophe Bedard <christophe.bedard@apex.ai>"
HOMEPAGE = "https://docs.ros.org/en/rolling/p/lttngpy/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2_tracing"
ROS_BPN = "lttngpy"

ROS_BUILD_DEPENDS = "\
    pybind11-vendor\
    lttng-tools\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    pkgconfig-native\
    python-cmake-module-native\
"

ROS_EXPORT_DEPENDS = "\
    lttng-tools\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rpyutils\
    lttng-tools\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
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

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/ros2_tracing.git;${ROS_BRANCH};protocol=https"
SRCREV = "ac16d3b61d4bbc899dc45e5d800ab1bceed10a74"
S = "${WORKDIR}/git/lttngpy"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
