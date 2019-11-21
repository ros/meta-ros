# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "C++ client library to access semantic maps within the world canvas framework."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Jorge Santos"
HOMEPAGE = "http://ros.org/wiki/world_canvas_client_cpp"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "world_canvas_libs"
ROS_BPN = "world_canvas_client_cpp"

ROS_BUILD_DEPENDS = " \
    roscpp \
    unique-id \
    uuid-msgs \
    visualization-msgs \
    world-canvas-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    unique-id \
    uuid-msgs \
    visualization-msgs \
    world-canvas-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    unique-id \
    uuid-msgs \
    visualization-msgs \
    world-canvas-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/world_canvas_libs-release/archive/release/kinetic/world_canvas_client_cpp/0.2.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a716d0913dac1c8c7b30796ed15c1e57"
SRC_URI[sha256sum] = "48ec132d6480d248330389682060c48d798a3592f9fccd77941d80a0011d90d2"
S = "${WORKDIR}/world_canvas_libs-release-release-kinetic-world_canvas_client_cpp-0.2.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('world-canvas-libs', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('world-canvas-libs', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/world-canvas-libs/world-canvas-libs_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/world-canvas-libs/world-canvas-libs-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/world-canvas-libs/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/world-canvas-libs/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
