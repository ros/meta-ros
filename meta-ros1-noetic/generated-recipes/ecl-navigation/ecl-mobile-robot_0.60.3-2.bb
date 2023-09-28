# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Contains transforms (e.g. differential drive inverse kinematics)     for the various types of mobile robot platforms."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/ecl_mobile_robot"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ecl_navigation"
ROS_BPN = "ecl_mobile_robot"

ROS_BUILD_DEPENDS = " \
    ecl-build \
    ecl-errors \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ecl-build \
    ecl-errors \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecl-build \
    ecl-errors \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/yujinrobot-release/ecl_navigation-release/archive/release/noetic/ecl_mobile_robot/0.60.3-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ecl_mobile_robot"
SRC_URI = "git://github.com/yujinrobot-release/ecl_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "b26919c32fbfd19f837aadd098dedaca451bc44e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
