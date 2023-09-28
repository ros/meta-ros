# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "flexbe_widget implements some smaller scripts for the behavior engine."
AUTHOR = "Philipp Schillinger <schillin@kth.se>"
ROS_AUTHOR = "Philipp Schillinger"
HOMEPAGE = "http://ros.org/wiki/flexbe_widget"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "flexbe"
ROS_BPN = "flexbe_widget"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    flexbe-core \
    flexbe-mirror \
    flexbe-msgs \
    flexbe-onboard \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    flexbe-core \
    flexbe-mirror \
    flexbe-msgs \
    flexbe-onboard \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/FlexBE/flexbe_behavior_engine-release/archive/release/melodic/flexbe_widget/1.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/flexbe_widget"
SRC_URI = "git://github.com/FlexBE/flexbe_behavior_engine-release;${ROS_BRANCH};protocol=https"
SRCREV = "9b2209c7790a95a7f85f0cccc1e057fd7718426c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
