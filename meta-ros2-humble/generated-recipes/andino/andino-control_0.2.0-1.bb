# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The andino_control package"
AUTHOR = "Franco Cipollone <franco.c@ekumenlabs.com>"
ROS_AUTHOR = "Franco Cipollone <franco.c@ekumenlabs.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD Clause 3"
LICENSE = "BSD-Clause-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=e2197b8633fd51a47f897d9d6f820c24"

ROS_CN = "andino"
ROS_BPN = "andino_control"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    andino-base \
    andino-description \
    controller-manager \
    diff-drive-controller \
    joint-state-broadcaster \
    ros2controlcli \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-clang-format \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/andino-release/archive/release/humble/andino_control/0.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/andino_control"
SRC_URI = "git://github.com/ros2-gbp/andino-release;${ROS_BRANCH};protocol=https"
SRCREV = "024414ea86bbf2689ffe4b600b2224e81f25ccf7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}