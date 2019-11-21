# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A implementation of a local planner that attempts to follow a plan as closely as possible."
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://wiki.ros.org/pose_follower"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "navigation_experimental"
ROS_BPN = "pose_follower"

ROS_BUILD_DEPENDS = " \
    base-local-planner \
    costmap-2d \
    dynamic-reconfigure \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    base-local-planner \
    costmap-2d \
    dynamic-reconfigure \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    base-local-planner \
    costmap-2d \
    dynamic-reconfigure \
    nav-core \
    nav-msgs \
    pluginlib \
    roscpp \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/navigation_experimental-release/archive/release/kinetic/pose_follower/0.2.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "52f1a081059117db3afc920f5cb0b9d1"
SRC_URI[sha256sum] = "72a612385c42a2f2b85a4e5bf6a878fdf8fea5864cad24bcd265432f1a518f37"
S = "${WORKDIR}/navigation_experimental-release-release-kinetic-pose_follower-0.2.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('navigation-experimental', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('navigation-experimental', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-experimental/navigation-experimental_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-experimental/navigation-experimental-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-experimental/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-experimental/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
