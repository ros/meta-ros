# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package contains sensor related launch files.     The package also includes a node for assembling Laserscan(LaserScan to PointCloud)"
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Zerom <zerom@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/thormang3_sensors"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "thormang3_ppc"
ROS_BPN = "thormang3_sensors"

ROS_BUILD_DEPENDS = " \
    laser-assembler \
    pcl \
    pcl-conversions \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    laser-assembler \
    pcl \
    pcl-conversions \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    laser-assembler \
    laser-filters \
    pcl \
    pcl-conversions \
    realsense-camera \
    rgbd-launch \
    roscpp \
    sensor-msgs \
    std-msgs \
    uvc-camera \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/ROBOTIS-THORMANG-PPC-release/archive/release/kinetic/thormang3_sensors/0.2.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "37aed9f8fa59444ef9298aa0e98c110e"
SRC_URI[sha256sum] = "085916adfb99845fc7dd2004351c71c84d7b26a25340825b82a4343ade995606"
S = "${WORKDIR}/ROBOTIS-THORMANG-PPC-release-release-kinetic-thormang3_sensors-0.2.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('thormang3-ppc', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('thormang3-ppc', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/thormang3-ppc/thormang3-ppc_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/thormang3-ppc/thormang3-ppc-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/thormang3-ppc/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/thormang3-ppc/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
