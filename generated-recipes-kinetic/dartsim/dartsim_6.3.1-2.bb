# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "DART (Dynamic Animation and Robotics Toolkit) is a collaborative,     cross-platform, open source library created by the Georgia Tech Graphics     Lab and Humanoid Robotics Lab, with ongoing support by the University     of Washington Personal Robotics Lab and Open Robotics. DART provides data     structures and algorithms for kinematic and dynamic applications in robotics     and computer animation."
AUTHOR = "Michael X. Grey <grey@openrobotics.org>"
ROS_AUTHOR = "Jeongseok Lee <jslee02@gmail.com>"
HOMEPAGE = "http://dartsim.github.io/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=23;endline=23;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dartsim"
ROS_BPN = "dartsim"

ROS_BUILD_DEPENDS = " \
    assimp \
    boost \
    bullet \
    fcl \
    freeglut \
    libeigen \
    libflann-dev \
    libtinyxml \
    libtinyxml2 \
    libxi-dev \
    libxmu-dev \
    pkgconfig \
    urdfdom \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    boost \
    bullet \
    fcl \
    freeglut \
    libeigen \
    libflann-dev \
    libtinyxml \
    libtinyxml2 \
    libxi-dev \
    libxmu-dev \
    urdfdom \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    boost \
    bullet \
    catkin \
    fcl \
    freeglut \
    libeigen \
    libflann-dev \
    libtinyxml \
    libtinyxml2 \
    libxi-dev \
    libxmu-dev \
    urdfdom \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/dartsim/ros-dartsim-release/archive/release/kinetic/dartsim/6.3.1-2.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e519e66526296644bd575dd30d6a8a3c"
SRC_URI[sha256sum] = "81551748e5acdff192a6eb0990ea9811e96befaed0745201307e3cfc0f73a334"
S = "${WORKDIR}/ros-dartsim-release-release-kinetic-dartsim-6.3.1-2"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('dartsim', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('dartsim', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dartsim/dartsim_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dartsim/dartsim-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dartsim/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dartsim/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
