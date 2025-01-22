# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "An extension of the Flexible Collision Library."
AUTHOR = "Joseph Mirabel <jmirabel@laas.fr>"
HOMEPAGE = "https://github.com/coal-library/coal"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "coal"
ROS_BPN = "coal"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    assimp \
    boost \
    doxygen \
    eigenpy \
    git \
    libeigen \
    python3 \
    python3-lxml \
    python3-numpy \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    assimp \
    boost \
    eigenpy \
    libeigen \
    python3 \
    python3-numpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    assimp \
    boost \
    eigenpy \
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

# matches with: https://github.com/ros2-gbp/coal-release/archive/release/humble/coal/3.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/coal"
SRC_URI = "git://github.com/ros2-gbp/coal-release;${ROS_BRANCH};protocol=https"
SRCREV = "5e3abe21f12c693ddc828e4ff0ab7550be5ee2c4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
