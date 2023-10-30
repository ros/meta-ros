# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "ROS2 vendor package for stbrumme/hash-library"
AUTHOR = "Kenji Miyake <kenji.miyake@tier4.jp>"
ROS_AUTHOR = "Stephan Brumme"
HOMEPAGE = "https://github.com/stbrumme/hash-library"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0 & Zlib License"
LICENSE = "Apache-2.0 & Zlib-License"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f9b08e944e4cd1aa722fbb316eb4b3e2"

ROS_CN = "hash_library_vendor"
ROS_BPN = "hash_library_vendor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    git-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/hash_library_vendor-release/archive/release/iron/hash_library_vendor/0.1.1-5.tar.gz
ROS_BRANCH ?= "branch=release/iron/hash_library_vendor"
SRC_URI = "git://github.com/ros2-gbp/hash_library_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "67491c6393537f52e931990dc4217f7a39e95cca"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
