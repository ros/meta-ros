# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The fsrobo_r_msgs package"
AUTHOR = "F-ROSROBO <F-ROSROBO@fsi.co.jp>"
ROS_AUTHOR = "F-ROSROBO <F-ROSROBO@fsi.co.jp>"
HOMEPAGE = "http://wiki.ros.org/fsrobo_r_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fsrobo_r"
ROS_BPN = "fsrobo_r_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    message-generation \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-generation \
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

SRC_URI = "https://github.com/FUJISOFT-Robotics/fsrobo_r-release/archive/release/kinetic/fsrobo_r_msgs/0.7.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2088b6523c455f73880f80bf4ce1f7b8"
SRC_URI[sha256sum] = "9cf83dc453677bafe07e34e53641d6fc5b41edfed783fd09690e9c113cd49aba"
S = "${WORKDIR}/fsrobo_r-release-release-kinetic-fsrobo_r_msgs-0.7.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('fsrobo-r', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('fsrobo-r', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fsrobo-r/fsrobo-r_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fsrobo-r/fsrobo-r-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fsrobo-r/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fsrobo-r/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
