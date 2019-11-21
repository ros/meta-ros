# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The actionlib_enhanced package"
AUTHOR = "Fabrice Poirier <fabrice.poirier@ensta-bretagne.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "actionlib_enhanced"
ROS_BPN = "actionlib_enhanced"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    message-generation \
    message-runtime \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    message-runtime \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/fannibal/actionlib-enhanced-release/archive/release/kinetic/actionlib_enhanced/0.0.9-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e1ed686f9547567b51c66ca846a3f28c"
SRC_URI[sha256sum] = "c497990f9992c03e90271ba56d38a3901cb644589384f78661b65bd6f6f6a8d3"
S = "${WORKDIR}/actionlib-enhanced-release-release-kinetic-actionlib_enhanced-0.0.9-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('actionlib-enhanced', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('actionlib-enhanced', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/actionlib-enhanced/actionlib-enhanced_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/actionlib-enhanced/actionlib-enhanced-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/actionlib-enhanced/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/actionlib-enhanced/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
