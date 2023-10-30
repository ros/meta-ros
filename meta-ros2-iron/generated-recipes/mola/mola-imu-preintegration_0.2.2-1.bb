# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "Integrator of IMU angular velocity readings"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
ROS_AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://github.com/MOLAorg/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv3"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "mola"
ROS_BPN = "mola_imu_preintegration"

ROS_BUILD_DEPENDS = " \
    mola-common \
    mrpt2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    mola-common \
    mrpt2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mola-common \
    mrpt2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mola-release/archive/release/iron/mola_imu_preintegration/0.2.2-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/mola_imu_preintegration"
SRC_URI = "git://github.com/ros2-gbp/mola-release;${ROS_BRANCH};protocol=https"
SRCREV = "da7ff7df94fcd942aac02e6f6743d533e0aec28d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
