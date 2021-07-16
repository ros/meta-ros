# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The Kinematics and Dynamics Library (KDL) defines a tree structure    to represent the kinematic and dynamic parameters of a robot    mechanism. <tt>kdl_parser</tt> provides tools to construct a KDL    tree from an XML robot representation in URDF."
AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
ROS_AUTHOR = "Wim Meeussen <wim@willowgarage.com>"
HOMEPAGE = "http://ros.org/wiki/kdl_parser"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kdl_parser"
ROS_BPN = "kdl_parser"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    libtinyxml \
    libtinyxml2 \
    orocos-kdl \
    rosconsole \
    urdf \
    urdfdom-headers \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libtinyxml \
    libtinyxml2 \
    orocos-kdl \
    urdf \
    urdfdom-headers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libtinyxml \
    libtinyxml2 \
    orocos-kdl \
    rosconsole \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roscpp \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/kdl_parser-release/archive/release/melodic/kdl_parser/1.13.1-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/kdl_parser"
SRC_URI = "git://github.com/ros-gbp/kdl_parser-release;${ROS_BRANCH};protocol=https"
SRCREV = "62566827317dc1dfe62b0c04eacf6be202e1f353"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
