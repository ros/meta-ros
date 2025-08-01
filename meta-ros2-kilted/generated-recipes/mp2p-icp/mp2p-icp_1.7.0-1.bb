# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_kilted
inherit ros_superflore_generated

DESCRIPTION = "A repertory of multi primitive-to-primitive (MP2P) ICP algorithms in C++"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://github.com/MOLAorg/mp2p_icp"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=280b383e0b4a9ed1c76c2784614af882"

ROS_CN = "mp2p_icp"
ROS_BPN = "mp2p_icp"

ROS_BUILD_DEPENDS = " \
    mola-common \
    mrpt-libbase \
    mrpt-libgui \
    mrpt-libmaps \
    mrpt-libobs \
    mrpt-libposes \
    mrpt-libtclap \
    ros-environment \
    tbb \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    mola-common \
    mrpt-libbase \
    mrpt-libgui \
    mrpt-libmaps \
    mrpt-libobs \
    mrpt-libposes \
    mrpt-libtclap \
    tbb \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mola-common \
    mrpt-libbase \
    mrpt-libgui \
    mrpt-libmaps \
    mrpt-libobs \
    mrpt-libposes \
    mrpt-libtclap \
    tbb \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mp2p_icp-release/archive/release/kilted/mp2p_icp/1.7.0-1.tar.gz
ROS_BRANCH ?= "branch=release/kilted/mp2p_icp"
SRC_URI = "git://github.com/ros2-gbp/mp2p_icp-release;${ROS_BRANCH};protocol=https"
SRCREV = "1500df639cce05559b09d21f63fa8a79c384ea70"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
