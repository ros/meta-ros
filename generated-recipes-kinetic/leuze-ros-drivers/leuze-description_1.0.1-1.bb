# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package contains ."
AUTHOR = "Ludovic Delval <ludovic.delval@ipa.fraunhofer.de>"
ROS_AUTHOR = "Ludovic Delval <ludovic.delval@ipa.fraunhofer.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=740ffa6e787a40b3ec532a5b41b0c385"

ROS_CN = "leuze_ros_drivers"
ROS_BPN = "leuze_description"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    robot-state-publisher \
    rviz \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa-led/leuze_ros_drivers-release/archive/release/kinetic/leuze_description/1.0.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aacf459efe92f7e5d0d943587e9cde60"
SRC_URI[sha256sum] = "6eff019de976334d24a35308ae37f8895d11feb18aa4e98bc1f855e240396848"
S = "${WORKDIR}/leuze_ros_drivers-release-release-kinetic-leuze_description-1.0.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('leuze-ros-drivers', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('leuze-ros-drivers', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/leuze-ros-drivers/leuze-ros-drivers_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/leuze-ros-drivers/leuze-ros-drivers-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/leuze-ros-drivers/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/leuze-ros-drivers/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
