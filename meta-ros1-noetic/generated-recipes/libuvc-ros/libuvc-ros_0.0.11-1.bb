# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "libuvc_ros metapackage"
AUTHOR = "Ken Tossell <ken@tossell.net>"
HOMEPAGE = "http://ros.org/wiki/libuvc_ros"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "libuvc_ros"
ROS_BPN = "libuvc_ros"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libuvc-camera \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libuvc-camera \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/libuvc_ros-release/archive/release/noetic/libuvc_ros/0.0.11-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/libuvc_ros"
SRC_URI = "git://github.com/ros-drivers-gbp/libuvc_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "b1c0132786e13386cc63043d7fa70c8b8a970a68"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
