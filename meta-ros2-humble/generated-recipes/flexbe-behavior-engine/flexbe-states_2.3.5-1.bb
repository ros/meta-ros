# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "flexbe_states provides a collection of common generic predefined states."
AUTHOR = "Philipp Schillinger <philsplus@gmail.com>"
ROS_AUTHOR = "Philipp Schillinger"
HOMEPAGE = "http://ros.org/wiki/flexbe_core"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "flexbe_behavior_engine"
ROS_BPN = "flexbe_states"

ROS_BUILD_DEPENDS = " \
    flexbe-core \
    flexbe-msgs \
    flexbe-testing \
    rclpy \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    flexbe-core \
    flexbe-msgs \
    flexbe-testing \
    rclpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    flexbe-core \
    flexbe-msgs \
    flexbe-testing \
    rclpy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    geometry-msgs \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/flexbe_behavior_engine-release/archive/release/humble/flexbe_states/2.3.5-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/flexbe_states"
SRC_URI = "git://github.com/ros2-gbp/flexbe_behavior_engine-release;${ROS_BRANCH};protocol=https"
SRCREV = "226b364efbf26aa67256c5ba54939189993839fd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
