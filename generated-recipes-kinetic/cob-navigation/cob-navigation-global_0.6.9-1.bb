# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package holds config and launch files for running the  <a href="http://ros.org/wiki/move_base">move_base</a> node on the <a href="http://ros.org/wiki/care-o-bot">Care-O-bot</a>.     The move_base node is configured to run over a pre-specified static map."
AUTHOR = "Felix Zeltner <fez@ipa.fraunhofer.de>"
ROS_AUTHOR = "Matthias Gruhler <mig@ipa.fraunhofer.de>"
HOMEPAGE = "http://ros.org/wiki/cob_navigation_global"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_navigation"
ROS_BPN = "cob_navigation_global"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    amcl \
    cob-default-env-config \
    cob-linear-nav \
    cob-navigation-config \
    cob-scan-unifier \
    dwa-local-planner \
    map-server \
    move-base \
    rviz \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    cob-default-env-config \
    cob-supported-robots \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/cob_navigation-release/archive/release/kinetic/cob_navigation_global/0.6.9-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ec590101d6539426bc512a484c92ab0e"
SRC_URI[sha256sum] = "7dc122e6b08421a90a19f91986397351ba880657e30d65ecd9b3d251862f13f6"
S = "${WORKDIR}/cob_navigation-release-release-kinetic-cob_navigation_global-0.6.9-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cob-navigation', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cob-navigation', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-navigation/cob-navigation_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-navigation/cob-navigation-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-navigation/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-navigation/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
