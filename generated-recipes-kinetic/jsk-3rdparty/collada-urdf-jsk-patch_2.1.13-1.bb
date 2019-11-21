# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "unaccepted patch for collada_urdf"
AUTHOR = "Yohei Kakiuchi <youhei@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/collada_urdf_jsk_patch"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_3rdparty"
ROS_BPN = "collada_urdf_jsk_patch"

ROS_BUILD_DEPENDS = " \
    angles \
    assimp-devel \
    class-loader \
    cmake-modules \
    collada-dom \
    collada-parser \
    collada-urdf \
    geometric-shapes \
    git \
    kdl-parser \
    libgts \
    mk \
    pluginlib \
    python-catkin-tools \
    resource-retriever \
    roscpp \
    rostest \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    assimp-devel \
    class-loader \
    collada-dom \
    collada-parser \
    collada-urdf \
    geometric-shapes \
    kdl-parser \
    libgts \
    pluginlib \
    python-catkin-tools \
    resource-retriever \
    roscpp \
    tf \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    assimp-devel \
    class-loader \
    collada-dom \
    collada-parser \
    collada-urdf \
    geometric-shapes \
    kdl-parser \
    libgts \
    pluginlib \
    python-catkin-tools \
    resource-retriever \
    roscpp \
    tf \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/jsk_3rdparty-release/archive/release/kinetic/collada_urdf_jsk_patch/2.1.13-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "bbdf1343b0ad05b93159945b0fa6f01f"
SRC_URI[sha256sum] = "262ab4dde9b037927b7c7e96e8915dc1e6096695e1711a047761a29b04a49a91"
S = "${WORKDIR}/jsk_3rdparty-release-release-kinetic-collada_urdf_jsk_patch-2.1.13-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('jsk-3rdparty', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('jsk-3rdparty', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jsk-3rdparty/jsk-3rdparty_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jsk-3rdparty/jsk-3rdparty-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jsk-3rdparty/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/jsk-3rdparty/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
