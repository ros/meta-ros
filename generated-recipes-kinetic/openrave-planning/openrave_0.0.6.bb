# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "In order to use, please add the following line in your bashrc:"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Rosen Diankov (rosen.diankov@gmail.com)"
HOMEPAGE = "http://openrave.org"
SECTION = "devel"
LICENSE = "GPL-1 & Version-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=41baa4458249ce4ae89af8af6e81c7db"

ROS_CN = "openrave_planning"
ROS_BPN = "openrave"

ROS_BUILD_DEPENDS = " \
    assimp \
    boost \
    bullet \
    collada-dom \
    ffmpeg \
    git \
    ipython \
    lapack \
    libglew-dev \
    libogg \
    libpcre \
    libqt4 \
    libsoqt4-dev \
    libx264-dev \
    libxml2 \
    opende \
    pcre-dev \
    python \
    python-h5py \
    python-numpy \
    python-scipy \
    python-sympy \
    qhull \
    std-msgs \
    zlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    boost \
    bullet \
    collada-dom \
    collada-robots \
    ffmpeg \
    ipython \
    lapack \
    libglew-dev \
    libogg \
    libpcre \
    libqt4 \
    libsoqt4-dev \
    libx264-dev \
    opende \
    pcre-dev \
    python \
    python-h5py \
    python-numpy \
    python-scipy \
    python-sympy \
    qhull \
    std-msgs \
    zlib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    boost \
    bullet \
    collada-dom \
    collada-robots \
    ffmpeg \
    ipython \
    lapack \
    libglew-dev \
    libogg \
    libpcre \
    libqt4 \
    libsoqt4-dev \
    libx264-dev \
    opende \
    pcre-dev \
    python \
    python-h5py \
    python-numpy \
    python-scipy \
    python-sympy \
    qhull \
    std-msgs \
    zlib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/openrave_planning-release/archive/release/kinetic/openrave/0.0.6-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1884e7313111168b86dc512d6bc3d1ad"
SRC_URI[sha256sum] = "dad9fd8dc17811bdc5f3cfc920441e422bc94a57c3522cfd9c7f3bedd29e49c4"
S = "${WORKDIR}/openrave_planning-release-release-kinetic-openrave-0.0.6-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('openrave-planning', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('openrave-planning', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/openrave-planning_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/openrave-planning-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openrave-planning/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
