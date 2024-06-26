# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "An extension of the Flexible Collision Library."
AUTHOR = "Joseph Mirabel <jmirabel@laas.fr>"
HOMEPAGE = "https://github.com/humanoid-path-planner/hpp-fcl"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "hpp-fcl"
ROS_BPN = "hpp-fcl"

ROS_BUILD_DEPENDS = " \
    assimp \
    boost \
    doxygen \
    eigenpy \
    git \
    libeigen \
    octomap \
    python3 \
    python3-lxml \
    python3-numpy \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    boost \
    eigenpy \
    libeigen \
    octomap \
    python3 \
    python3-numpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    boost \
    eigenpy \
    libeigen \
    octomap \
    python3 \
    python3-numpy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/hpp_fcl-release/archive/release/iron/hpp-fcl/2.4.4-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/hpp-fcl"
SRC_URI = "git://github.com/ros2-gbp/hpp_fcl-release;${ROS_BRANCH};protocol=https"
SRCREV = "ff3dd2f6fa193a13a3814963f79f0a7042a1dd23"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
