# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "<p>       ROS-Industrial support for the ABB IRB 4400 (and variants).     </p>     <p>       This package contains configuration data, 3D models and launch files       for ABB IRB 4400 manipulators. This currently includes the L30.     </p>     <p>       Joint limits and max joint velocities are based on the information in the       <a href="http://www05.abb.com/global/scot/scot352.nsf/veritydisplay/c90b98aaa057bd6ec12576cb00528ef6/$file/Product%20specification%204400%20M99%20BWOS3.2.pdf">       ABB IRB 4400 product specification document</a> (Article No: 3HAC 8770-1).       All urdfs / xacros are based on the default motion and joint velocity       limits, unless noted otherwise (ie: no support for high speed joints,       extended / limited motion ranges or other options).     </p>     <p>       Before using any of the configuration files and / or meshes included       in this package, be sure to check they are correct for the particular       robot model and configuration you intend to use them with.     </p>"
AUTHOR = "Levi Armstrong (Southwest Research Institute) <levi.armstrong@swri.org>"
ROS_AUTHOR = "Dan Solomon"
HOMEPAGE = "http://wiki.ros.org/abb_irb4400_support"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=29;endline=29;md5=c93e37fc0c6f510db5735eb91dcc1550"

ROS_CN = "abb"
ROS_BPN = "abb_irb4400_support"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    abb-driver \
    abb-resources \
    joint-state-publisher \
    robot-state-publisher \
    rviz \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-industrial-release/abb-release/archive/release/kinetic/abb_irb4400_support/1.3.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "397b1698ed101dd7b3077193844ffb4d"
SRC_URI[sha256sum] = "b0471e57a02bb912e06f62325da8bbb1a3a6d6719805fbe85faca43a03b687ac"
S = "${WORKDIR}/abb-release-release-kinetic-abb_irb4400_support-1.3.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('abb', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('abb', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/abb_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/abb-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/abb/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
