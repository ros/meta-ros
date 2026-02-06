# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "The entry point package for the ament buildsystem in CMake."
AUTHOR = "Chris Lalancette <clalancette@gmail.com>"
ROS_AUTHOR = "Dirk Thomas"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ament_cmake"
ROS_BPN = "ament_cmake"

ROS_BUILD_DEPENDS = "\
    ament-cmake-core\
    ament-cmake-export-dependencies\
"

ROS_BUILDTOOL_DEPENDS = "\
    cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    ament-cmake-core\
    ament-cmake-export-definitions\
    ament-cmake-export-dependencies\
    ament-cmake-export-include-directories\
    ament-cmake-export-interfaces\
    ament-cmake-export-libraries\
    ament-cmake-export-link-flags\
    ament-cmake-export-targets\
    ament-cmake-gen-version-h\
    ament-cmake-libraries\
    ament-cmake-python\
    ament-cmake-target-dependencies\
    ament-cmake-test\
    ament-cmake-version\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    cmake-native\
"

ROS_EXEC_DEPENDS = ""

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
SRC_URI = "git://github.com/ament/ament_cmake.git;${ROS_BRANCH};protocol=https"
SRCREV = "9db326888a5dda9633363f839c0504307f1a0115"
S = "${WORKDIR}/git/ament_cmake"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
