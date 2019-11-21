# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The rosbag_editor package"
AUTHOR = "dfaconti <davide.faconti@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/rosbag_editor"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "rosbag_editor"
ROS_BPN = "rosbag_editor"

ROS_BUILD_DEPENDS = " \
    qtbase \
    rosbag \
    rosbag-storage \
    roscpp \
    tf \
    tf2-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    qtbase \
    rosbag \
    rosbag-storage \
    roscpp \
    tf \
    tf2-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    qtbase \
    rosbag \
    rosbag-storage \
    roscpp \
    tf \
    tf2-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/facontidavide/rosbag_editor-release/archive/release/kinetic/rosbag_editor/0.4.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "93392811c5b78bd314390e9659f1ffd1"
SRC_URI[sha256sum] = "44490d8db2a980f85f476a39413a7852047ea216b877fcafbbc306af6366dbd2"
S = "${WORKDIR}/rosbag_editor-release-release-kinetic-rosbag_editor-0.4.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rosbag-editor', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rosbag-editor', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosbag-editor/rosbag-editor_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosbag-editor/rosbag-editor-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosbag-editor/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosbag-editor/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
