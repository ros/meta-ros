# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "hector_map_server provides a service for retrieving the map, as well as for raycasting based obstacle queries (finds next obstacle in the map, given start and endpoint     in any tf coordinate frame)."
AUTHOR = "Johannes Meyer <meyer@fsr.tu-darmstadt.de>"
ROS_AUTHOR = "Stefan Kohlbrecher <kohlbrecher@sim.tu-darmstadt.de>"
HOMEPAGE = "http://ros.org/wiki/hector_map_server"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "hector_slam"
ROS_BPN = "hector_map_server"

ROS_BUILD_DEPENDS = " \
    hector-map-tools \
    hector-marker-drawing \
    hector-nav-msgs \
    nav-msgs \
    roscpp \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    hector-map-tools \
    hector-marker-drawing \
    hector-nav-msgs \
    nav-msgs \
    roscpp \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    hector-map-tools \
    hector-marker-drawing \
    hector-nav-msgs \
    nav-msgs \
    roscpp \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tu-darmstadt-ros-pkg-gbp/hector_slam-release/archive/release/melodic/hector_map_server/0.4.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/hector_map_server"
SRC_URI = "git://github.com/tu-darmstadt-ros-pkg-gbp/hector_slam-release;${ROS_BRANCH};protocol=https"
SRCREV = "916c47698be84624d233991dcaffc6bb47a76b5a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
