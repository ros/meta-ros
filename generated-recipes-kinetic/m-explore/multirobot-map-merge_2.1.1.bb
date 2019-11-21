# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Merging multiple maps without knowledge of initial   positions of robots."
AUTHOR = "Jiri Horner <laeqten@gmail.com>"
ROS_AUTHOR = "Jiri Horner <laeqten@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/multirobot_map_merge"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "m_explore"
ROS_BPN = "multirobot_map_merge"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    map-msgs \
    nav-msgs \
    opencv3 \
    roscpp \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    map-msgs \
    nav-msgs \
    opencv3 \
    roscpp \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    map-msgs \
    nav-msgs \
    opencv3 \
    roscpp \
    tf2-geometry-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/hrnr/m-explore-release/archive/release/kinetic/multirobot_map_merge/2.1.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6fdc71c139b9b4006d7fe96911aded4c"
SRC_URI[sha256sum] = "df9d13dc9aeb42feb2562689ce1fc9da1e99c3ace61d92fbe2be10d914bd6bda"
S = "${WORKDIR}/m-explore-release-release-kinetic-multirobot_map_merge-2.1.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('m-explore', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('m-explore', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/m-explore/m-explore_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/m-explore/m-explore-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/m-explore/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/m-explore/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
