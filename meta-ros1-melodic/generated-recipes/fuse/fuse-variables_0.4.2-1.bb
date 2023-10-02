# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The fuse_variables package provides a set of commonly used variable types, such as 2D and 3D positions,     orientations, velocities, and accelerations."
AUTHOR = "Stephen Williams <swilliams@locusrobotics.com>"
ROS_AUTHOR = "Stephen Williams <swilliams@locusrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fuse"
ROS_BPN = "fuse_variables"

ROS_BUILD_DEPENDS = " \
    ceres-solver \
    fuse-core \
    pluginlib \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ceres-solver \
    fuse-core \
    pluginlib \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ceres-solver \
    fuse-core \
    pluginlib \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslint \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/locusrobotics/fuse-release/archive/release/melodic/fuse_variables/0.4.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/fuse_variables"
SRC_URI = "git://github.com/locusrobotics/fuse-release;${ROS_BRANCH};protocol=https"
SRCREV = "b19ab5159b53ccccd6842dd1c509e4905aa23339"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
