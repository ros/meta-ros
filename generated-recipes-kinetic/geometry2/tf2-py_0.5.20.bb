# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The tf2_py package"
AUTHOR = "Tully Foote <tfoote@osrfoundation.org>"
HOMEPAGE = "http://ros.org/wiki/tf2_py"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "geometry2"
ROS_BPN = "tf2_py"

ROS_BUILD_DEPENDS = " \
    rospy \
    tf2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rospy \
    tf2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rospy \
    tf2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/geometry2-release/archive/release/kinetic/tf2_py/0.5.20-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9ce597404f0cf09175e224bafe8cc79a"
SRC_URI[sha256sum] = "8f7508bd083cba2f64556eed6969119a15a86ce0f9a0f867d34fd9c3f4a17601"
S = "${WORKDIR}/geometry2-release-release-kinetic-tf2_py-0.5.20-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('geometry2', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('geometry2', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry2/geometry2_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry2/geometry2-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry2/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry2/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
