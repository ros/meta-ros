# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "A meta-package to aggregate all the FlexBE packages"
AUTHOR = "Philipp Schillinger <philsplus@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/flexbe"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "flexbe_behavior_engine"
ROS_BPN = "flexbe_behavior_engine"

ROS_BUILD_DEPENDS = " \
    flexbe-core \
    flexbe-input \
    flexbe-mirror \
    flexbe-msgs \
    flexbe-onboard \
    flexbe-states \
    flexbe-testing \
    flexbe-widget \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    flexbe-core \
    flexbe-input \
    flexbe-mirror \
    flexbe-msgs \
    flexbe-onboard \
    flexbe-states \
    flexbe-testing \
    flexbe-widget \
"

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

# matches with: https://github.com/ros2-gbp/flexbe_behavior_engine-release/archive/release/humble/flexbe_behavior_engine/2.3.5-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/flexbe_behavior_engine"
SRC_URI = "git://github.com/ros2-gbp/flexbe_behavior_engine-release;${ROS_BRANCH};protocol=https"
SRCREV = "7742a0846527765a4073d67161c20c3b9ef36006"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
