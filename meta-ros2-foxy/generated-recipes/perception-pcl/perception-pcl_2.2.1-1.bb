# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "PCL (Point Cloud Library) ROS interface stack. PCL-ROS is the preferred   bridge for 3D applications involving n-D Point Clouds and 3D geometry   processing in ROS."
AUTHOR = "Paul Bovbel <paul@bovbel.com>"
ROS_AUTHOR = "Open Perception"
HOMEPAGE = "http://ros.org/wiki/perception_pcl"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "perception_pcl"
ROS_BPN = "perception_pcl"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pcl-conversions \
    pcl-msgs \
    pcl-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/perception_pcl-release/archive/release/foxy/perception_pcl/2.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/perception_pcl"
SRC_URI = "git://github.com/ros2-gbp/perception_pcl-release;${ROS_BRANCH};protocol=https"
SRCREV = "8c7c28bbab236e351e6bdbf4eded8262f9eea9c8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
