# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "The package provides GoogleTest."
AUTHOR = "Scott K Logan <scott@openrobotics.org>"
ROS_AUTHOR = "Audrow Nash <audrow@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=42;endline=42;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "googletest"
ROS_BPN = "gtest_vendor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
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

# matches with: https://github.com/ros2-gbp/googletest-release/archive/release/jazzy/gtest_vendor/1.14.9000-2.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/gtest_vendor"
SRC_URI = "git://github.com/ros2-gbp/googletest-release;${ROS_BRANCH};protocol=https"
SRCREV = "949478db25504854988f1510571c5b93a67f9c4b"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
