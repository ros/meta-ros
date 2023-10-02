# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Base dependencies and support libraries for ROS.     roslib contains many of the common data structures and tools that are shared across ROS client library implementations."
AUTHOR = "Michel Hidalgo <michel@ekumenlabs.com>"
ROS_AUTHOR = "Ken Conley <kwc@willowgarage.com>"
HOMEPAGE = "http://wiki.ros.org/roslib"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros"
ROS_BPN = "roslib"

ROS_BUILD_DEPENDS = " \
    boost \
    rospack \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    python3-setuptools-native \
"

ROS_EXPORT_DEPENDS = " \
    rospack \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    catkin \
    python3-rospkg \
    ros-environment \
    rospack \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    boost \
    rosmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/ros-release/archive/release/noetic/roslib/1.15.8-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/roslib"
SRC_URI = "git://github.com/ros-gbp/ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "1da93b6b298a3ee55d36653406b334121afc7a96"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
