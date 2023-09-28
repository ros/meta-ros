# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "AprilTag detector library"
AUTHOR = "Max Krogius <mkrogius@umich.edu>"
ROS_AUTHOR = "Edwin Olson <ebolson@umich.edu>"
HOMEPAGE = "https://april.eecs.umich.edu/software/apriltag.html"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "apriltag"
ROS_BPN = "apriltag"

ROS_BUILD_DEPENDS = " \
    python3-numpy \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
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

# matches with: https://github.com/ros2-gbp/apriltag-release/archive/release/galactic/apriltag/3.1.5-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/apriltag"
SRC_URI = "git://github.com/ros2-gbp/apriltag-release;${ROS_BRANCH};protocol=https"
SRCREV = "de2b253d558f4e352524958e4ef8136965277dc1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
