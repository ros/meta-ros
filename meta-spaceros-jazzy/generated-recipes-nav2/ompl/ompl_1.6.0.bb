# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "OMPL is a free sampling-based motion planning library."
AUTHOR = "Mark Moll <mmoll@rice.edu>"
ROS_AUTHOR = "Kavraki Lab"
HOMEPAGE = "https://ompl.kavrakilab.org"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ompl"
ROS_BPN = "ompl"

ROS_BUILD_DEPENDS = "\
    cmake\
    boost\
    libeigen\
    pkgconfig\
    ode\
    libflann\
"

ROS_BUILDTOOL_DEPENDS = "\
    cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    boost\
    libeigen\
    ode\
    libflann\
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

ROS_BRANCH ?= "branch=release/jazzy/ompl"
SRC_URI = "git://github.com/ros2-gbp/ompl-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "fda1cb4c5d644b8ea2932b45d35293cd62ff5dcd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
