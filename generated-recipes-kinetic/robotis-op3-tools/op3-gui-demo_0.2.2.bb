# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The op3_gui_demo is a GUI software to control ROBOTIS-OP3. Within this program, user can perform module settings, walking tuner, head joint control and play actions."
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Kayman <kmjung@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/op3_gui_demo"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "robotis_op3_tools"
ROS_BPN = "op3_gui_demo"

ROS_BUILD_DEPENDS = " \
    boost \
    cmake-modules \
    eigen-conversions \
    geometry-msgs \
    humanoid-nav-msgs \
    interactive-markers \
    libeigen \
    libqt4-dev \
    op3-online-walking-module-msgs \
    op3-walking-module-msgs \
    qt-build \
    robotis-controller-msgs \
    roscpp \
    roslib \
    sensor-msgs \
    std-msgs \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    cmake-modules \
    eigen-conversions \
    geometry-msgs \
    humanoid-nav-msgs \
    interactive-markers \
    libeigen \
    libqt4-dev \
    op3-online-walking-module-msgs \
    op3-walking-module-msgs \
    qt-build \
    robotis-controller-msgs \
    roscpp \
    roslib \
    sensor-msgs \
    std-msgs \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    cmake-modules \
    eigen-conversions \
    geometry-msgs \
    humanoid-nav-msgs \
    interactive-markers \
    libeigen \
    libqt4-dev \
    op3-navigation \
    op3-online-walking-module-msgs \
    op3-walking-module-msgs \
    qt-build \
    robotis-controller-msgs \
    roscpp \
    roslib \
    sensor-msgs \
    std-msgs \
    visualization-msgs \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/robotis_op3_tools-release/archive/release/kinetic/op3_gui_demo/0.2.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f0e0addcfb75a4a7a91be50efea55707"
SRC_URI[sha256sum] = "cd8b544daaa58d0475effd6dd9e477d972b3db7b19a2b5f5241f9fae1e06a440"
S = "${WORKDIR}/robotis_op3_tools-release-release-kinetic-op3_gui_demo-0.2.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('robotis-op3-tools', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('robotis-op3-tools', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-tools/robotis-op3-tools_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-tools/robotis-op3-tools-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-tools/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/robotis-op3-tools/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
