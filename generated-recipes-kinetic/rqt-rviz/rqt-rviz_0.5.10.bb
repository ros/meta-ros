# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "rqt_rviz provides a GUI plugin embedding <a href="http://www.ros.org/wiki/rviz">RViz</a>.     Note that this rqt plugin does NOT supersede RViz but depends on it."
AUTHOR = "Louise Poubel <louise@osrfoundation.org>"
ROS_AUTHOR = "Dorian Scholz"
HOMEPAGE = "http://wiki.ros.org/rqt_rviz"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_rviz"
ROS_BPN = "rqt_rviz"

ROS_BUILD_DEPENDS = " \
    boost \
    pluginlib \
    rqt-gui \
    rqt-gui-cpp \
    rviz \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    pluginlib \
    rqt-gui \
    rqt-gui-cpp \
    rviz \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    pluginlib \
    rqt-gui \
    rqt-gui-cpp \
    rviz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/rqt_rviz-release/archive/release/kinetic/rqt_rviz/0.5.10-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "990e80bee59329337717bc1303a92b33"
SRC_URI[sha256sum] = "6bb3779b59c260fefd6fad72e3e47253d93580d27538558a3e0dd6bfc49144b4"
S = "${WORKDIR}/rqt_rviz-release-release-kinetic-rqt_rviz-0.5.10-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rqt-rviz', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rqt-rviz', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-rviz/rqt-rviz_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-rviz/rqt-rviz-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-rviz/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-rviz/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
