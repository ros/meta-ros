# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Launch files to open an OpenNI device and load all nodelets to       convert raw depth/RGB/IR streams to depth images, disparity images,       and (registered) point clouds."
AUTHOR = "Isaac I.Y. Saito <130s@2000.jukuin.keio.ac.jp>"
ROS_AUTHOR = "Patrick Mihelich"
HOMEPAGE = "http://www.ros.org/wiki/openni_launch"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "openni_camera"
ROS_BPN = "openni_launch"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    nodelet \
    openni-camera \
    rgbd-launch \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nodelet \
    openni-camera \
    rgbd-launch \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/openni_camera-release/archive/release/kinetic/openni_launch/1.11.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "62fb408879fd699de57cf5e569bf6b88"
SRC_URI[sha256sum] = "ec0a07c5239ce3b8d9bf6dd9ec13f481341bf36b1f319f55240e9e101e0ee7d6"
S = "${WORKDIR}/openni_camera-release-release-kinetic-openni_launch-1.11.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('openni-camera', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('openni-camera', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openni-camera/openni-camera_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openni-camera/openni-camera-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openni-camera/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openni-camera/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
