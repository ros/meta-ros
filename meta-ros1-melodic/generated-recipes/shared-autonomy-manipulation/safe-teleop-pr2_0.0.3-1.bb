# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Launch files for running safe_teleop_base on pr2"
AUTHOR = "Charles DuHadway (maintained by Benjamin Pitzer) <foo@foo.com>"
HOMEPAGE = "http://ros.org/wiki/safe_teleop_pr2"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "shared_autonomy_manipulation"
ROS_BPN = "safe_teleop_pr2"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joy \
    pr2-teleop \
    safe-teleop-base \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joy \
    pr2-teleop \
    safe-teleop-base \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/shared_autonomy_manipulation-release/archive/release/melodic/safe_teleop_pr2/0.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/safe_teleop_pr2"
SRC_URI = "git://github.com/ros-gbp/shared_autonomy_manipulation-release;${ROS_BRANCH};protocol=https"
SRCREV = "6074a6e39b22719ef04a45520d1f5e108ada4aee"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
