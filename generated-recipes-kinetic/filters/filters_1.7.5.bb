# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This library provides a standardized interface for processing data as a sequence      of filters.  This package contains a base class upon which to build specific implementations     as well as an interface which dynamically loads filters based on runtime parameters."
AUTHOR = "Tully Foote <tfoote@willowgarage.com>"
HOMEPAGE = "http://ros.org/wiki/filters"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "filters"
ROS_BPN = "filters"

ROS_BUILD_DEPENDS = " \
    pluginlib \
    rosconsole \
    roscpp \
    roslib \
    rostest \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    pluginlib \
    rosconsole \
    roscpp \
    roslib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pluginlib \
    rosconsole \
    roscpp \
    roslib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/filters-release/archive/release/kinetic/filters/1.7.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d7dceeb4c48802de3534b8f4214fec62"
SRC_URI[sha256sum] = "e71a4de4b78ed4f14b4ef07a599f1b82c2e71e429ec41fdf4e2e36d160c7e5e2"
S = "${WORKDIR}/filters-release-release-kinetic-filters-1.7.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('filters', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('filters', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/filters/filters_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/filters/filters-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/filters/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/filters/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
