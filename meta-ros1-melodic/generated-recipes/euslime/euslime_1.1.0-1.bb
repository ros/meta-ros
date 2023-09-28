# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "EusLisp meets SLIME"
AUTHOR = "Guilherme de Campos Affonso <affonso@jsk.imi.i.u-tokyo.ac.jp>"
ROS_AUTHOR = "Yuki Furuta"
HOMEPAGE = "https://github.com/jsk-ros-pkg/euslime"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "euslime"
ROS_BPN = "euslime"

ROS_BUILD_DEPENDS = " \
    catkin-virtualenv \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roseus \
    slime-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roseus \
    slime-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/jsk-ros-pkg/euslime-release/archive/release/melodic/euslime/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/euslime"
SRC_URI = "git://github.com/jsk-ros-pkg/euslime-release;${ROS_BRANCH};protocol=https"
SRCREV = "f2eb1d1b794561a5f94cad810d98c11544e01e7f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
