# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "assimp library"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=5;endline=5;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "jsk_3rdparty"
ROS_BPN = "assimp_devel"

ROS_BUILD_DEPENDS = " \
    boost \
    ca-certificates \
    git \
    mk \
    openssl \
    rosboost-cfg \
    rosbuild \
    unzip \
    zlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    zlib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    zlib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_3rdparty-release/archive/release/noetic/assimp_devel/2.1.21-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/assimp_devel"
SRC_URI = "git://github.com/tork-a/jsk_3rdparty-release;${ROS_BRANCH};protocol=https"
SRCREV = "aa1535a27ee452d62ab94cc8f263f6d0f99b7aa9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
