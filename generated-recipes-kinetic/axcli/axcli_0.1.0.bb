# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A simple actionlib CLI client"
AUTHOR = "Paul Mathieu <paul.mathieu@pal-robotics.com>"
ROS_AUTHOR = "Paul Mathieu <paul.mathieu@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "axcli"
ROS_BPN = "axcli"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/po1/axcli-release/archive/release/kinetic/axcli/0.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3c11b62e6d217db208004c6d9f2b91ae"
SRC_URI[sha256sum] = "684efecba78e312cbe928e090b282b6e7376fddace2e8b2a707a3880e05eac3c"
S = "${WORKDIR}/axcli-release-release-kinetic-axcli-0.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('axcli', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('axcli', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/axcli/axcli_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/axcli/axcli-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/axcli/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/axcli/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
