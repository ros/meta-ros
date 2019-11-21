# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The bin_pose_msgs package"
AUTHOR = "durovsky <durovsky@photoneo.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "binpicking_utils"
ROS_BPN = "bin_pose_msgs"

ROS_BUILD_DEPENDS = " \
    genmsg \
    geometry-msgs \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    genmsg \
    geometry-msgs \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    genmsg \
    geometry-msgs \
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

SRC_URI = "https://github.com/durovsky/binpicking_utils-release/archive/release/kinetic/bin_pose_msgs/0.1.4-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2932e33bad483d34aff8efc88f27c8af"
SRC_URI[sha256sum] = "1f60038100de99ed7041d53ca36fd4cf1a76ad3fa6e546869ee347265805bd73"
S = "${WORKDIR}/binpicking_utils-release-release-kinetic-bin_pose_msgs-0.1.4-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('binpicking-utils', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('binpicking-utils', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/binpicking-utils/binpicking-utils_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/binpicking-utils/binpicking-utils-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/binpicking-utils/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/binpicking-utils/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
