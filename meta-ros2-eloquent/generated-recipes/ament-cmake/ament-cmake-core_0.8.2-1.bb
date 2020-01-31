# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "The core of the ament buildsystem in CMake.      Several subcomponents provide specific funtionalities:     * environment: provide prefix-level setup files     * environment_hooks: provide package-level setup files and environment hooks     * index: store information in an index and retrieve them without crawling     * package_templates: templates from the ament_package Python package     * symlink_install: use symlinks for CMake install commands"
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ament_cmake"
ROS_BPN = "ament_cmake_core"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-package-native \
    cmake-native \
    python3-catkin-pkg-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-package-native \
    cmake-native \
    python3-catkin-pkg-native \
"

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ament_cmake-release/archive/release/eloquent/ament_cmake_core/0.8.2-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/ament_cmake_core"
SRC_URI = "git://github.com/ros2-gbp/ament_cmake-release;${ROS_BRANCH};protocol=https"
SRCREV = "e6b00d64e8c1a9315349879197bcb99c52f367b9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
