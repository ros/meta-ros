# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Basic ROS support for the Robosense 3D LIDARs."
AUTHOR = "Abraham Monrroy <abrahammonrroy@yahoo.com>"
ROS_AUTHOR = "Tony Zhang <tony.zhang@robosense.cn>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "robosense"
ROS_BPN = "rslidar"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rslidar-driver \
    rslidar-msgs \
    rslidar-pointcloud \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rslidar-driver \
    rslidar-msgs \
    rslidar-pointcloud \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/CPFL/robosense-release/archive/release/melodic/rslidar/1.0.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rslidar"
SRC_URI = "git://github.com/CPFL/robosense-release;${ROS_BRANCH};protocol=https"
SRCREV = "e8bbb7b672692a6afed8c71441e977ab17d65409"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
