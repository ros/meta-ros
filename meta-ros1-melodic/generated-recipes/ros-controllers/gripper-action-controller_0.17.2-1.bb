# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The gripper_action_controller package"
AUTHOR = "Sachin Chitta <robot.moveit@gmail.com>"
ROS_AUTHOR = "Sachin Chitta <robot.moveit@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_controllers"
ROS_BPN = "gripper_action_controller"

ROS_BUILD_DEPENDS = " \
    actionlib \
    angles \
    cmake-modules \
    control-msgs \
    control-toolbox \
    controller-interface \
    controller-manager \
    hardware-interface \
    pluginlib \
    realtime-tools \
    roscpp \
    trajectory-msgs \
    urdf \
    xacro \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    angles \
    cmake-modules \
    control-msgs \
    control-toolbox \
    controller-interface \
    controller-manager \
    hardware-interface \
    pluginlib \
    realtime-tools \
    roscpp \
    trajectory-msgs \
    urdf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    angles \
    cmake-modules \
    control-msgs \
    control-toolbox \
    controller-interface \
    controller-manager \
    hardware-interface \
    pluginlib \
    realtime-tools \
    roscpp \
    trajectory-msgs \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/ros_controllers-release/archive/release/melodic/gripper_action_controller/0.17.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/gripper_action_controller"
SRC_URI = "git://github.com/ros-gbp/ros_controllers-release;${ROS_BRANCH};protocol=https"
SRCREV = "d0c17d5a84760e59f32e99218e1a6b0503be8504"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
