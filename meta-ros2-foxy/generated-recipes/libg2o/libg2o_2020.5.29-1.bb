# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "The libg2o library from http://openslam.org/g2o.html"
AUTHOR = "Christoph Rösmann <christoph.roesmann@tu-dortmund.de>"
ROS_AUTHOR = "Rainer Kuemmerle"
HOMEPAGE = "https://github.com/RainerKuemmerle/g2o"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "libg2o"
ROS_BPN = "libg2o"

ROS_BUILD_DEPENDS = " \
    libeigen \
    mesa \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
    mesa \
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

# matches with: https://github.com/ros2-gbp/libg2o-release/archive/release/foxy/libg2o/2020.5.29-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/libg2o"
SRC_URI = "git://github.com/ros2-gbp/libg2o-release;${ROS_BRANCH};protocol=https"
SRCREV = "d84a9c614c7e1dac3949ad51fb85a642462f0a1e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
