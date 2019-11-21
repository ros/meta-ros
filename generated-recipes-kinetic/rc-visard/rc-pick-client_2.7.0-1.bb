# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The ros client for roboception grasp generation modules"
AUTHOR = "Felix Ruess <felix.ruess@roboception.de>"
ROS_AUTHOR = "Monika Florek-Jasinska <monika.florek-jasinska@roboception.de>"
HOMEPAGE = "http://wiki.ros.org/rc_pick_client"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rc_visard"
ROS_BPN = "rc_pick_client"

ROS_BUILD_DEPENDS = " \
    curl \
    dynamic-reconfigure \
    geometry-msgs \
    message-generation \
    rc-common-msgs \
    rcdiscover \
    roscpp \
    shape-msgs \
    std-srvs \
    tf \
    tf2-geometry-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    curl \
    dynamic-reconfigure \
    geometry-msgs \
    rc-common-msgs \
    rcdiscover \
    roscpp \
    shape-msgs \
    std-srvs \
    tf \
    tf2-geometry-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    curl \
    dynamic-reconfigure \
    geometry-msgs \
    message-runtime \
    rc-common-msgs \
    rcdiscover \
    roscpp \
    shape-msgs \
    std-srvs \
    tf \
    tf2-geometry-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/roboception-gbp/rc_visard-release/archive/release/kinetic/rc_pick_client/2.7.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7c7b70f5c6adc04a38918e8ca1610a26"
SRC_URI[sha256sum] = "f6b60ba9ae5fc4d4f72ab227fbc936eb74e842368a66824217e5d6df8ef011d0"
S = "${WORKDIR}/rc_visard-release-release-kinetic-rc_pick_client-2.7.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rc-visard', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rc-visard', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rc-visard/rc-visard_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rc-visard/rc-visard-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rc-visard/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rc-visard/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
