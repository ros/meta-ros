# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "The gripper_action_controller package"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib angles catkin cmake_modules control_msgs control_toolbox controller_interface controller_manager hardware_interface realtime_tools roscpp trajectory_msgs urdf xacro"
SRC_URI = "https://github.com/ros-gbp/ros_controllers-release/archive/release/lunar/gripper_action_controller/0.12.3-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "72d3fe89ebbae7388894653422b4397d"
SRC_URI[sha256sum] = "8e5b40d80cd8a1600d7e267a2cd69286d17cc8f5c62bc15c94d19fcee5322535"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
