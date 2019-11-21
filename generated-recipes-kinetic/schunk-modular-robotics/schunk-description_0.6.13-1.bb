# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package contains the description (mechanical, kinematic, visual,   etc.) of different schunk components. The files in this package are parsed and used by   a variety of other components. Most users will not interact directly   with this package."
AUTHOR = "Bruno Brito <bfb@ipa.fhg.de>"
ROS_AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
HOMEPAGE = "http://ros.org/wiki/schunk_description"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "schunk_modular_robotics"
ROS_BPN = "schunk_description"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/schunk_modular_robotics-release/archive/release/kinetic/schunk_description/0.6.13-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "88a5c0fd00b6429be0e430867bebf4bf"
SRC_URI[sha256sum] = "ef165d9ff465bbbe7d2c1e85f89295e9ca4d5e391947f0cf9269385cb665d427"
S = "${WORKDIR}/schunk_modular_robotics-release-release-kinetic-schunk_description-0.6.13-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('schunk-modular-robotics', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('schunk-modular-robotics', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/schunk-modular-robotics/schunk-modular-robotics_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/schunk-modular-robotics/schunk-modular-robotics-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/schunk-modular-robotics/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/schunk-modular-robotics/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
