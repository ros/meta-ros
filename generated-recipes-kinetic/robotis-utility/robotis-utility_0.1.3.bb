# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS packages for the ROBOTIS Utility (meta package)"
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Zerom <zerom@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/robotis_utility"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "robotis_utility"
ROS_BPN = "robotis_utility"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ros-madplay-player \
    ros-mpg321-player \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/ROBOTIS-Utility-release/archive/release/kinetic/robotis_utility/0.1.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "27c1343c1b69e35fff09c5ee39ee120f"
SRC_URI[sha256sum] = "5247743fab258a1a79a71b20ad0b472e757b9d8762faba9c1941e07fb6ff8721"
S = "${WORKDIR}/ROBOTIS-Utility-release-release-kinetic-robotis_utility-0.1.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robotis-utility', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robotis-utility', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-utility/robotis-utility_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-utility/robotis-utility-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-utility/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-utility/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
