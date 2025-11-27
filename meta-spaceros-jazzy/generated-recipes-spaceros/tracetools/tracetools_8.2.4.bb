# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Tracing wrapper for ROS 2."
AUTHOR = "Christophe Bedard <bedard.christophe@gmail.com>"
ROS_AUTHOR = "Ingo Lütkebohle <ingo.luetkebohle@de.bosch.com>"
HOMEPAGE = "https://docs.ros.org/en/rolling/p/tracetools/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "ros2_tracing"
ROS_BPN = "tracetools"

ROS_BUILD_DEPENDS = "\
    lttng-ust\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-gen-version-h-native\
    ament-cmake-ros-native\
    pkgconfig-native\
"

ROS_EXPORT_DEPENDS = "\
    lttng-ust\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    lttng-tools\
    lttng-ust\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
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
SRCREV = "7dc6fa50062125484a3a7d18b215b3bc59712092"
S = "${WORKDIR}/git/tracetools"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
