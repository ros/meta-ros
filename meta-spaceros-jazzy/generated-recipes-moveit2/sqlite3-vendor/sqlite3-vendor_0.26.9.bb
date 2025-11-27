# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "SQLite 3 vendor package"
AUTHOR = "Michael Orlov <michael.orlov@apex.ai>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "sqlite3_vendor"
ROS_BPN = "sqlite3_vendor"

ROS_BUILD_DEPENDS = "\
    sqlite3\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-vendor-package-native\
"

ROS_EXPORT_DEPENDS = "\
    sqlite3\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    sqlite3\
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

ROS_BRANCH ?= "branch=release/jazzy/sqlite3_vendor"
SRC_URI = "git://github.com/ros2-gbp/rosbag2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "91c21f8465b545d19132e16da0c24c64c7697654"
S = "${WORKDIR}/git/sqlite3_vendor"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
