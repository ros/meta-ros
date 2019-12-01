# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Extension to launch_ros to provide the ability to run nodes in sandboxed environments."
AUTHOR = "AWS RoboMaker <ros-contributions@amazon.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "launch_ros_sandbox"
ROS_BPN = "launch_ros_sandbox"

ROS_BUILD_DEPENDS = " \
    launch \
    launch-ros \
    python3-docker \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    launch \
    launch-ros \
    python3-docker \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    launch \
    launch-ros \
    python3-docker \
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

SRC_URI = "https://github.com/ros-security/launch_ros_sandbox-release/archive/release/dashing/launch_ros_sandbox/0.0.2-4.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fe9bf1790329a7364b29e368ca4d03cc"
SRC_URI[sha256sum] = "da2b79de6730fc77e2655ebda0137fbde36981f2e2ec8e67e54fa7df05d0669a"
S = "${WORKDIR}/launch_ros_sandbox-release-release-dashing-launch_ros_sandbox-0.0.2-4"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('launch-ros-sandbox', d)}"
ROS_BUILD_TYPE = "ament_python"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('launch-ros-sandbox', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros-sandbox/launch-ros-sandbox_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros-sandbox/launch-ros-sandbox-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros-sandbox/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/launch-ros-sandbox/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
