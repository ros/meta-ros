# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The image_recognition_rqt package"
AUTHOR = "Rein Appeldoorn <reinzor@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "TODO"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=2feaf30a620f46f06a4b016624acf46f"

ROS_CN = "image_recognition"
ROS_BPN = "image_recognition_rqt"

ROS_BUILD_DEPENDS = " \
    image-recognition-msgs \
    image-recognition-util \
    rospy \
    rqt-gui \
    rqt-gui-py \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    image-recognition-msgs \
    image-recognition-util \
    rospy \
    rqt-gui \
    rqt-gui-py \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    image-recognition-msgs \
    image-recognition-util \
    rospy \
    rqt-gui \
    rqt-gui-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tue-robotics/image_recognition-release/archive/release/kinetic/image_recognition_rqt/0.0.4-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b123ab250b4c07aff1391f34a795bee4"
SRC_URI[sha256sum] = "a56d2d703300accb15861dccee05182931eec249d114560614c9a4d1ef95681c"
S = "${WORKDIR}/image_recognition-release-release-kinetic-image_recognition_rqt-0.0.4-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('image-recognition', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('image-recognition', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/image-recognition/image-recognition_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/image-recognition/image-recognition-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/image-recognition/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/image-recognition/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
