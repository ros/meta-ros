# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Wrapper around osqp that ships with a CMake module"
AUTHOR = "Esteve Fernandez <esteve.fernandez@autoware.org>"
ROS_AUTHOR = "Esteve Fernandez <esteve.fernandez@autoware.org>"
HOMEPAGE = "https://github.com/oxfordcontrol/osqp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "osqp_vendor"
ROS_BPN = "osqp_vendor"

ROS_BUILD_DEPENDS = "\
    ros-environment\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    git-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

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

ROS_BRANCH ?= "branch=release/jazzy/osqp_vendor"
SRC_URI = "git://github.com/ros2-gbp/osqp_vendor-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "581a58b5467b5dcdca551e613b4bb1e4d47e30e0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
