# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Metapackage referencing tutorials related to rviz and visualization."
AUTHOR = "William Woodall <william@osrfoundation.org>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "http://ros.org/wiki/visualization_tutorials"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "visualization_tutorials"
ROS_BPN = "visualization_tutorials"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    interactive-marker-tutorials \
    librviz-tutorial \
    rviz-plugin-tutorials \
    rviz-python-tutorial \
    visualization-marker-tutorials \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    interactive-marker-tutorials \
    librviz-tutorial \
    rviz-plugin-tutorials \
    rviz-python-tutorial \
    visualization-marker-tutorials \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/visualization_tutorials-release/archive/release/noetic/visualization_tutorials/0.11.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/visualization_tutorials"
SRC_URI = "git://github.com/ros-gbp/visualization_tutorials-release;${ROS_BRANCH};protocol=https"
SRCREV = "253560163578f05c0fb51f583836ee8e9d1feb41"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
