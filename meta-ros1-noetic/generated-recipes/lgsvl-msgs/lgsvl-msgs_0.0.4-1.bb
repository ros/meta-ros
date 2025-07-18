# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Message definitions for interfacing with the LGSVL Simulator for ROS and ROS 2."
AUTHOR = "Hadi Tabatabaee <hadi.tabatabaee@lge.com>"
ROS_AUTHOR = "David Uhm <david.uhm@lge.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "lgsvl_msgs"
ROS_BPN = "lgsvl_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    ros-environment \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/lgsvl/lgsvl_msgs-release/archive/release/noetic/lgsvl_msgs/0.0.4-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/lgsvl_msgs"
SRC_URI = "git://github.com/lgsvl/lgsvl_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "9fe3a58c36abf1e42ed3cf8395c52fa6a57ff0e0"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
