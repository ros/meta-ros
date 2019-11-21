# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Open source driver for the SICK Visionary-T 3D TOF camera."
AUTHOR = "Joshua Hampp <joshua.hampp@ipa.fraunhofer.de>"
ROS_AUTHOR = "Joshua Hampp <joshua.hampp@ipa.fraunhofer.de>"
HOMEPAGE = "http://wiki.ros.org/sick_visionary_t_driver"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=5075eceb46e8c1f0c28abf2927170f9a"

ROS_CN = "sick_visionary_t"
ROS_BPN = "sick_visionary_t_driver"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    image-transport \
    roscpp \
    roslaunch \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    image-transport \
    roscpp \
    roslaunch \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    image-transport \
    roscpp \
    roslaunch \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/SICKAG/sick_visionary_t-release/archive/release/kinetic/sick_visionary_t_driver/0.0.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8ad7593196b058db8579f81e75ba8031"
SRC_URI[sha256sum] = "1d8c41a55a787e66638cd0eda28f68ce3725773c25160369426049e8d95d3d18"
S = "${WORKDIR}/sick_visionary_t-release-release-kinetic-sick_visionary_t_driver-0.0.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('sick-visionary-t', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('sick-visionary-t', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/sick-visionary-t/sick-visionary-t_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/sick-visionary-t/sick-visionary-t-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/sick-visionary-t/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/sick-visionary-t/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
