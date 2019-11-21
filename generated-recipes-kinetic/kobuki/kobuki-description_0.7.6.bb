# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Description of the Kobuki model.       Provides the model description of Kobuki for simulation and visualisation. The files in this        package are parsed and used by a variety of other components. Most users will not interact directly       with this package.              WARNING: This package is disabled because it cannot be catkinized by now, as xacro dependency is not       catkin still. In the interim we use a unary pre-catkin stack named kobuki_description."
AUTHOR = "Younghun Ju <yhju@yujinrobot.com>"
ROS_AUTHOR = "Daniel Stonier <stonier@yujinrobot.com>"
HOMEPAGE = "http://ros.org/wiki/kobuki_description"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kobuki"
ROS_BPN = "kobuki_description"

ROS_BUILD_DEPENDS = " \
    urdf \
    xacro \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    urdf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/kobuki-release/archive/release/kinetic/kobuki_description/0.7.6-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "73326c9c504c43422be2b63e21b3bc64"
SRC_URI[sha256sum] = "af16d583c7798ed4b9e83e16fcc32898fd12bf8d1dca18b4c1bce7e276acd5f4"
S = "${WORKDIR}/kobuki-release-release-kinetic-kobuki_description-0.7.6-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('kobuki', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('kobuki', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki/kobuki_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki/kobuki-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
