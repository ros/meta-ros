# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The agvs_description package. Robot description. Urdf and mesh files."
AUTHOR = "Roberto Guzmán <rguzman@robotnik.es>"
ROS_AUTHOR = "Román Navarro <rnavarro@robotnik.es>"
HOMEPAGE = "http://wiki.ros.org/agvs_description"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "agvs_common"
ROS_BPN = "agvs_description"

ROS_BUILD_DEPENDS = " \
    roscpp \
    std-msgs \
    std-srvs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    roscpp \
    std-msgs \
    std-srvs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    roscpp \
    std-msgs \
    std-srvs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/RobotnikAutomation/agvs_common-release/archive/release/kinetic/agvs_description/0.1.3-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3e10556d683e1c32b59d865495a12902"
SRC_URI[sha256sum] = "c9baa844569cef40231442ddd9bd68daeb4c9c93c98511cbe3f383b70393d095"
S = "${WORKDIR}/agvs_common-release-release-kinetic-agvs_description-0.1.3-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('agvs-common', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('agvs-common', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-common/agvs-common_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-common/agvs-common-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-common/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/agvs-common/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
