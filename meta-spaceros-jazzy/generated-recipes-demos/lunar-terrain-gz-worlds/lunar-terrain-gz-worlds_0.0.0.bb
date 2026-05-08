# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Gazebo Worlds for Moon World Simulation using Ignition Gazebo"
AUTHOR = "Element Robotics <founders@elementrobotics.space>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "src"
ROS_BPN = "lunar_terrain_gz_worlds"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    ros-gz\
    leo-description\
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

ROS_BRANCH ?= "branch=main"
SRC_URI = "git://github.com/space-ros/demos.git;${ROS_BRANCH};protocol=https"
SRCREV = "4657a2b8661da9ce16f258ce59bcde18f172e265"
S = "${WORKDIR}/git/lunar_terrain/lunar_terrain_gz_worlds"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
