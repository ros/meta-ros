# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Vendor package for the Boost SML (State Machine Language)"
AUTHOR = "Tim Clephas <tim.clephas@nobleo.nl>"
ROS_AUTHOR = "Tim Clephas <tim.clephas@nobleo.nl>"
HOMEPAGE = "https://github.com/boost-ext/sml"
SECTION = "devel"
LICENSE = "MIT & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=9d62d84a65b2df3c95b5adf0ff285765"

ROS_CN = "boost_sml_vendor"
ROS_BPN = "boost_sml_vendor"

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
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/boost_sml_vendor-release/archive/release/jazzy/boost_sml_vendor/1.1.11-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/boost_sml_vendor"
SRC_URI = "git://github.com/ros2-gbp/boost_sml_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "571c7fff9b590ec16e68be2260811360a7016375"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}