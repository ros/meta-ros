# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "eband_local_planner implements a plugin to the     base_local_planner. It implements the Elastic Band method on the     SE2 manifold."
AUTHOR = "Piyush Khandelwal <piyushk@gmail.com>"
ROS_AUTHOR = "Christian Connette"
HOMEPAGE = "http://ros.org/wiki/eband_local_planner"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "eband_local_planner"
ROS_BPN = "eband_local_planner"

ROS_BUILD_DEPENDS = " \
    base-local-planner \
    cmake-modules \
    control-toolbox \
    costmap-2d \
    geometry-msgs \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf \
    tf-conversions \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    base-local-planner \
    control-toolbox \
    costmap-2d \
    geometry-msgs \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf \
    tf-conversions \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    base-local-planner \
    control-toolbox \
    costmap-2d \
    geometry-msgs \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf \
    tf-conversions \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/utexas-bwi-gbp/eband_local_planner-release/archive/release/kinetic/eband_local_planner/0.3.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d43addfbee58ad0567e238b2a00d3686"
SRC_URI[sha256sum] = "28af2a7ee8fa4ef4b4bf938fd8314d9ccd334315caf5aa6eccc492230a0a3fe6"
S = "${WORKDIR}/eband_local_planner-release-release-kinetic-eband_local_planner-0.3.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('eband-local-planner', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('eband-local-planner', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eband-local-planner/eband-local-planner_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eband-local-planner/eband-local-planner-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eband-local-planner/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eband-local-planner/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
