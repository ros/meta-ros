# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Robust and efficient coverage paths for autonomous agricultural vehicles.     A modular and extensible Coverage Path Planning library"
AUTHOR = "Gonzalo Mier <gonzalo.miermunoz@wur.nl>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD-3"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=76ea7cd512d17201ff67e2488e8c4ce3"

ROS_CN = "fields2cover"
ROS_BPN = "fields2cover"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libgdal-dev} \
    boost \
    geos \
    git \
    gtest \
    libeigen \
    libtinyxml2 \
    ortools-vendor \
    python3 \
    swig \
    tbb \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libgdal-dev} \
    boost \
    geos \
    git \
    gtest \
    libeigen \
    libtinyxml2 \
    ortools-vendor \
    python3 \
    swig \
    tbb \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libgdal-dev} \
    boost \
    geos \
    git \
    gtest \
    libeigen \
    libtinyxml2 \
    ortools-vendor \
    python3 \
    python3-matplotlib \
    python3-tkinter \
    swig \
    tbb \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
    lcov \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/fields2cover-release/archive/release/humble/fields2cover/2.0.0-11.tar.gz
ROS_BRANCH ?= "branch=release/humble/fields2cover"
SRC_URI = "git://github.com/ros2-gbp/fields2cover-release;${ROS_BRANCH};protocol=https"
SRCREV = "b84ffc8b2b8aba8cbaa385f58f6257a83e5d0c44"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
