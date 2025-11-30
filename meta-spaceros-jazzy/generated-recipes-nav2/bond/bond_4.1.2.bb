# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    A bond allows two processes, A and B, to know when the other has\
    terminated, either cleanly or by crashing.  The bond remains\
    connected until it is either broken explicitly or until a\
    heartbeat times out.\
"
AUTHOR = "Geoffrey Biggs <geoff@openrobotics.org>"
ROS_AUTHOR = "Michael Carroll <michael@openrobotics.org>"
HOMEPAGE = "http://www.ros.org/wiki/bond"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "bond"
ROS_BPN = "bond"

ROS_BUILD_DEPENDS = "\
    builtin-interfaces\
    std-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    rosidl-default-generators-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    builtin-interfaces\
    rosidl-default-runtime\
    std-msgs\
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

ROS_BRANCH ?= "branch=release/jazzy/bond"
SRC_URI = "git://github.com/ros2-gbp/bond_core-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "b7601b74fdba664c3793521b702774ad1a1da2d8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
