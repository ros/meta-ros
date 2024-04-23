# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The mrpt_map is able to publish a mrpt map as ros occupancy grid like the map_server"
AUTHOR = "Markus Bader <markus.bader@tuwien.ac.at>"
HOMEPAGE = "https://wiki.ros.org/mrpt_map"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrpt_navigation"
ROS_BPN = "mrpt_map"

ROS_BUILD_DEPENDS = " \
    mrpt2 \
    nav-msgs \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    mrpt2 \
    nav-msgs \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mrpt2 \
    nav-msgs \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/mrpt-ros-pkg-release/mrpt_navigation-release/archive/release/noetic/mrpt_map/1.0.5-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mrpt_map"
SRC_URI = "git://github.com/mrpt-ros-pkg-release/mrpt_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "c6010f14ed4497f5aa2f9f770a20221a713ae81a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}