# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package contains the C++ interfaces to the PR2 hardware   components that are controlled over EtherCAT. This includes the   motors and encoders needed to control the PR2 mechanism, as well as   components like the pressure sensors in the fingertips, camera   triggers, etc... All of the hardware components in this interface are   directly available to the controllers inside the hard realtime   control loop."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Eric Berger berger@willowgarage.com"
HOMEPAGE = "http://ros.org/wiki/pr2_hardware_interface"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_mechanism"
ROS_BPN = "pr2_hardware_interface"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_mechanism-release/archive/release/noetic/pr2_hardware_interface/1.8.18-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_hardware_interface"
SRC_URI = "git://github.com/pr2-gbp/pr2_mechanism-release;${ROS_BRANCH};protocol=https"
SRCREV = "455424f7e21ccb0289cf49f4da59bc5353b1f740"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
