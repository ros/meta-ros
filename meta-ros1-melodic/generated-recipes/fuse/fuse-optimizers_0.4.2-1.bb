# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The fuse_optimizers package provides a set of optimizer implementations. An optimizer is the object responsible     for coordinating the sensors and motion model inputs, computing the optimal state values, and providing access to     to the optimal state via the publishers."
AUTHOR = "Stephen Williams <swilliams@locusrobotics.com>"
ROS_AUTHOR = "Stephen Williams <swilliams@locusrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fuse"
ROS_BPN = "fuse_optimizers"

ROS_BUILD_DEPENDS = " \
    diagnostic-updater \
    fuse-constraints \
    fuse-core \
    fuse-graphs \
    fuse-variables \
    pluginlib \
    roscpp \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-updater \
    fuse-constraints \
    fuse-core \
    fuse-graphs \
    fuse-variables \
    pluginlib \
    roscpp \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-updater \
    fuse-constraints \
    fuse-core \
    fuse-graphs \
    fuse-variables \
    pluginlib \
    roscpp \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    fuse-models \
    geometry-msgs \
    nav-msgs \
    roslint \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/locusrobotics/fuse-release/archive/release/melodic/fuse_optimizers/0.4.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/fuse_optimizers"
SRC_URI = "git://github.com/locusrobotics/fuse-release;${ROS_BRANCH};protocol=https"
SRCREV = "acbb60988fc94855696a61b2ff7fdab6dd4daad6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
