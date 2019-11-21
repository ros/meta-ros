# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Launchfiles to use Ridgeback in Gazebo."
AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
ROS_AUTHOR = "Mike Purvis"
HOMEPAGE = "http://wiki.ros.org/ridgeback_gazebo"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ridgeback_simulator"
ROS_BPN = "ridgeback_gazebo"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    hector-gazebo-plugins \
    ridgeback-control \
    ridgeback-description \
    ridgeback-gazebo-plugins \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    hector-gazebo-plugins \
    ridgeback-control \
    ridgeback-description \
    ridgeback-gazebo-plugins \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/ridgeback_simulator-release/archive/release/kinetic/ridgeback_gazebo/0.0.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6a0ef4be98ce3b465f16826296685dcb"
SRC_URI[sha256sum] = "5c40ad99149fb2e2c8847afac406a8d21dfefc99f2749bc9a6d3b4005645d2f4"
S = "${WORKDIR}/ridgeback_simulator-release-release-kinetic-ridgeback_gazebo-0.0.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ridgeback-simulator', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ridgeback-simulator', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback-simulator/ridgeback-simulator_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback-simulator/ridgeback-simulator-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback-simulator/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ridgeback-simulator/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
