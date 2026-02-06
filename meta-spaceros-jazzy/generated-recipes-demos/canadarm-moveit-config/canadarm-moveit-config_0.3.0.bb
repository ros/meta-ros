# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "An automatically generated package with all the configuration and launch files for using the SSRMS_Canadarm2 with the MoveIt Motion Planning Framework"
AUTHOR = "Dharini Dutia <dharini@openrobotics.org>"
ROS_AUTHOR = "Dharini Dutia <dharini@openrobotics.org>"
HOMEPAGE = "http://moveit.ros.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "demos"
ROS_BPN = "canadarm_moveit_config"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    moveit-ros-move-group\
    moveit-kinematics\
    moveit-planners\
    moveit-simple-controller-manager\
    joint-state-publisher\
    joint-state-publisher-gui\
    tf2-ros\
    xacro\
    controller-manager\
    moveit-configs-utils\
    moveit-ros-move-group\
    moveit-ros-visualization\
    moveit-setup-assistant\
    robot-state-publisher\
    rviz2\
    rviz-common\
    rviz-default-plugins\
    simulation\
    tf2-ros\
    xacro\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=main"
SRC_URI = "git://github.com/space-ros/demos.git;${ROS_BRANCH};protocol=https"
SRCREV = "93fa3a1361dc983fca2b8cb2524492648df4adcb"
S = "${WORKDIR}/git/canadarm2/canadarm_moveit_config"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
