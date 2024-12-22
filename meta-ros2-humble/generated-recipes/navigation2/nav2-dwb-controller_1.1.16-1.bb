# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "ROS2 controller (DWB) metapackage"
AUTHOR = "Carl Delsey <carl.r.delsey@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "navigation2"
ROS_BPN = "nav2_dwb_controller"

ROS_BUILD_DEPENDS = " \
    costmap-queue \
    dwb-core \
    dwb-critics \
    dwb-msgs \
    dwb-plugins \
    nav-2d-msgs \
    nav-2d-utils \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    costmap-queue \
    dwb-core \
    dwb-critics \
    dwb-msgs \
    dwb-plugins \
    nav-2d-msgs \
    nav-2d-utils \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    costmap-queue \
    dwb-core \
    dwb-critics \
    dwb-msgs \
    dwb-plugins \
    nav-2d-msgs \
    nav-2d-utils \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/navigation2-release/archive/release/humble/nav2_dwb_controller/1.1.16-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/nav2_dwb_controller"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release;${ROS_BRANCH};protocol=https"
SRCREV = "ce2831d0b07aaea83f71bda8724a71fe0715ff08"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
