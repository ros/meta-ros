# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Plugins for dynamic sun in lunar world"
AUTHOR = "Munir Azme <munir.azme@elementrobotics.space>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=bb69307f9a8566360ce04a9b7e6a00b7"

ROS_CN = "src"
ROS_BPN = "lunar_sun_gz_plugin"

ROS_BUILD_DEPENDS = "\
    gz-plugin-vendor\
    gz-sim-vendor\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    gz-plugin-vendor\
    gz-sim-vendor\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    gz-plugin-vendor\
    gz-sim-vendor\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-cmake-copyright\
    ament-cmake-cpplint\
    ament-cmake-lint-cmake\
    ament-cmake-uncrustify\
    ament-cmake-xmllint\
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
S = "${WORKDIR}/git/lunar_terrain/lunar_sun_gz_plugin"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
