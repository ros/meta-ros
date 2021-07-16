# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "LGSVL Simulator Bridge"
AUTHOR = "Martins Mozeiko <martins.mozeiko@lge.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD 3-Clause"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=f5654d47d02d927c4f7a04f0a51abaa1"

ROS_CN = "ros2-lgsvl-bridge"
ROS_BPN = "lgsvl_bridge"

ROS_BUILD_DEPENDS = " \
    ament-cmake-ros \
    boost \
    rcl \
    rcutils \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-cmake-ros \
    boost \
    rcl \
    rcutils \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake-ros \
    boost \
    lgsvl-msgs \
    nav-msgs \
    rcl \
    rcutils \
    rosgraph-msgs \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/lgsvl/ros2-lgsvl-bridge-release/archive/release/foxy/lgsvl_bridge/0.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/lgsvl_bridge"
SRC_URI = "git://github.com/lgsvl/ros2-lgsvl-bridge-release;${ROS_BRANCH};protocol=https"
SRCREV = "bf8a9a095cde6d0edaba64b1928633e23b4d5f69"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
