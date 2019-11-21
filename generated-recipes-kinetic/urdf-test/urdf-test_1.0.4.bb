# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The urdf_test package"
AUTHOR = "davidfernandez <david.fernandez@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=1fcc2f243daac9b962ca04b90988c4f3"

ROS_CN = "urdf_test"
ROS_BPN = "urdf_test"

ROS_BUILD_DEPENDS = " \
    rospy \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rospy \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/pal-gbp/urdf_test-release/archive/release/kinetic/urdf_test/1.0.4-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9855cbdb3de187ae6d5160a3464203f7"
SRC_URI[sha256sum] = "c5a24227ab3bf1cab0873057311cd5c7bb7ab1fc159ee931054316fb6d019ecf"
S = "${WORKDIR}/urdf_test-release-release-kinetic-urdf_test-1.0.4-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('urdf-test', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('urdf-test', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/urdf-test/urdf-test_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/urdf-test/urdf-test-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/urdf-test/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/urdf-test/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
