# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The ps4eye package"
AUTHOR = "Ron Tajima <ryosuke.tajima@gmail.com>"
ROS_AUTHOR = "Ron Tajima <ryosuke.tajima@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/ps4eye"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=e0d579b99de3d4e65d07e0dba4f55532"

ROS_CN = "ps4eye"
ROS_BPN = "ps4eye"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gscam \
    image-proc \
    stereo-image-proc \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gscam \
    image-proc \
    stereo-image-proc \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/ps4eye-release/archive/release/kinetic/ps4eye/0.0.4-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "665668917dddb255a1f7845925252ec0"
SRC_URI[sha256sum] = "fd95a9f4c4694364cc2451ab424b82440ffdd3c3c6119ceab6de1a7290f0f8b4"
S = "${WORKDIR}/ps4eye-release-release-kinetic-ps4eye-0.0.4-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ps4eye', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ps4eye', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ps4eye/ps4eye_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ps4eye/ps4eye-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ps4eye/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ps4eye/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
