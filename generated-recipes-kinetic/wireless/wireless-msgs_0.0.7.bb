# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Messages for describing aspects of a wireless network, connection, etc."
AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
ROS_AUTHOR = "Mike Purvis"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "wireless"
ROS_BPN = "wireless_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/wireless-release/archive/release/kinetic/wireless_msgs/0.0.7-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9c44e7fd2e089a030f9d684df6b48f48"
SRC_URI[sha256sum] = "640e622ca48d718ae7f3acf0c250c7768bee747bc9ecdcd9ed71391c63d735a4"
S = "${WORKDIR}/wireless-release-release-kinetic-wireless_msgs-0.0.7-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('wireless', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('wireless', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wireless/wireless_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wireless/wireless-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wireless/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wireless/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
