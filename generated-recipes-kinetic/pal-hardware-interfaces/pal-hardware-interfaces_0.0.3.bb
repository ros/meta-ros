# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The pal_hardware_interfaces package"
AUTHOR = "Hilario Tome <hilario.tome@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=1fcc2f243daac9b962ca04b90988c4f3"

ROS_CN = "pal_hardware_interfaces"
ROS_BPN = "pal_hardware_interfaces"

ROS_BUILD_DEPENDS = " \
    hardware-interface \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    hardware-interface \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    hardware-interface \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/pal-gbp/pal_hardware_interfaces-release/archive/release/kinetic/pal_hardware_interfaces/0.0.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "75537302cb648e3c8cccb05f0bc40aaa"
SRC_URI[sha256sum] = "aab566e09adc7db91774769602e1806f087fdb62970a453e7707ca5596c44f13"
S = "${WORKDIR}/pal_hardware_interfaces-release-release-kinetic-pal_hardware_interfaces-0.0.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pal-hardware-interfaces', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pal-hardware-interfaces', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pal-hardware-interfaces/pal-hardware-interfaces_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pal-hardware-interfaces/pal-hardware-interfaces-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pal-hardware-interfaces/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pal-hardware-interfaces/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
