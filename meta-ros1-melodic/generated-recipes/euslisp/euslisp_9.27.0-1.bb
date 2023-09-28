# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "EusLisp is an integrated programming system for the   research on intelligent robots based on Common Lisp and   Object-Oriented programming"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Toshihiro Matsui"
HOMEPAGE = "http://euslisp.github.io/EusLisp/manual.html"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "euslisp"
ROS_BPN = "euslisp"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libpq-dev} \
    ${ROS_UNRESOLVED_DEP-xfonts-100dpi} \
    ${ROS_UNRESOLVED_DEP-xfonts-75dpi} \
    cmake-modules \
    jpeg \
    libpng \
    libx11 \
    libxext \
    mesa \
    mk \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libpq-dev} \
    ${ROS_UNRESOLVED_DEP-xfonts-100dpi} \
    ${ROS_UNRESOLVED_DEP-xfonts-75dpi} \
    jpeg \
    libpng \
    libx11 \
    libxext \
    mesa \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libpq-dev} \
    ${ROS_UNRESOLVED_DEP-xfonts-100dpi} \
    ${ROS_UNRESOLVED_DEP-xfonts-75dpi} \
    jpeg \
    libpng \
    libx11 \
    libxext \
    mesa \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/euslisp-release/archive/release/melodic/euslisp/9.27.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/euslisp"
SRC_URI = "git://github.com/tork-a/euslisp-release;${ROS_BRANCH};protocol=https"
SRCREV = "502fddfabb05d0abd041309f8cc4dab94d637357"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
