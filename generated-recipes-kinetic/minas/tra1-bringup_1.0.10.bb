# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Package contains bringup scripts/config/tools for tra1 robto"
AUTHOR = "Tokyo Opensource Robotics Kyokai (TORK) Developer Team <dev@opensource-robotics.tokyo.jp>"
ROS_AUTHOR = "Tokyo Opensource Robotics Developer 534 <534o@opensource-robotics.tokyo.jp>"
HOMEPAGE = "http://ros.org/wiki/tra1_bringup"
SECTION = "devel"
LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=fe8b75cf0aba647401e1038bcd69ee74"

ROS_CN = "minas"
ROS_BPN = "tra1_bringup"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-manager \
    joint-state-controller \
    joint-trajectory-controller \
    minas-control \
    position-controllers \
    robot-state-publisher \
    tf \
    tra1-description \
    tra1-moveit-config \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    joint-state-controller \
    joint-trajectory-controller \
    minas-control \
    position-controllers \
    robot-state-publisher \
    tf \
    tra1-description \
    tra1-moveit-config \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/minas-release/archive/release/kinetic/tra1_bringup/1.0.10-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1b403f69846a6e171aecb3a6ceff7053"
SRC_URI[sha256sum] = "786ee35544c93598d57b67968e50390ef3bbbc607b287f41ce276f7e3812c1dc"
S = "${WORKDIR}/minas-release-release-kinetic-tra1_bringup-1.0.10-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('minas', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('minas', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/minas/minas_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/minas/minas-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/minas/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/minas/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
