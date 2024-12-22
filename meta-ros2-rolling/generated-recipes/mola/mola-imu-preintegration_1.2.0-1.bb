# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Integrator of IMU angular velocity readings"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://github.com/MOLAorg/mola/tree/develop/mola_imu_preintegration"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv3"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=e9f2deaa804a16d9e0d3965ef77e171e"

ROS_CN = "mola"
ROS_BPN = "mola_imu_preintegration"

ROS_BUILD_DEPENDS = " \
    mola-common \
    mrpt-libobs \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    mola-common \
    mrpt-libobs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mola-common \
    mrpt-libobs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mola-release/archive/release/rolling/mola_imu_preintegration/1.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/mola_imu_preintegration"
SRC_URI = "git://github.com/ros2-gbp/mola-release;${ROS_BRANCH};protocol=https"
SRCREV = "126bd367225626b96d1448e5e64ee8884ef5f478"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
