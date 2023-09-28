# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The libg2o library from http://openslam.org/g2o.html"
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
ROS_AUTHOR = "Rainer Kuemmerle"
HOMEPAGE = "https://github.com/RainerKuemmerle/g2o"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "libg2o"
ROS_BPN = "libg2o"

ROS_BUILD_DEPENDS = " \
    boost \
    libeigen \
    mesa \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    catkin \
    libeigen \
    mesa \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    catkin \
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

# matches with: https://github.com/ros-gbp/libg2o-release/archive/release/melodic/libg2o/2018.3.25-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/libg2o"
SRC_URI = "git://github.com/ros-gbp/libg2o-release;${ROS_BRANCH};protocol=https"
SRCREV = "4bead40a8a6a5adeaa1f34d364ecf3aeaaac9e68"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
