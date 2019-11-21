# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A ROS node and assorted tools to provide access to the WGE100     camera used in the forearms and the stereo cameras of the PR2     robot."
AUTHOR = "Austin Hendrix <ahendrix@willowgarage.com>"
ROS_AUTHOR = "Blaise Gassend, Patrick Mihelich, Eric MacIntosh, David Palchak"
HOMEPAGE = "http://www.ros.org/wiki/wge100_camera"
SECTION = "devel"
LICENSE = "GPL-1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=984eb2ebe444619cdde9621008ccf4e4"

ROS_CN = "wge100_driver"
ROS_BPN = "wge100_camera"

ROS_BUILD_DEPENDS = " \
    camera-calibration-parsers \
    diagnostic-updater \
    driver-base \
    dynamic-reconfigure \
    image-transport \
    message-generation \
    roscpp \
    rospy \
    rostest \
    self-test \
    sensor-msgs \
    std-msgs \
    timestamp-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-calibration-parsers \
    diagnostic-updater \
    driver-base \
    dynamic-reconfigure \
    image-transport \
    message-runtime \
    roscpp \
    rospy \
    self-test \
    sensor-msgs \
    std-msgs \
    timestamp-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-calibration-parsers \
    diagnostic-updater \
    driver-base \
    dynamic-reconfigure \
    image-transport \
    message-runtime \
    roscpp \
    rospy \
    self-test \
    sensor-msgs \
    std-msgs \
    timestamp-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-drivers-gbp/wge100_driver-release/archive/release/kinetic/wge100_camera/1.8.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "253c4c3a6d4bbfd36e956c9922da2d88"
SRC_URI[sha256sum] = "0bffb1f903aaabe5483af6ae742984f71fca7034f2babe311bc389c865a62295"
S = "${WORKDIR}/wge100_driver-release-release-kinetic-wge100_camera-1.8.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('wge100-driver', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('wge100-driver', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wge100-driver/wge100-driver_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wge100-driver/wge100-driver-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wge100-driver/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/wge100-driver/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
