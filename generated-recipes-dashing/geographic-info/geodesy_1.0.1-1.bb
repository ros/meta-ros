# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Python and C++ interfaces for manipulating geodetic coordinates."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://wiki.ros.org/geodesy"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geographic_info"
ROS_BPN = "geodesy"

ROS_BUILD_DEPENDS = " \
    angles \
    geographic-msgs \
    geometry-msgs \
    python-catkin-pkg \
    python-pyproj \
    sensor-msgs \
    unique-identifier-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    geographic-msgs \
    geometry-msgs \
    python-pyproj \
    sensor-msgs \
    unique-identifier-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    geographic-msgs \
    geometry-msgs \
    python-pyproj \
    sensor-msgs \
    unique-identifier-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-geographic-info/geographic_info-release/archive/release/dashing/geodesy/1.0.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "389d64f55a3bc13da35ed7a04440c4e8"
SRC_URI[sha256sum] = "65697d626472d7515652b20979bd6b975b81d8444b66e86a6025b7362176dc92"
S = "${WORKDIR}/geographic_info-release-release-dashing-geodesy-1.0.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('geographic-info', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('geographic-info', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geographic-info/geographic-info_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geographic-info/geographic-info-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geographic-info/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geographic-info/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
