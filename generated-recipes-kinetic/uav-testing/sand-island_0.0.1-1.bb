# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The sand_island package"
AUTHOR = "Tully Foote <tfoote@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "uav_testing"
ROS_BPN = "sand_island"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/uav_testing-release/archive/release/kinetic/sand_island/0.0.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "09e63d4c5c4de21ee4a966f08e962f5d"
SRC_URI[sha256sum] = "30ba818b9e9e0cf1f491b7180154cb3e52777e936f9ac935861b712202a61940"
S = "${WORKDIR}/uav_testing-release-release-kinetic-sand_island-0.0.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('uav-testing', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('uav-testing', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/uav-testing/uav-testing_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/uav-testing/uav-testing-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/uav-testing/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/uav-testing/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
