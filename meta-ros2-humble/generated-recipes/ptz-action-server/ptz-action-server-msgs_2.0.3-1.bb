# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Messages for controlling Pan-Tilt and Pan-Tilt-Zoom devices"
AUTHOR = "Chris Iverach-Brereton <civerachb@clearpathrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ptz_action_server"
ROS_BPN = "ptz_action_server_msgs"

ROS_BUILD_DEPENDS = " \
    action-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    action-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    action-msgs \
    rosidl-default-runtime \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/clearpath-gbp/ptz_action_server-release/archive/release/humble/ptz_action_server_msgs/2.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/ptz_action_server_msgs"
SRC_URI = "git://github.com/clearpath-gbp/ptz_action_server-release;${ROS_BRANCH};protocol=https"
SRCREV = "472eefd2ad604251fdfc1e92a90f10e7ada77553"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}