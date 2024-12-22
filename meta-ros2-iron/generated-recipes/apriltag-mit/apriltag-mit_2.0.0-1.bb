# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "ROS2 package wrapper for the MIT apriltag detector"
AUTHOR = "Bernd Pfrommer <bernd.pfrommer@gmail.com>"
ROS_AUTHOR = "Michael Kaess"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "LGPLv2.1"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=e181b18ed9533044a61dea448605dcd5"

ROS_CN = "apriltag_mit"
ROS_BPN = "apriltag_mit"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-clang-tidy} \
    boost \
    libeigen \
    opencv \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-clang-tidy} \
    boost \
    libeigen \
    opencv \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-clang-tidy} \
    boost \
    libeigen \
    opencv \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/apriltag_mit-release/archive/release/iron/apriltag_mit/2.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/apriltag_mit"
SRC_URI = "git://github.com/ros2-gbp/apriltag_mit-release;${ROS_BRANCH};protocol=https"
SRCREV = "095a6e0f5dde9bb5634f5524562a07022b22f9d0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
