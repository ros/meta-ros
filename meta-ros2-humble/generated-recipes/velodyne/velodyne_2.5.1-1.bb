# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Basic ROS support for the Velodyne 3D LIDARs."
AUTHOR = "Josh Whitley <whitleysoftwareservices@gmail.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://www.ros.org/wiki/velodyne"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "velodyne"
ROS_BPN = "velodyne"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    velodyne-driver \
    velodyne-laserscan \
    velodyne-msgs \
    velodyne-pointcloud \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/velodyne-release/archive/release/humble/velodyne/2.5.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/velodyne"
SRC_URI = "git://github.com/ros2-gbp/velodyne-release;${ROS_BRANCH};protocol=https"
SRCREV = "725738bb4c75beb774207fbc67ec2286e9420ad8"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
