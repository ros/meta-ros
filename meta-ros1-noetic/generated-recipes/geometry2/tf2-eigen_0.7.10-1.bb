# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "tf2_eigen"
AUTHOR = "Koji Terada <terakoji@gmail.com>"
ROS_AUTHOR = "Koji Terada"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry2"
ROS_BPN = "tf2_eigen"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    geometry-msgs \
    libeigen \
    tf2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    libeigen \
    tf2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    tf2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/geometry2-release/archive/release/noetic/tf2_eigen/0.7.10-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/tf2_eigen"
SRC_URI = "git://github.com/ros-gbp/geometry2-release;${ROS_BRANCH};protocol=https"
SRCREV = "30a30661fa0ba634074fd80d77d9c0fcb25daad0"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
