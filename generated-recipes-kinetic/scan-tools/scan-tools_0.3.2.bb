# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Laser scan processing tools."
AUTHOR = "Ivan Dryanovski <ccnyroboticslab@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/scan_tools"
SECTION = "devel"
LICENSE = "BSD & LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "scan_tools"
ROS_BPN = "scan_tools"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    laser-ortho-projector \
    laser-scan-matcher \
    laser-scan-sparsifier \
    laser-scan-splitter \
    ncd-parser \
    polar-scan-matcher \
    scan-to-cloud-converter \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    laser-ortho-projector \
    laser-scan-matcher \
    laser-scan-sparsifier \
    laser-scan-splitter \
    ncd-parser \
    polar-scan-matcher \
    scan-to-cloud-converter \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/scan_tools-release/archive/release/kinetic/scan_tools/0.3.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f1947658f56ede9830726b8c0878f11b"
SRC_URI[sha256sum] = "64e88ee545cbf17c8373709ea7e8e3fa2e07034ebebd567122b34f75b318ad6f"
S = "${WORKDIR}/scan_tools-release-release-kinetic-scan_tools-0.3.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('scan-tools', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('scan-tools', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/scan-tools/scan-tools_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/scan-tools/scan-tools-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/scan-tools/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/scan-tools/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
