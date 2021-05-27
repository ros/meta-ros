# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package contains a script to generate calibration launch and configurationfiles for your robot.     which is based on Michael Ferguson's calibration code"
AUTHOR = "Kei Okada <kei.okada@gmail.com>"
ROS_AUTHOR = "Kei Okada"
HOMEPAGE = "http://ros.org/wiki/calibration_setup_helper"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "calibration"
ROS_BPN = "calibration_setup_helper"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    calibration-launch \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    calibration-launch \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/calibration-release/archive/release/noetic/calibration_setup_helper/0.10.15-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/calibration_setup_helper"
SRC_URI = "git://github.com/ros-gbp/calibration-release;${ROS_BRANCH};protocol=https"
SRCREV = "b51a21c0f1ce86e8432879cb96579f0568596938"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
