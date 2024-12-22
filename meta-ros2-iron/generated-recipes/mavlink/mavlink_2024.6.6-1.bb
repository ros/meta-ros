# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "MAVLink message marshaling library.   This package provides C-headers and C++11 library   for both 1.0 and 2.0 versions of protocol.    For pymavlink use separate install via rosdep (python-pymavlink)."
AUTHOR = "Vladimir Ermakov <vooon341@gmail.com>"
ROS_AUTHOR = "Lorenz Meier"
HOMEPAGE = "https://mavlink.io/en/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "LGPLv3"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=b691248d2f70cdaeeaf13696ada5d47c"

ROS_CN = "mavlink"
ROS_BPN = "mavlink"

ROS_BUILD_DEPENDS = " \
    python3 \
    python3-future \
    python3-lxml \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    cmake-native \
    ros-environment-native \
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

# matches with: https://github.com/ros2-gbp/mavlink-gbp-release/archive/release/iron/mavlink/2024.6.6-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/mavlink"
SRC_URI = "git://github.com/ros2-gbp/mavlink-gbp-release;${ROS_BRANCH};protocol=https"
SRCREV = "2cdf892c4865a4503bddc3d4912444ba608f54b2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
