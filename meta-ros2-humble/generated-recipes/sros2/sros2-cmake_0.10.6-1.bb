# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "CMake macros to configure security"
AUTHOR = "ROS Security Working Group <ros-security@googlegroups.com>"
ROS_AUTHOR = "AWS RoboMaker"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=80318c4afef111a7690eaf237460856b"

ROS_CN = "sros2"
ROS_BPN = "sros2_cmake"

ROS_BUILD_DEPENDS = " \
    ament-cmake-test \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ros2cli \
    sros2 \
"

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

# matches with: https://github.com/ros2-gbp/sros2-release/archive/release/humble/sros2_cmake/0.10.6-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/sros2_cmake"
SRC_URI = "git://github.com/ros2-gbp/sros2-release;${ROS_BRANCH};protocol=https"
SRCREV = "4875bd94f4e15d5dbbaaff4f16b61f707e4c3fec"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
