# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "Provides a ublox_gps node for u-blox GPS receivers, messages, and serialization packages for the binary UBX protocol."
AUTHOR = "Veronica Lane <vmlane@alum.mit.edu>"
ROS_AUTHOR = "Johannes Meyer"
HOMEPAGE = "http://wiki.ros.org/ublox"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ublox"
ROS_BPN = "ublox"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ublox-gps \
    ublox-msgs \
    ublox-serialization \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ublox-release/archive/release/galactic/ublox/2.0.0-3.tar.gz
ROS_BRANCH ?= "branch=release/galactic/ublox"
SRC_URI = "git://github.com/ros2-gbp/ublox-release;${ROS_BRANCH};protocol=https"
SRCREV = "45b6ed473986b8c84ca81eef1e71610e3463559f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
