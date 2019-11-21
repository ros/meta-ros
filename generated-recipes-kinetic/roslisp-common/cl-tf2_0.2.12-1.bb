# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Client implementation to use TF2 from Common Lisp"
AUTHOR = "Gayane Kazhoyan <kazhoyan@cs.uni-bremen.de>"
ROS_AUTHOR = "Georg Bartels"
HOMEPAGE = "https://github.com/ros/roslisp_common/issues"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "roslisp_common"
ROS_BPN = "cl_tf2"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-lisp \
    cl-transforms-stamped \
    cl-utils \
    roslisp \
    tf2-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-lisp \
    cl-transforms-stamped \
    cl-utils \
    roslisp \
    tf2-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/roslisp_common-release/archive/release/kinetic/cl_tf2/0.2.12-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fe632acdcbe2c3193055b492d4cd5da1"
SRC_URI[sha256sum] = "1caf596a067313c1a43dfb5f289e6dec64a468ed37f3f08ba05edaaf16983a8d"
S = "${WORKDIR}/roslisp_common-release-release-kinetic-cl_tf2-0.2.12-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('roslisp-common', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('roslisp-common', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp-common/roslisp-common_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp-common/roslisp-common-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp-common/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roslisp-common/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
