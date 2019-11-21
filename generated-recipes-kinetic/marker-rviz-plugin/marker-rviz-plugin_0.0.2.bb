# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The marker_rviz_plugin package contains RViz plugins to visualize messages of the marker_msgs package using RViz."
AUTHOR = "Markus Bader <markus.bader@tuwien.ac.at>"
ROS_AUTHOR = "Markus Bader"
HOMEPAGE = "http://wiki.ros.org/marker_rviz_plugin"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "marker_rviz_plugin"
ROS_BPN = "marker_rviz_plugin"

ROS_BUILD_DEPENDS = " \
    marker-msgs \
    roscpp \
    rviz \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    marker-msgs \
    roscpp \
    rviz \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    marker-msgs \
    roscpp \
    rviz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tuw-robotics/marker_rviz_plugin-release/archive/release/kinetic/marker_rviz_plugin/0.0.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "94304d2eddd87508cf2bde625721b5c9"
SRC_URI[sha256sum] = "bc621e2650d55f3082e262b8c305d1343d89984f89a7b1afd26ae2d236b23703"
S = "${WORKDIR}/marker_rviz_plugin-release-release-kinetic-marker_rviz_plugin-0.0.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('marker-rviz-plugin', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('marker-rviz-plugin', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/marker-rviz-plugin/marker-rviz-plugin_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/marker-rviz-plugin/marker-rviz-plugin-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/marker-rviz-plugin/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/marker-rviz-plugin/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
