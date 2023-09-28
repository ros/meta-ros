# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "ublox_serialization provides header files for serialization of ROS messages to and from u-blox message format."
AUTHOR = "Veronica Lane <vmlane@alum.mit.edu>"
ROS_AUTHOR = "Johannes Meyer"
HOMEPAGE = "http://ros.org/wiki/ublox"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ublox"
ROS_BPN = "ublox_serialization"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/KumarRobotics/ublox-release/archive/release/foxy/ublox_serialization/2.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/ublox_serialization"
SRC_URI = "git://github.com/KumarRobotics/ublox-release;${ROS_BRANCH};protocol=https"
SRCREV = "90c3853a662ca9d682e3e420b3ca0a62e42ef026"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
