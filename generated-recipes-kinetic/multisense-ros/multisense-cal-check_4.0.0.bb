# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "multisense_cal_check"
AUTHOR = "Carnegie Robotics <support@carnegierobotics.com>"
HOMEPAGE = "https://bitbucket.org/crl/multisense_ros"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "multisense_ros"
ROS_BPN = "multisense_cal_check"

ROS_BUILD_DEPENDS = " \
    multisense-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    multisense-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    multisense-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/carnegieroboticsllc/multisense_ros-release/archive/release/kinetic/multisense_cal_check/4.0.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eb78d13c0fc5af4342c8651a4eb218bb"
SRC_URI[sha256sum] = "11831d5cdc2747573293a0125b43a8ced218975c56ef1e8506464816dc061ef7"
S = "${WORKDIR}/multisense_ros-release-release-kinetic-multisense_cal_check-4.0.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('multisense-ros', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('multisense-ros', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multisense-ros/multisense-ros_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multisense-ros/multisense-ros-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multisense-ros/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/multisense-ros/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
