# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "hector_geotiff provides a node that can be used to save occupancy grid map, robot trajectory and object of interest data to RoboCup Rescue compliant GeoTiff images."
AUTHOR = "Johannes Meyer <meyer@fsr.tu-darmstadt.de>"
ROS_AUTHOR = "Stefan Kohlbrecher <kohlbrecher@sim.tu-darmstadt.de>"
HOMEPAGE = "http://ros.org/wiki/hector_geotiff"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "hector_slam"
ROS_BPN = "hector_geotiff"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libqt4-dev} \
    hector-map-tools \
    hector-nav-msgs \
    nav-msgs \
    pluginlib \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libqt4-dev} \
    hector-map-tools \
    hector-nav-msgs \
    nav-msgs \
    pluginlib \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libqt4-dev} \
    hector-map-tools \
    hector-nav-msgs \
    nav-msgs \
    pluginlib \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tu-darmstadt-ros-pkg-gbp/hector_slam-release/archive/release/melodic/hector_geotiff/0.4.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/hector_geotiff"
SRC_URI = "git://github.com/tu-darmstadt-ros-pkg-gbp/hector_slam-release;${ROS_BRANCH};protocol=https"
SRCREV = "aa34ecaa4b5b24a4cc3fb8ad2750951076d2d71e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
