# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "ROS driver for iRobot's Create and Roomba platforms, based on libcreate"
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
ROS_AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
HOMEPAGE = "http://wiki.ros.org/create_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "create_robot"
ROS_BPN = "create_driver"

ROS_BUILD_DEPENDS = " \
    create-msgs \
    diagnostic-msgs \
    diagnostic-updater \
    geometry-msgs \
    libcreate \
    nav-msgs \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    create-msgs \
    diagnostic-msgs \
    diagnostic-updater \
    geometry-msgs \
    libcreate \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    create-msgs \
    diagnostic-msgs \
    diagnostic-updater \
    geometry-msgs \
    libcreate \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf2-geometry-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/autonomylab/create_autonomy-release/archive/release/noetic/create_driver/2.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/create_driver"
SRC_URI = "git://github.com/autonomylab/create_autonomy-release;${ROS_BRANCH};protocol=https"
SRCREV = "e9025be91cfba6bb1ff99d6c2d2b42b19e0218bc"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
