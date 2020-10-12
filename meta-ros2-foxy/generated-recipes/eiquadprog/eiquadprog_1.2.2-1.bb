# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Eiquadprog a QP solver using active sets"
AUTHOR = "Olivier Stasse <ostasse@laas.fr>"
ROS_AUTHOR = "Gabriele Buondonno"
HOMEPAGE = "git@github.com:stack-of-tasks/eiquadprog.git"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=b691248d2f70cdaeeaf13696ada5d47c"

ROS_CN = "eiquadprog"
ROS_BPN = "eiquadprog"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_doxygen} \
    boost \
    git \
    graphviz \
    libeigen \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    graphviz \
    libeigen \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake \
    boost \
    graphviz \
    libeigen \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/stack-of-tasks/eiquadprog-ros-release/archive/release/foxy/eiquadprog/1.2.2-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/eiquadprog"
SRC_URI = "git://github.com/stack-of-tasks/eiquadprog-ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "e3b2e39e53cffb3cebd904cff0f17921b456ecef"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
