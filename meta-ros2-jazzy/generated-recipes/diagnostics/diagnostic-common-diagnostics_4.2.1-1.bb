# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "diagnostic_common_diagnostics"
AUTHOR = "Austin Hendrix <namniart@gmail.com>"
ROS_AUTHOR = "Brice Rebsamen <brice.rebsamen@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/diagnostic_common_diagnostics"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "diagnostics"
ROS_BPN = "diagnostic_common_diagnostics"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-updater \
    lmsensors \
    python3-ntplib \
    python3-psutil \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-lint-cmake \
    ament-cmake-pytest \
    ament-cmake-xmllint \
    ament-lint-auto \
    launch-testing-ament-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/diagnostics-release/archive/release/jazzy/diagnostic_common_diagnostics/4.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/diagnostic_common_diagnostics"
SRC_URI = "git://github.com/ros2-gbp/diagnostics-release;${ROS_BRANCH};protocol=https"
SRCREV = "63df07968b261e3b11fbe4a1ea95e448d5aa0af2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
