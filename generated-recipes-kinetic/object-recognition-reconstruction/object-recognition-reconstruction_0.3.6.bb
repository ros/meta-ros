# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "basic 3d reconstruction of an object from aligned Kinect data"
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
ROS_AUTHOR = "Ethan Rublee <erublee@willowgarage.com>"
HOMEPAGE = "http://wg-perception.github.io/reconstruction/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "object_recognition_reconstruction"
ROS_BPN = "object_recognition_reconstruction"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    ecto \
    ecto-image-pipeline \
    ecto-pcl \
    object-recognition-core \
    opencv-candidate \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ecto \
    ecto-image-pipeline \
    ecto-pcl \
    meshlab \
    object-recognition-core \
    opencv-candidate \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecto \
    ecto-image-pipeline \
    ecto-pcl \
    meshlab \
    object-recognition-core \
    opencv-candidate \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/object_recognition_reconstruction-release/archive/release/kinetic/object_recognition_reconstruction/0.3.6-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "29bdc475b3372b75ab3f4a745753bb1e"
SRC_URI[sha256sum] = "4f670fb39bcd5753c409b409396a0229669dcf0a82a6ce953f5c3eaaf765cc69"
S = "${WORKDIR}/object_recognition_reconstruction-release-release-kinetic-object_recognition_reconstruction-0.3.6-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('object-recognition-reconstruction', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('object-recognition-reconstruction', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/object-recognition-reconstruction/object-recognition-reconstruction_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/object-recognition-reconstruction/object-recognition-reconstruction-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/object-recognition-reconstruction/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/object-recognition-reconstruction/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
