# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "An implementation of ROS in pure-Java with Android support."
AUTHOR = "Damon Kohler <damonkohler@google.com>"
HOMEPAGE = "http://ros.org/wiki/rosjava_core"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "rosjava_core"
ROS_BPN = "rosjava_core"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    rosgraph-msgs \
    rosjava-bootstrap \
    rosjava-build-tools \
    rosjava-messages \
    rosjava-test-msgs \
    sensor-msgs \
    tf2-msgs \
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

SRC_URI = "https://github.com/rosjava-release/rosjava_core-release/archive/release/kinetic/rosjava_core/0.3.7-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4a853287923affef4f5b940a0e61fb71"
SRC_URI[sha256sum] = "d1e862dbc3b04840f0c64d2498e38ad6d8e77d84327465dd02d3a4bca5c8f1bb"
S = "${WORKDIR}/rosjava_core-release-release-kinetic-rosjava_core-0.3.7-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rosjava-core', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rosjava-core', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosjava-core/rosjava-core_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosjava-core/rosjava-core-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosjava-core/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosjava-core/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
