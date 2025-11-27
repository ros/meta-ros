# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "A metapackage to bring in the default packages second generation Transform Library in ros, tf2."
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "Tully Foote <tfoote@osrfoundation.org>"
HOMEPAGE = "http://www.ros.org/wiki/geometry2"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry2"
ROS_BPN = "geometry2"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    tf2\
    tf2-bullet\
    tf2-eigen\
    tf2-eigen-kdl\
    tf2-geometry-msgs\
    tf2-kdl\
    tf2-msgs\
    tf2-py\
    tf2-ros\
    tf2-sensor-msgs\
    tf2-tools\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/geometry2.git;${ROS_BRANCH};protocol=https"
SRCREV = "ef97ae6e36a2ab3d0377d937a6b452b3a3bc789c"
S = "${WORKDIR}/git/geometry2"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
