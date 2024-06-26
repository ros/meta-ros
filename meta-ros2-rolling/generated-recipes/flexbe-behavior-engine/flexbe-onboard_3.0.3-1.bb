# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "flexbe_onboard implements the robot-side of the behavior engine from where all behaviors are started."
AUTHOR = "Philipp Schillinger <philsplus@gmail.com>"
ROS_AUTHOR = "Philipp Schillinger"
HOMEPAGE = "http://ros.org/wiki/flexbe_core"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "flexbe_behavior_engine"
ROS_BPN = "flexbe_onboard"

ROS_BUILD_DEPENDS = " \
    flexbe-core \
    flexbe-msgs \
    flexbe-states \
    launch-ros \
    rclpy \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    flexbe-core \
    flexbe-msgs \
    flexbe-states \
    launch-ros \
    rclpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    flexbe-core \
    flexbe-msgs \
    flexbe-states \
    launch-ros \
    rclpy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    launch-testing \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/flexbe_behavior_engine-release/archive/release/rolling/flexbe_onboard/3.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/flexbe_onboard"
SRC_URI = "git://github.com/ros2-gbp/flexbe_behavior_engine-release;${ROS_BRANCH};protocol=https"
SRCREV = "c7da50d27cb4e95958c27128d2cc2d8f140cc73c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
