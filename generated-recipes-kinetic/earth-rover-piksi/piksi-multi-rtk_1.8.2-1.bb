# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS driver for Piksi Multi RTK GPS Receiver."
AUTHOR = "Andres Palomino <andres@earthrover.cc>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "earth_rover_piksi"
ROS_BPN = "piksi_multi_rtk"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    piksi-rtk-msgs \
    roslib \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    piksi-rtk-msgs \
    roslib \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    piksi-rtk-msgs \
    roslib \
    rospy \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/earthrover/earth_rover_piksi-release/archive/release/kinetic/piksi_multi_rtk/1.8.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "35bb36492e33f6bfae8f80191f9e1ae9"
SRC_URI[sha256sum] = "0d845ae9e47fcb046b258370d4e78ccf916520e18fb51b08c568d0a6fc2170f7"
S = "${WORKDIR}/earth_rover_piksi-release-release-kinetic-piksi_multi_rtk-1.8.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('earth-rover-piksi', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('earth-rover-piksi', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/earth-rover-piksi/earth-rover-piksi_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/earth-rover-piksi/earth-rover-piksi-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/earth-rover-piksi/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/earth-rover-piksi/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
