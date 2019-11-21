# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "<p>       Metapackage for the Nao robot, providing access to:         - NAOqi audio proxies         - NAOqi vision proxies     </p>"
AUTHOR = "Manos Tsardoulias <etsardou@gmail.com>"
ROS_AUTHOR = "Manos Tsardoulias"
HOMEPAGE = "http://wiki.ros.org/nao_interaction"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "nao_interaction"
ROS_BPN = "nao_interaction"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    nao-audio \
    nao-interaction-launchers \
    nao-interaction-msgs \
    nao-vision \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nao-audio \
    nao-interaction-launchers \
    nao-interaction-msgs \
    nao-vision \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-naoqi/nao_interaction-release/archive/release/kinetic/nao_interaction/0.1.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5cbbc2a9aaa600eb0a83632e95fe4887"
SRC_URI[sha256sum] = "c0b618ca1076c25019642d782afb2f680cc957734fe4559b82a91d0dcacfe2c7"
S = "${WORKDIR}/nao_interaction-release-release-kinetic-nao_interaction-0.1.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('nao-interaction', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('nao-interaction', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-interaction/nao-interaction_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-interaction/nao-interaction-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-interaction/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nao-interaction/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
