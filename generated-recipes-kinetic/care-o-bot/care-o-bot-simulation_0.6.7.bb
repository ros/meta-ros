# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The care-o-bot-simulation meta-package"
AUTHOR = "Florian Weisshardt <fmw@ipa.fhg.de>"
HOMEPAGE = "https://github.com/ipa320/care-o-bot"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "care_o_bot"
ROS_BPN = "care_o_bot_simulation"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cob-bringup-sim \
    cob-manipulation \
    cob-navigation \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/care-o-bot-release/archive/release/kinetic/care_o_bot_simulation/0.6.7-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9b945cb2202f6be363b01f4ce925e1a5"
SRC_URI[sha256sum] = "2af490c82b16e4d7b26d83e3e8d3919b77173f746e2b62a71a8fb637150249c0"
S = "${WORKDIR}/care-o-bot-release-release-kinetic-care_o_bot_simulation-0.6.7-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('care-o-bot', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('care-o-bot', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/care-o-bot/care-o-bot_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/care-o-bot/care-o-bot-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/care-o-bot/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/care-o-bot/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
