# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "This package retrieves data from url-format files such as http://,    ftp://, package:// file://, etc., and loads the data into memory.    The package:// url for ros packages is translated into a local    file:// url.  The resourse retriever was initially designed to load    mesh files into memory, but it can be used for any type of    data. The resource retriever is based on the the libcurl library."
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
HOMEPAGE = "http://ros.org/wiki/resource_retriever"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "resource_retriever"
ROS_BPN = "resource_retriever"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    ament-index-python \
    libcurl-vendor \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    ament-index-python \
    libcurl-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    ament-index-python \
    libcurl-vendor \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    python-cmake-module \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/resource_retriever-release/archive/release/humble/resource_retriever/3.1.0-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/resource_retriever"
SRC_URI = "git://github.com/ros2-gbp/resource_retriever-release;${ROS_BRANCH};protocol=https"
SRCREV = "5f209d5aeff799143958ad3fecf561444d4806df"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
