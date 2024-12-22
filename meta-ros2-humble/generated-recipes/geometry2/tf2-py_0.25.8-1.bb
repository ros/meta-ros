# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The tf2_py package"
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Tully Foote <tfoote@osrfoundation.org>"
HOMEPAGE = "http://ros.org/wiki/tf2_py"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry2"
ROS_BPN = "tf2_py"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    tf2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    python-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    tf2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    rclpy \
    rpyutils \
    tf2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/geometry2-release/archive/release/humble/tf2_py/0.25.8-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/tf2_py"
SRC_URI = "git://github.com/ros2-gbp/geometry2-release;${ROS_BRANCH};protocol=https"
SRCREV = "4ad94e2f3d7d49ff6b09b9992f27a1fa43d52bfe"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
