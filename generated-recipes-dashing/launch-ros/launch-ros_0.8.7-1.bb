# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ROS specific extensions to the launch tool."
AUTHOR = "William Woodall <william@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "launch_ros"
ROS_BPN = "launch_ros"

ROS_BUILD_DEPENDS = " \
    ament-index-python \
    composition-interfaces \
    launch \
    lifecycle-msgs \
    osrf-pycommon \
    python3-pyyaml \
    rclpy \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    ament-index-python \
    composition-interfaces \
    launch \
    lifecycle-msgs \
    osrf-pycommon \
    python3-pyyaml \
    rclpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    composition-interfaces \
    launch \
    lifecycle-msgs \
    osrf-pycommon \
    python3-pyyaml \
    rclpy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/launch_ros-release/archive/release/dashing/launch_ros/0.8.7-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1d0a184a2ea4306a40e847d3133429e9"
SRC_URI[sha256sum] = "06de5fd5c0cb74f314214f08763f7f0e417c8b06c7625caf43eae853308085ce"
S = "${WORKDIR}/launch_ros-release-release-dashing-launch_ros-0.8.7-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('launch-ros', d)}"
ROS_BUILD_TYPE = "ament_python"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('launch-ros', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros/launch-ros_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros/launch-ros-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
