# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "The backward_ros package is a ros wrapper of backward-cpp from https://github.com/bombela/backward-cpp"
AUTHOR = "Victor López <victor.lopez@pal-robotics.com>"
HOMEPAGE = "https://github.com/pal-robotics/backward_ros"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "backward_ros"
ROS_BPN = "backward_ros"

ROS_BUILD_DEPENDS = " \
    elfutils \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    elfutils \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    elfutils \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/backward_ros-release/archive/release/rolling/backward_ros/1.0.5-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/backward_ros"
SRC_URI = "git://github.com/ros2-gbp/backward_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "7385b7bf6be40bc277b3a73c5ca32104dfb47ea0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
