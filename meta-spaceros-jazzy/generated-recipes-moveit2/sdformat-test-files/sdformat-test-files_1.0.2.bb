# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Example SDFormat XML files for testing tools using hthis format."
AUTHOR = "Shane Loretz <sloretz@osrfoundation.org>"
ROS_AUTHOR = "Shane Loretz <sloretz@openrobotics.org>"
HOMEPAGE = "https://github.com/ros/sdformat_test_files"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "sdformat_test_files"
ROS_BPN = "sdformat_test_files"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    cmake-native\
"

ROS_EXPORT_DEPENDS = ""

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

ROS_BRANCH ?= "branch=debian/jazzy/noble/sdformat_test_files"
SRC_URI = "git://github.com/ros2-gbp/sdformat_urdf-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "8c299f750f424fdc4c3f0f040c8f9cf222b0299d"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
