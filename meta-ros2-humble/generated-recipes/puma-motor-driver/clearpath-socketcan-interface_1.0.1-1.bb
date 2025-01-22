# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Clearpath's CAN interface description with helpers for filtering and driver implementation. Further a socketcan implementation based on boost::asio is included."
AUTHOR = "Luis Camero <lcamero@clearpathrobotics.com>"
ROS_AUTHOR = "Mathias Lüdtke <mathias.luedtke@ipa.fraunhofer.de>"
HOMEPAGE = "https://github.com/clearpathrobotics/puma_motor_driver"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "LGPLv3"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=b691248d2f70cdaeeaf13696ada5d47c"

ROS_CN = "puma_motor_driver"
ROS_BPN = "clearpath_socketcan_interface"

ROS_BUILD_DEPENDS = " \
    boost \
    console-bridge \
    linux-libc-headers \
    pluginlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    console-bridge \
    linux-libc-headers \
    pluginlib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    console-bridge \
    linux-libc-headers \
    pluginlib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/clearpath-gbp/puma_motor_driver-release/archive/release/humble/clearpath_socketcan_interface/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/clearpath_socketcan_interface"
SRC_URI = "git://github.com/clearpath-gbp/puma_motor_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "b7da478beb861fed1e2e420fb257c93ac25bb844"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}