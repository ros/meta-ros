# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Metapackage with all MOLA state estimation packages."
AUTHOR = "Jose-Luis Blanco-Claraco <jlblanco@ual.es>"
HOMEPAGE = "https://github.com/MOLAorg/mola_state_estimation"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=c1feec27682903a4270dbb401e443f91"

ROS_CN = "mola_state_estimation"
ROS_BPN = "mola_state_estimation"

ROS_BUILD_DEPENDS = " \
    mola-imu-preintegration \
    mola-state-estimation-simple \
    mola-state-estimation-smoother \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    mola-imu-preintegration \
    mola-state-estimation-simple \
    mola-state-estimation-smoother \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mola-imu-preintegration \
    mola-state-estimation-simple \
    mola-state-estimation-smoother \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-xmllint \
    ament-lint-auto \
    ament-lint-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mola_state_estimation-release/archive/release/rolling/mola_state_estimation/1.6.1-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/mola_state_estimation"
SRC_URI = "git://github.com/ros2-gbp/mola_state_estimation-release;${ROS_BRANCH};protocol=https"
SRCREV = "526ac91fc8dd73e041264b3a6993d4e7462be1d9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}