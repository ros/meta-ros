# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
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

# matches with: https://github.com/seed-solutions/seed_r7_ros_pkg-release/archive/release/melodic/seed_r7_typef_moveit_config/0.3.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/seed_r7_typef_moveit_config"
SRC_URI = "git://github.com/seed-solutions/seed_r7_ros_pkg-release;${ROS_BRANCH};protocol=https"
SRCREV = "e5045b991526d758022ae139af7f9a9b0a4e8efe"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
