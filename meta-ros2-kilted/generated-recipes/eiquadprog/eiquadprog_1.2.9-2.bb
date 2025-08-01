# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_kilted
inherit ros_superflore_generated

DESCRIPTION = "Eiquadprog a QP solver using active sets"
AUTHOR = "Guilhem Saurel <guilhem.saurel@laas.fr>"
ROS_AUTHOR = "Gabriele Buondonno"
HOMEPAGE = "git@github.com:stack-of-tasks/eiquadprog.git"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "LGPLv3"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=b691248d2f70cdaeeaf13696ada5d47c"

ROS_CN = "eiquadprog"
ROS_BPN = "eiquadprog"

ROS_BUILD_DEPENDS = " \
    boost \
    doxygen \
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

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/eiquadprog-release/archive/release/kilted/eiquadprog/1.2.9-2.tar.gz
ROS_BRANCH ?= "branch=release/kilted/eiquadprog"
SRC_URI = "git://github.com/ros2-gbp/eiquadprog-release;${ROS_BRANCH};protocol=https"
SRCREV = "f29a4786fa1664a5c341601d6e0312a63ad1dc47"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
