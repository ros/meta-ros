# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "This package provides Google Benchmark."
AUTHOR = "Scott K Logan <scott@openrobotics.org>"
ROS_AUTHOR = "Audrow Nash <audrow@openrobotics.org>"
HOMEPAGE = "https://github.com/google/benchmark"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=a9acc8a0587aa088a1cbd8e35acd271e"

ROS_CN = "google_benchmark_vendor"
ROS_BPN = "google_benchmark_vendor"

ROS_BUILD_DEPENDS = "\
    google-benchmark\
"

ROS_BUILDTOOL_DEPENDS = "\
    cmake-native\
    git-native\
"

ROS_EXPORT_DEPENDS = "\
    google-benchmark\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    google-benchmark\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ament/google_benchmark_vendor.git;${ROS_BRANCH};protocol=https"
SRCREV = "f0346a79a86a79597800cb41c34d0bb218f73207"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
