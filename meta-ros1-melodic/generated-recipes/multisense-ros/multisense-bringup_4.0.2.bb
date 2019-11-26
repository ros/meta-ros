# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "multisense_bringup"
AUTHOR = "Carnegie Robotics <support@carnegierobotics.com>"
HOMEPAGE = "https://bitbucket.org/crl/multisense_ros"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "multisense_ros"
ROS_BPN = "multisense_bringup"

ROS_BUILD_DEPENDS = " \
    multisense-description \
    multisense-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    multisense-description \
    multisense-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    multisense-description \
    multisense-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/carnegieroboticsllc/multisense_ros-release/archive/release/melodic/multisense_bringup/4.0.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/multisense_bringup"
SRC_URI = "git://github.com/carnegieroboticsllc/multisense_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "0649a6f91f2a127f1ccd761d37294760ff645d9f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
