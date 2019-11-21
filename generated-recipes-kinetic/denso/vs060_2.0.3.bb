# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "<p>This package provides <a href="http://goo.gl/kL0vnf">ORiN</a>-based controller functionality for VS060, a Denso's virtical multi-joint robot.</p>"
AUTHOR = "Ryohei Ueda <ueda@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Ryohei Ueda <ueda@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://wiki.ros.org/vs060"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "denso"
ROS_BPN = "vs060"

ROS_BUILD_DEPENDS = " \
    moveit-commander \
    moveit-ros-planning \
    roscpp \
    roslang \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    moveit-commander \
    moveit-ros-planning \
    roscpp \
    roslang \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    moveit-commander \
    moveit-ros-planning \
    roscpp \
    roslang \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/start-jsk/denso-release/archive/release/kinetic/vs060/2.0.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f17499db2b8a14213fb35c240afa2957"
SRC_URI[sha256sum] = "561344bcd209e4de9f51e2ade5eb61f661dfe0af43b472f2729ccda85fcdf6ef"
S = "${WORKDIR}/denso-release-release-kinetic-vs060-2.0.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('denso', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('denso', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/denso/denso_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/denso/denso-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/denso/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/denso/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
