# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Gazebo simulation for NEXTAGE Open"
AUTHOR = "TORK <dev@opensource-robotics.tokyo.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://wiki.ros.org/nextage_gazebo"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtmros_nextage"
ROS_BPN = "nextage_gazebo"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    nextage-description \
    nextage-moveit-config \
    ros-controllers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    nextage-description \
    nextage-moveit-config \
    ros-controllers \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/rtmros_nextage-release/archive/release/kinetic/nextage_gazebo/0.8.5-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c6fabd655c880207fed809ac19f73eec"
SRC_URI[sha256sum] = "f398d760a58e559f1ebc4143cfcf85ccafbde2859f0810b79802e72a78a5addd"
S = "${WORKDIR}/rtmros_nextage-release-release-kinetic-nextage_gazebo-0.8.5-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rtmros-nextage', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rtmros-nextage', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/rtmros-nextage_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/rtmros-nextage-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rtmros-nextage/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
