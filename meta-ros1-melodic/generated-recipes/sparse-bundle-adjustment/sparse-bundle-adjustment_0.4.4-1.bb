# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROS wrapper for the sparse bundle adjustment (sba) library (needed for slam_karto)"
AUTHOR = "Michael Ferguson <mfergs7@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=5;endline=5;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "sparse_bundle_adjustment"
ROS_BPN = "sparse_bundle_adjustment"

ROS_BUILD_DEPENDS = " \
    lapack \
    libeigen \
    openblas \
    roscpp \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    lapack \
    libeigen \
    openblas \
    roscpp \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    lapack \
    libeigen \
    openblas \
    roscpp \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/sparse_bundle_adjustment-release/archive/release/melodic/sparse_bundle_adjustment/0.4.4-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/sparse_bundle_adjustment"
SRC_URI = "git://github.com/ros-gbp/sparse_bundle_adjustment-release;${ROS_BRANCH};protocol=https"
SRCREV = "ad91f98ccb2004af80aa0f48ef3ea1feb09b006c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
