# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "URDF description of the Summit XL and Summit XL HL and omni versions"
AUTHOR = "Carlos Villar <cvillar@robotnik.es>"
ROS_AUTHOR = "Roberto Guzmán <rguzman@robotnik.es>"
HOMEPAGE = "http://ros.org/wiki/summit_xl_description"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "summit_xl_common"
ROS_BPN = "summit_xl_description"

ROS_BUILD_DEPENDS = " \
    robotnik-sensors \
    roslaunch \
    urdf \
    xacro \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    robot-state-publisher \
    robotnik-sensors \
    urdf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    robot-state-publisher \
    robotnik-sensors \
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

SRC_URI = "https://github.com/RobotnikAutomation/summit_xl_common-release/archive/release/kinetic/summit_xl_description/1.1.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0deea9762485652446757c15c53df074"
SRC_URI[sha256sum] = "210a3d5d8bfdb2b269cdfe7c122a93cedbee1a16bc05093089cb48550a3602f7"
S = "${WORKDIR}/summit_xl_common-release-release-kinetic-summit_xl_description-1.1.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('summit-xl-common', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('summit-xl-common', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-xl-common/summit-xl-common_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-xl-common/summit-xl-common-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-xl-common/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/summit-xl-common/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
