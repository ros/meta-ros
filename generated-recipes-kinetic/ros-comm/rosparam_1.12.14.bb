# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "rosparam contains the rosparam command-line tool for getting and     setting ROS Parameters on the <a href="http://www.ros.org/wiki/Parameter%20Server">Parameter     Server</a> using YAML-encoded files. It also contains an     experimental library for using YAML with the Parameter     Server. This library is intended for internal use only.      rosparam can be invoked within a <a href="http://www.ros.org/wiki/roslaunch">roslaunch</a> file."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Ken Conley"
HOMEPAGE = "http://ros.org/wiki/rosparam"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_comm"
ROS_BPN = "rosparam"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    python-pyyaml \
    rosgraph \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    python-pyyaml \
    rosgraph \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/kinetic/rosparam/1.12.14-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "84c386c9130a3a2e75fe9360a53d9d2d"
SRC_URI[sha256sum] = "484b4d6a3516b81a5a7a76cd0398e52ee072880af13d48095a51a611a4af62aa"
S = "${WORKDIR}/ros_comm-release-release-kinetic-rosparam-1.12.14-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-comm', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-comm', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/ros-comm_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/ros-comm-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-comm/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
