# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Driver package for Wacohtech dynpick force sensor. This contains <a href="http://ros.org/">ROS</a>-compatible linux driver, as well as a communication test tool.<br/>   As of Oct 2016, it's tested with the following models of dynpick:   <ul>     <li><a href="http://www.wacoh-tech.com/products/dynpick/wdf-6m200-3.html">wdf-6m200-3</a></li>     <li><a href="http://www.wacoh-tech.com/en/products/dynpick/200n.html">WEF-6A200</a> (confirmed <a href="https://github.com/tork-a/dynpick_driver/pull/35#issuecomment-256031851">here</a>)</li>   </ul>"
AUTHOR = "TORK <dev@opensource-robotics.tokyo.jp>"
ROS_AUTHOR = "Kei Okada <kei.okada@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/dynpick_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "dynpick_driver"
ROS_BPN = "dynpick_driver"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    python-catkin-pkg \
    roscpp \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    robot-state-publisher \
    roscpp \
    rviz \
    std-srvs \
    tf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    robot-state-publisher \
    roscpp \
    rviz \
    std-srvs \
    tf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/dynpick_driver-release/archive/release/kinetic/dynpick_driver/0.2.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "522aea4bd119107adaeb14f8e99cafc2"
SRC_URI[sha256sum] = "3a78a3fd5ab15c800d3f2fddac1e6e8d50c150d8ffb775d656947e7f2cf4f5b4"
S = "${WORKDIR}/dynpick_driver-release-release-kinetic-dynpick_driver-0.2.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('dynpick-driver', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('dynpick-driver', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynpick-driver/dynpick-driver_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynpick-driver/dynpick-driver-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynpick-driver/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dynpick-driver/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
