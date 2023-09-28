# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Bindings between Numpy and Eigen using Boost.Python"
AUTHOR = "Justin Carpentier <justin.carpentier@inria.fr>"
ROS_AUTHOR = "Justin Carpentier"
HOMEPAGE = "https://github.com/stack-of-tasks/eigenpy"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "eigenpy"
ROS_BPN = "eigenpy"

ROS_BUILD_DEPENDS = " \
    boost \
    doxygen \
    git \
    libeigen \
    python3 \
    python3-numpy \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    libeigen \
    python3 \
    python3-numpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake \
    boost \
    libeigen \
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

# matches with: https://github.com/ipab-slmc/eigenpy_catkin-release/archive/release/foxy/eigenpy/2.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/eigenpy"
SRC_URI = "git://github.com/ipab-slmc/eigenpy_catkin-release;${ROS_BRANCH};protocol=https"
SRCREV = "46f03b60eda8e00b79640be905e053c876d35d45"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
