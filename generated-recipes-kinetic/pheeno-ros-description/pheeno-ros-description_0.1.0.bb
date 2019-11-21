# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The pheeno_ros_description package"
AUTHOR = "Zahi Kakish <zkakish@gmail.edu>"
ROS_AUTHOR = "Zahi Kakish <zkakish@gmail.com>"
HOMEPAGE = "https://acslaboratory.github.io"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "pheeno_ros_description"
ROS_BPN = "pheeno_ros_description"

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

SRC_URI = "https://github.com/acslaboratory/pheeno_ros_description-release/archive/release/kinetic/pheeno_ros_description/0.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6b629ab8652ee499bdeb7ba0e6177700"
SRC_URI[sha256sum] = "8ad08ec8d76d95de8fb8b29e19b741120860517559c7cdc9394f318b2583757b"
S = "${WORKDIR}/pheeno_ros_description-release-release-kinetic-pheeno_ros_description-0.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pheeno-ros-description', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pheeno-ros-description', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros-description/pheeno-ros-description_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros-description/pheeno-ros-description-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros-description/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pheeno-ros-description/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
