# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "This package contains a C++ base class for URDF parsers."
AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
ROS_AUTHOR = "Ioan Sucan <isucan@gmail.com>"
HOMEPAGE = "https://github.com/ros2/urdf"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "urdf"
ROS_BPN = "urdf_parser_plugin"

ROS_BUILD_DEPENDS = " \
    urdfdom-headers \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    urdfdom-headers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

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

# matches with: https://github.com/ros2-gbp/urdf-release/archive/release/humble/urdf_parser_plugin/2.6.0-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/urdf_parser_plugin"
SRC_URI = "git://github.com/ros2-gbp/urdf-release;${ROS_BRANCH};protocol=https"
SRCREV = "ec11cfc4a436b162e092fb9486b3c055de5d93ea"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
