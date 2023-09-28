# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "The Kinematics and Dynamics Library (KDL) defines a tree structure    to represent the kinematic and dynamic parameters of a robot    mechanism. <tt>kdl_parser</tt> provides tools to construct a KDL    tree from an XML robot representation in URDF."
AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
ROS_AUTHOR = "Wim Meeussen <wim@willowgarage.com>"
HOMEPAGE = "https://github.com/ros2/kdl_parser"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kdl_parser"
ROS_BPN = "kdl_parser"

ROS_BUILD_DEPENDS = " \
    libtinyxml \
    orocos-kdl \
    tinyxml-vendor \
    urdf \
    urdfdom-headers \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    orocos-kdl \
    urdfdom-headers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libtinyxml \
    orocos-kdl \
    tinyxml-vendor \
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

# matches with: https://github.com/ros2-gbp/kdl_parser-release/archive/release/dashing/kdl_parser/2.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/kdl_parser"
SRC_URI = "git://github.com/ros2-gbp/kdl_parser-release;${ROS_BRANCH};protocol=https"
SRCREV = "6dafe81f637a455cb4ba8a591001b71da784c526"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
