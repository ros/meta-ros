# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package contains a tool to convert Unified Robot Description Format (URDF) documents into COLLAborative Design Activity (COLLADA) documents.      Implements robot-specific COLLADA extensions as defined by     http://openrave.programmingvision.com/index.php/Started:COLLADA"
AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
ROS_AUTHOR = "Tim Field"
HOMEPAGE = "http://ros.org/wiki/collada_urdf"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "collada_urdf"
ROS_BPN = "collada_urdf"

ROS_BUILD_DEPENDS = " \
    angles \
    assimp \
    cmake-modules \
    collada-dom \
    collada-parser \
    geometric-shapes \
    libeigen \
    resource-retriever \
    rosconsole \
    urdf \
    urdfdom \
    urdfdom-headers \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    urdfdom-headers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    collada-dom \
    collada-parser \
    geometric-shapes \
    resource-retriever \
    rosconsole \
    urdf \
    urdfdom \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/collada_urdf-release/archive/release/melodic/collada_urdf/1.12.13-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/collada_urdf"
SRC_URI = "git://github.com/ros-gbp/collada_urdf-release;${ROS_BRANCH};protocol=https"
SRCREV = "14659f91875c02c60397a9d8894458068c3cc1c8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
