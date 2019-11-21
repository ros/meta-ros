# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "<p>This package does not only wrap <a href="http://www.openrtp.jp/openhrp3/en/index.html">OpenHRP3</a> but actually provides the built artifact from the code from its <a href="https://openrtp.jp/svn/hrg/openhrp">mainstream repository</a>. Being ROS-agnostic by itself, you can also use this via ROS together with the packages in <a href="http://www.ros.org/wiki/rtmros_common">rtmros_common</a> that bridge between two framework.</p>    <p><i>OpenHRP3 (Open Architecture Human-centered Robotics Platform version 3) is an integrated software platform for robot simulations and software developments. It allows the users to inspect an original robot model and control program by dynamics simulation. In addition, OpenHRP3 provides various software components and calculation libraries that can be used for robotics related software developments</i> (<a href="http://www.openrtp.jp/openhrp3/en/about.html">excerpts from here</a>). </p>    <p>The package version number is synchronized to that of mainstream, based on <a href="http://code.google.com/p/rtm-ros-robotics/issues/detail?id=165#c5">this decision</a>.</p>"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "AIST"
HOMEPAGE = "https://openrtp.jp/svn/hrg/openhrp/"
SECTION = "devel"
LICENSE = "EPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=b1456987590b6d6fb15d36f398651b8b"

ROS_CN = "openhrp3"
ROS_BPN = "openhrp3"

ROS_BUILD_DEPENDS = " \
    atlas \
    boost \
    collada-dom \
    doxygen \
    f2c \
    jpeg \
    jython \
    libeigen \
    libpng12-dev \
    libxml2 \
    openrtm-aist \
    python-omniorb \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
    pkgconfig-native \
"

ROS_EXPORT_DEPENDS = " \
    atlas \
    boost \
    collada-dom \
    f2c \
    jpeg \
    jython \
    libeigen \
    libpng12-dev \
    libxml2 \
    openrtm-aist \
    python-omniorb \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    atlas \
    boost \
    collada-dom \
    f2c \
    jpeg \
    jython \
    libeigen \
    libpng12-dev \
    libxml2 \
    openrtm-aist \
    python-omniorb \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/openhrp3-release/archive/release/kinetic/openhrp3/3.1.9-3.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b3501b6d40eade783d9c37cfd26f2c53"
SRC_URI[sha256sum] = "088129ba7f52bc58b011a0015d5f7a97b9f2b79489ab26aefb4e488035e772a0"
S = "${WORKDIR}/openhrp3-release-release-kinetic-openhrp3-3.1.9-3"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('openhrp3', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('openhrp3', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openhrp3/openhrp3_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openhrp3/openhrp3-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openhrp3/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/openhrp3/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
