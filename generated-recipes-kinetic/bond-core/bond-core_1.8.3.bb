# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A bond allows two processes, A and B, to know when the other has     terminated, either cleanly or by crashing. The bond remains     connected until it is either broken explicitly or until a     heartbeat times out."
AUTHOR = "Mikael Arguedas <mikael@osrfoundation.org>"
ROS_AUTHOR = "Stu Glaser"
HOMEPAGE = "http://www.ros.org/wiki/bond_core"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "bond_core"
ROS_BPN = "bond_core"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    bond \
    bondcpp \
    bondpy \
    smclib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/bond_core-release/archive/release/kinetic/bond_core/1.8.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "632003f971c7f4dc528966102688b82f"
SRC_URI[sha256sum] = "2dbaf896369b27180c38ad10b15f5be336c5be05e90513fe947c1e55e78d6d11"
S = "${WORKDIR}/bond_core-release-release-kinetic-bond_core-1.8.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('bond-core', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('bond-core', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/bond-core/bond-core_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/bond-core/bond-core-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/bond-core/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/bond-core/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
