# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package includes ROS messages and services for the ROBOTIS OP3 packages"
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Kayman <kmjung@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/op3_action_module_msgs"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "robotis_op3_msgs"
ROS_BPN = "op3_action_module_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/ROBOTIS-OP3-msgs-release/archive/release/kinetic/op3_action_module_msgs/0.1.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7db6cb4ecde320c0fa2fb8ffdf3d7fd7"
SRC_URI[sha256sum] = "88a0f36db2c75fbfdc0f539e22618940aa833cc97cb8c4591a2e5b6ae1cc65a9"
S = "${WORKDIR}/ROBOTIS-OP3-msgs-release-release-kinetic-op3_action_module_msgs-0.1.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robotis-op3-msgs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robotis-op3-msgs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-msgs/robotis-op3-msgs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-msgs/robotis-op3-msgs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-msgs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-msgs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
