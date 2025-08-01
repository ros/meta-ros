# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The pluginlib package provides tools for writing and dynamically loading plugins using the ROS build infrastructure.     To work, these tools require plugin providers to register their plugins in the package.xml of their package."
AUTHOR = "Steven! Ragnarök <stevenragnarok@osrfoundation.org>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://www.ros.org/wiki/pluginlib"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pluginlib"
ROS_BPN = "pluginlib"

ROS_BUILD_DEPENDS = " \
    boost \
    class-loader \
    cmake-modules \
    libtinyxml2 \
    rosconsole \
    roslib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    class-loader \
    libtinyxml2 \
    rosconsole \
    roslib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    class-loader \
    libtinyxml2 \
    rosconsole \
    roslib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/pluginlib-release/archive/release/noetic/pluginlib/1.13.2-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pluginlib"
SRC_URI = "git://github.com/ros-gbp/pluginlib-release;${ROS_BRANCH};protocol=https"
SRCREV = "3f8c4c1bf113e9f4e07e80615b4a6be8a62feb95"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
