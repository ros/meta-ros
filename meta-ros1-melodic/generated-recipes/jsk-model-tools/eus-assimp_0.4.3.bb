# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "eus_assimp"
AUTHOR = "Yohei Kakiuchi <youhei@jsk.imi.i.u-tokyo.ac.jp>"
ROS_AUTHOR = "Yohei Kakiuchi <youhei@jsk.imi.i.u-tokyo.ac.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_model_tools"
ROS_BPN = "eus_assimp"

ROS_BUILD_DEPENDS = " \
    assimp-devel \
    euslisp \
    pkgconfig \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp-devel \
    roseus \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp-devel \
    roseus \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_model_tools-release/archive/release/melodic/eus_assimp/0.4.3-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/eus_assimp"
SRC_URI = "git://github.com/tork-a/jsk_model_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "f8ee5e8e1b0b58aa5e7cf15b513c794c423ba259"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
