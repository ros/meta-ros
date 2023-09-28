# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "ROS message definitions for Velodyne 3D LIDARs."
AUTHOR = "Josh Whitley <jwhitley@autonomoustuff.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://ros.org/wiki/velodyne_msgs"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "velodyne"
ROS_BPN = "velodyne_msgs"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    rosidl-default-generators \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    rosidl-default-runtime \
    std-msgs \
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

# matches with: https://github.com/ros-drivers-gbp/velodyne-release/archive/release/dashing/velodyne_msgs/2.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/velodyne_msgs"
SRC_URI = "git://github.com/ros-drivers-gbp/velodyne-release;${ROS_BRANCH};protocol=https"
SRCREV = "4c4a7fe0090410b1d278772cec1aecaf9ccc0b44"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
