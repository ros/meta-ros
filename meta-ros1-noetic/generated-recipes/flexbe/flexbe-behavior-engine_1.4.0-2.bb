# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A meta-package to aggregate all the FlexBE packages"
AUTHOR = "Philipp Schillinger <schillin@kth.se>"
HOMEPAGE = "http://ros.org/wiki/flexbe"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "flexbe"
ROS_BPN = "flexbe_behavior_engine"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    flexbe-core \
    flexbe-input \
    flexbe-mirror \
    flexbe-msgs \
    flexbe-onboard \
    flexbe-states \
    flexbe-testing \
    flexbe-widget \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/flexbe/flexbe_behavior_engine-release/archive/release/noetic/flexbe_behavior_engine/1.4.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/flexbe_behavior_engine"
SRC_URI = "git://github.com/flexbe/flexbe_behavior_engine-release;${ROS_BRANCH};protocol=https"
SRCREV = "d8a5b26227716e95022eac50262dde6680028d47"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
