# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    The State Machine Compiler (SMC) from http://smc.sourceforge.net/\
    converts a language-independent description of a state machine\
    into the source code to support that state machine.\
    \
    This package contains the libraries that a compiled state machine\
    depends on, but it does not contain the compiler itself.\
"
AUTHOR = "Geoffrey Biggs <geoff@openrobotics.org>"
ROS_AUTHOR = "Michael Carroll <michael@openrobotics.org>"
HOMEPAGE = "http://smc.sourceforge.net/"
LICENSE = "MPL-1.1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=7d68f0d5a2e1d6a5e22cd3d27285a8cb"

ROS_CN = "smclib"
ROS_BPN = "smclib"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
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

ROS_BRANCH ?= "branch=release/jazzy/smclib"
SRC_URI = "git://github.com/ros2-gbp/bond_core-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "fa4de9d3478fff37eb12ff3b0f72050428062710"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
