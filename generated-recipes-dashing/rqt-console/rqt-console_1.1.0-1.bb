# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "rqt_console provides a GUI plugin for displaying and filtering ROS messages."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Aaron Blasdel"
HOMEPAGE = "http://wiki.ros.org/rqt_console"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_console"
ROS_BPN = "rqt_console"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    python-qt-binding \
    rcl-interfaces \
    rclpy \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/rqt_console-release/archive/release/dashing/rqt_console/1.1.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0241ca836aaa2e0cbf329db89fc47e5a"
SRC_URI[sha256sum] = "76504c7586c5247da4313e82120f11ce83199e1496ec3bd6b46c2a35acdd47bf"
S = "${WORKDIR}/rqt_console-release-release-dashing-rqt_console-1.1.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rqt-console', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rqt-console', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-console/rqt-console_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-console/rqt-console-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-console/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt-console/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
