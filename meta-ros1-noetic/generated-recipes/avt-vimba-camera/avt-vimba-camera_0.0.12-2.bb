# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Wrapper of the Allied Vision Technologies (AVT) VIMBA Ethernet and Firewire SDK."
AUTHOR = "Miquel Massot <miquel.massot@uib.cat>"
ROS_AUTHOR = "Miquel Massot <miquel.massot@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/avt_vimba_ros"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "avt_vimba_camera"
ROS_BPN = "avt_vimba_camera"

ROS_BUILD_DEPENDS = " \
    camera-info-manager \
    diagnostic-updater \
    dynamic-reconfigure \
    image-geometry \
    image-transport \
    message-filters \
    nodelet \
    polled-camera \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-info-manager \
    diagnostic-updater \
    dynamic-reconfigure \
    image-geometry \
    image-proc \
    image-transport \
    message-filters \
    nodelet \
    polled-camera \
    roscpp \
    sensor-msgs \
    std-msgs \
    stereo-image-proc \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-info-manager \
    diagnostic-updater \
    dynamic-reconfigure \
    image-geometry \
    image-proc \
    image-transport \
    message-filters \
    nodelet \
    polled-camera \
    roscpp \
    sensor-msgs \
    std-msgs \
    stereo-image-proc \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/astuff/avt_vimba_camera-release/archive/release/noetic/avt_vimba_camera/0.0.12-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/avt_vimba_camera"
SRC_URI = "git://github.com/astuff/avt_vimba_camera-release;${ROS_BRANCH};protocol=https"
SRCREV = "d0c3b118559b9476e1efe3e990a40d976c9144d8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
