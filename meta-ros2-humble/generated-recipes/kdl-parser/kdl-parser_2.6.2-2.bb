# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The Kinematics and Dynamics Library (KDL) defines a tree structure    to represent the kinematic and dynamic parameters of a robot    mechanism. <tt>kdl_parser</tt> provides tools to construct a KDL    tree from an XML robot representation in URDF."
AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
ROS_AUTHOR = "Wim Meeussen <wim@willowgarage.com>"
HOMEPAGE = "https://github.com/ros2/kdl_parser"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kdl_parser"
ROS_BPN = "kdl_parser"

ROS_BUILD_DEPENDS = " \
    orocos-kdl-vendor \
    urdf \
    urdfdom-headers \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    urdfdom-headers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    urdf \
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

# matches with: https://github.com/ros2-gbp/kdl_parser-release/archive/release/humble/kdl_parser/2.6.2-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/kdl_parser"
SRC_URI = "git://github.com/ros2-gbp/kdl_parser-release;${ROS_BRANCH};protocol=https"
SRCREV = "0d6b0e7f3f051ed1221ae8e44f6493ffc2e4a039"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
