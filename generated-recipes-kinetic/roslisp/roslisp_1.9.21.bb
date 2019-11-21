# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Lisp client library for ROS, the Robot Operating System."
AUTHOR = "Georg Bartels <georg.bartels@cs.uni-bremen.de>"
ROS_AUTHOR = "Bhaskara Marthi"
HOMEPAGE = "http://ros.org/wiki/roslisp"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "roslisp"
ROS_BPN = "roslisp"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rosgraph-msgs \
    roslang \
    rospack \
    sbcl \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rosgraph-msgs \
    roslang \
    rospack \
    sbcl \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/roslisp-release/archive/release/kinetic/roslisp/1.9.21-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d00e4ea66d072e7ee757af55d5aaf971"
SRC_URI[sha256sum] = "7c1461d993cfbadccec208f5d806d10c146c9387ebfa15c5d8427b89261b92c7"
S = "${WORKDIR}/roslisp-release-release-kinetic-roslisp-1.9.21-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('roslisp', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('roslisp', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp/roslisp_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp/roslisp-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
