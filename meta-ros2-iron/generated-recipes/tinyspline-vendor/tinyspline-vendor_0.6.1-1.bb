# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "The vendor package for tinyspline."
AUTHOR = "Daisuke Nishimatsu <daisuke.nishimatsu1021@gmail.com>"
HOMEPAGE = "https://github.com/msteinbeck/tinyspline"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0 & MIT"
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f12ef8c0445c08084ae92cf2dcb7ee92"

ROS_CN = "tinyspline_vendor"
ROS_BPN = "tinyspline_vendor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-vendor-package-native \
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

# matches with: https://github.com/ros2-gbp/tinyspline_vendor-release/archive/release/iron/tinyspline_vendor/0.6.1-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/tinyspline_vendor"
SRC_URI = "git://github.com/ros2-gbp/tinyspline_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "328cd97bcba57a1363a21ff03ebe94403d730906"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
