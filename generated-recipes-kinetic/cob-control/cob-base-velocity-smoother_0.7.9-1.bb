# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The 'cob_base_velocity_smoother' reads velocity messages and publishes messages of the same type for &quot;smoothed&quot; velocity to avoid shaking behavior."
AUTHOR = "Benjamin Maidel <bnm@ipa.fhg.de>"
ROS_AUTHOR = "Florian Mirus <florian.mirus@gmx.net>"
HOMEPAGE = "http://ros.org/wiki/cob_base_velocity_smoother"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_control"
ROS_BPN = "cob_base_velocity_smoother"

ROS_BUILD_DEPENDS = " \
    boost \
    dynamic-reconfigure \
    geometry-msgs \
    nav-msgs \
    roscpp \
    roslint \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    dynamic-reconfigure \
    geometry-msgs \
    nav-msgs \
    roscpp \
    roslint \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    dynamic-reconfigure \
    geometry-msgs \
    nav-msgs \
    roscpp \
    roslint \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/cob_control-release/archive/release/kinetic/cob_base_velocity_smoother/0.7.9-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f78fcda97e4369cec35dd0898f5cfd9c"
SRC_URI[sha256sum] = "cb55db97d0567a914ec958973ccf947b48914672d143803b8cb7c755f024b9f3"
S = "${WORKDIR}/cob_control-release-release-kinetic-cob_base_velocity_smoother-0.7.9-1"

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
