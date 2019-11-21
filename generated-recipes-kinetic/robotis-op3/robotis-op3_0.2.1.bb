# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS packages for the robotis_op3 (meta package)"
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Kayman <kmjung@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/robotis_op3"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "robotis_op3"
ROS_BPN = "robotis_op3"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cm-740-module \
    op3-action-module \
    op3-balance-control \
    op3-base-module \
    op3-direct-control-module \
    op3-head-control-module \
    op3-kinematics-dynamics \
    op3-localization \
    op3-manager \
    op3-online-walking-module \
    op3-walking-module \
    open-cr-module \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/ROBOTIS-OP3-release/archive/release/kinetic/robotis_op3/0.2.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f1aa7312aeefde08570abe83120f911c"
SRC_URI[sha256sum] = "04a0490f12c9d528608eae6bc03fb0e075f27ce5e5e14028a576a001c28f2d0e"
S = "${WORKDIR}/ROBOTIS-OP3-release-release-kinetic-robotis_op3-0.2.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robotis-op3', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robotis-op3', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3/robotis-op3_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3/robotis-op3-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
