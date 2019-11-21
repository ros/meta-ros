# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "cob_control meta-package"
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/cob_control"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_control"
ROS_BPN = "cob_control"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cob-base-controller-utils \
    cob-base-velocity-smoother \
    cob-cartesian-controller \
    cob-collision-velocity-filter \
    cob-control-mode-adapter \
    cob-control-msgs \
    cob-footprint-observer \
    cob-frame-tracker \
    cob-hardware-emulation \
    cob-model-identifier \
    cob-obstacle-distance \
    cob-omni-drive-controller \
    cob-trajectory-controller \
    cob-tricycle-controller \
    cob-twist-controller \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/cob_control-release/archive/release/kinetic/cob_control/0.7.9-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a7d44aff7948c2cd7c3a50c790fdf8c5"
SRC_URI[sha256sum] = "f0468e3414e79f8fad198a983d63bd5b7c0622cf84230a016d6ab3a583a02c6d"
S = "${WORKDIR}/cob_control-release-release-kinetic-cob_control-0.7.9-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cob-control', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cob-control', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/cob-control_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/cob-control-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
