# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Visualisation and simulation tools for Kobuki"
AUTHOR = "Marcus Liebhardt <marcus.liebhardt@yujinrobot.com>"
ROS_AUTHOR = "Marcus Liebhardt"
HOMEPAGE = "http://ros.org/wiki/kobuki_desktop"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kobuki_desktop"
ROS_BPN = "kobuki_desktop"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    kobuki-dashboard \
    kobuki-gazebo \
    kobuki-gazebo-plugins \
    kobuki-qtestsuite \
    kobuki-rviz-launchers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    kobuki-dashboard \
    kobuki-gazebo \
    kobuki-gazebo-plugins \
    kobuki-qtestsuite \
    kobuki-rviz-launchers \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/kobuki_desktop-release/archive/release/kinetic/kobuki_desktop/0.5.7-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "492d2751eb304e2b70d92fcf1be7e0a1"
SRC_URI[sha256sum] = "9c146882399b24a957c9c123648a3a12fdc90009de7ceff55ee2ecc3745ad641"
S = "${WORKDIR}/kobuki_desktop-release-release-kinetic-kobuki_desktop-0.5.7-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('kobuki-desktop', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('kobuki-desktop', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-desktop/kobuki-desktop_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-desktop/kobuki-desktop-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-desktop/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-desktop/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
