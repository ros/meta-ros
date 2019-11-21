# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A package which adds useful additions to the serial package."
AUTHOR = "William Woodall <wjwwood@gmail.com>"
ROS_AUTHOR = "William Woodall <wjwwood@gmail.com>"
HOMEPAGE = "http://github.com/wjwwood/serial_utils"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "serial_utils"
ROS_BPN = "serial_utils"

ROS_BUILD_DEPENDS = " \
    boost \
    serial \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    serial \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    serial \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/wjwwood/serial_utils-release/archive/release/kinetic/serial_utils/0.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "46efaf6d6a3e51b5a76cf65349ec72a7"
SRC_URI[sha256sum] = "907e265f1c308e7fa0c6c70405ec9b279af540a0213a64707302019845d85256"
S = "${WORKDIR}/serial_utils-release-release-kinetic-serial_utils-0.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('serial-utils', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('serial-utils', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/serial-utils/serial-utils_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/serial-utils/serial-utils-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/serial-utils/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/serial-utils/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
