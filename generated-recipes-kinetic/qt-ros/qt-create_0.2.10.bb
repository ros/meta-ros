# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Provides templates and scripts for creating qt-ros packages      (similar to roscreate-pkg)."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier"
HOMEPAGE = "https://github.com/stonier/qt_ros/issues"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "qt_ros"
ROS_BPN = "qt_create"

ROS_BUILD_DEPENDS = " \
    qt-build \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/qt_ros-release/archive/release/kinetic/qt_create/0.2.10-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a9fe4054dc0ac2018e3bdfaa5928dc6c"
SRC_URI[sha256sum] = "a7d457980e0d856c7b627bf527a1a5ce1f4a862d77d8862018d8c4d4af8898d4"
S = "${WORKDIR}/qt_ros-release-release-kinetic-qt_create-0.2.10-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('qt-ros', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('qt-ros', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/qt-ros/qt-ros_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/qt-ros/qt-ros-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/qt-ros/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/qt-ros/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
