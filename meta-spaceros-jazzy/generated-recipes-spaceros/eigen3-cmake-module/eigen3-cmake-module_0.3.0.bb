# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Exports a custom CMake module to find Eigen3."
AUTHOR = "Scott K Logan <scott@openrobotics.org>"
ROS_AUTHOR = "Brandon Ong <brandon@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "eigen3_cmake_module"
ROS_BPN = "eigen3_cmake_module"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-copyright\
    ament-cmake-lint-cmake\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/eigen3_cmake_module.git;${ROS_BRANCH};protocol=https"
SRCREV = "b5d2b9b155e43ad9cbe251ec3de7ec462b6e8ba2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
