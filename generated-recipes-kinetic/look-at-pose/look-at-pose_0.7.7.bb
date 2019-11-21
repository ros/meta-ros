# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Rotate camera to look at a given pose."
AUTHOR = "Andy Zelenak <andyz@utexas.edu>"
ROS_AUTHOR = "Andy Zelenak"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "see-license.txt"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=b9b7ae22a90078605ce089aa2a968956"

ROS_CN = "look_at_pose"
ROS_BPN = "look_at_pose"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    roscpp \
    rospy \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    roscpp \
    rospy \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    roscpp \
    rospy \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/UTNuclearRoboticsPublic/look_at_pose-release/archive/release/kinetic/look_at_pose/0.7.7-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a938eb182bf85dc5c936763d4d79a1da"
SRC_URI[sha256sum] = "7a251c8cc43731f47d2a5f4b9b8961523a77d88a0f183a7aaa5ca935227636af"
S = "${WORKDIR}/look_at_pose-release-release-kinetic-look_at_pose-0.7.7-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('look-at-pose', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('look-at-pose', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/look-at-pose/look-at-pose_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/look-at-pose/look-at-pose-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/look-at-pose/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/look-at-pose/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
