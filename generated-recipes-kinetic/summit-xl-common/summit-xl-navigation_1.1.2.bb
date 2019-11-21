# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Navigation launch and config files for Summit XL robot."
AUTHOR = "Carlos Villar <cvillar@robotnik.es>"
ROS_AUTHOR = "Roberto Guzmán <rguzman@robotnik.es>"
HOMEPAGE = "http://ros.org/wiki/summit_xl_navigation"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "summit_xl_common"
ROS_BPN = "summit_xl_navigation"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gmapping \
    navigation \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gmapping \
    navigation \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/RobotnikAutomation/summit_xl_common-release/archive/release/kinetic/summit_xl_navigation/1.1.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "464cc1d609be8e4465da5ea7d35b0409"
SRC_URI[sha256sum] = "f2471767b088d4663cee59249914f219f062c760ade542e97ad3bec4b439eb6a"
S = "${WORKDIR}/summit_xl_common-release-release-kinetic-summit_xl_navigation-1.1.2-0"

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
