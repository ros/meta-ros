# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Methods to transform mesh_msgs"
AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
ROS_AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
HOMEPAGE = "http://wiki.ros.org/ros_mesh_tools/mesh_msgs_transform"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD-3"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=76ea7cd512d17201ff67e2488e8c4ce3"

ROS_CN = "mesh_tools"
ROS_BPN = "mesh_msgs_transform"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    libeigen \
    mesh-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    libeigen \
    mesh-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    libeigen \
    mesh-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/uos-gbp/mesh-tools/archive/release/noetic/mesh_msgs_transform/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mesh_msgs_transform"
SRC_URI = "git://github.com/uos-gbp/mesh-tools;${ROS_BRANCH};protocol=https"
SRCREV = "8baad9eb92decaf2b395d613e3165ac09b1ce5bd"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
