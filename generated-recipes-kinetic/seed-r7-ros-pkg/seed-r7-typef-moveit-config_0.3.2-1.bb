# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "An automatically generated package with all the configuration and launch files for using the SEED-Noid-Mover-typeF with the MoveIt! Motion Planning Framework"
AUTHOR = "Yasuto Shiigi <y.shiigi@thk.co.jp>"
ROS_AUTHOR = "Yasuto Shiigi <y.shiigi@thk.co.jp>"
HOMEPAGE = "http://moveit.ros.org/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "seed_r7_ros_pkg"
ROS_BPN = "seed_r7_typef_moveit_config"

ROS_BUILD_DEPENDS = " \
    seed-r7-description \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joint-state-publisher \
    moveit-fake-controller-manager \
    moveit-kinematics \
    moveit-planners-ompl \
    moveit-ros-move-group \
    moveit-ros-visualization \
    moveit-setup-assistant \
    robot-state-publisher \
    rviz \
    seed-r7-description \
    tf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    moveit-fake-controller-manager \
    moveit-kinematics \
    moveit-planners-ompl \
    moveit-ros-move-group \
    moveit-ros-visualization \
    moveit-setup-assistant \
    robot-state-publisher \
    rviz \
    seed-r7-description \
    tf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/seed-solutions/seed_r7_ros_pkg-release/archive/release/kinetic/seed_r7_typef_moveit_config/0.3.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7642e8f3077e42be992b7cfbc90332aa"
SRC_URI[sha256sum] = "0a60414956262e9e3f58c9649e707e9027ebbfca2e3668a8e09d04c9819ae3a6"
S = "${WORKDIR}/seed_r7_ros_pkg-release-release-kinetic-seed_r7_typef_moveit_config-0.3.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('seed-r7-ros-pkg', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('seed-r7-ros-pkg', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/seed-r7-ros-pkg/seed-r7-ros-pkg_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/seed-r7-ros-pkg/seed-r7-ros-pkg-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/seed-r7-ros-pkg/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/seed-r7-ros-pkg/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
