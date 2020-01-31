# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "The POPF package"
AUTHOR = "Francisco Martin <fmrico@gmail.com>"
ROS_AUTHOR = "Marc Hanheide"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "popf"
ROS_BPN = "popf"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_bison} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcbc-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcgl-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libclp-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcoinutils-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_flex} \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_bison} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcbc-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcgl-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libclp-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcoinutils-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_flex} \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_bison} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcbc-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcgl-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libclp-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_coinor-libcoinutils-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_flex} \
    rclcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fmrico/popf-release/archive/release/eloquent/popf/0.0.11-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/popf"
SRC_URI = "git://github.com/fmrico/popf-release;${ROS_BRANCH};protocol=https"
SRCREV = "386e293cddb41019597a02f980949f45c22d474c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
