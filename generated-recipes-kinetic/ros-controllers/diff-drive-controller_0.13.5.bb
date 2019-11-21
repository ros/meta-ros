# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Controller for a differential drive mobile base."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Bence Magyar <bence.magyar@pal-robotics.com>"
HOMEPAGE = "https://github.com/ros-controls/ros_controllers/wiki"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_controllers"
ROS_BPN = "diff_drive_controller"

ROS_BUILD_DEPENDS = " \
    controller-interface \
    dynamic-reconfigure \
    nav-msgs \
    realtime-tools \
    tf \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-interface \
    dynamic-reconfigure \
    nav-msgs \
    realtime-tools \
    tf \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-interface \
    dynamic-reconfigure \
    nav-msgs \
    realtime-tools \
    tf \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    controller-manager \
    rosgraph-msgs \
    rostest \
    std-srvs \
    xacro \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/ros_controllers-release/archive/release/kinetic/diff_drive_controller/0.13.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c705288e39cd1842c0e6bdbb2b580a80"
SRC_URI[sha256sum] = "ad89d6037ec24fd9d0b324832cb333a637182b98e49d3b5bca66baa5a74ddf0b"
S = "${WORKDIR}/ros_controllers-release-release-kinetic-diff_drive_controller-0.13.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-controllers', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-controllers', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-controllers/ros-controllers_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-controllers/ros-controllers-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-controllers/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-controllers/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
