# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "A support library for bindings between Eigen in C++ and Python, based on nanobind"
AUTHOR = "Guilhem Saurel <guilhem.saurel@laas.fr>"
ROS_AUTHOR = "Wilson Jallet"
HOMEPAGE = "https://github.com/Simple-Robotics/nanoeigenpy"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "nanoeigenpy"
ROS_BPN = "nanoeigenpy"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-nanobind-dev} \
    doxygen \
    git \
    libeigen \
    python3 \
    python3-numpy \
    python3-scipy \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-nanobind-dev} \
    libeigen \
    python3 \
    python3-numpy \
    python3-scipy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-nanobind-dev} \
    libeigen \
    python3 \
    python3-numpy \
    python3-scipy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/nanoeigenpy-release/archive/release/rolling/nanoeigenpy/0.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/nanoeigenpy"
SRC_URI = "git://github.com/ros2-gbp/nanoeigenpy-release;${ROS_BRANCH};protocol=https"
SRCREV = "0a24aef0b5a914938782209dc17597966ebdb6dc"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
