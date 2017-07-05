# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "gazebo_ros_control"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "angles catkin control_toolbox controller_manager gazebo_dev gazebo_ros hardware_interface joint_limits_interface pluginlib roscpp std_msgs transmission_interface urdf"
SRC_URI = "https://github.com/ros-gbp/gazebo_ros_pkgs-release/archive/release/lunar/gazebo_ros_control/2.7.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "4270324a2f0e6fffd97dafb700f3ef0e"
SRC_URI[sha256sum] = "7059dc5684c7c8b1e972b1c048d7449acc351425ff748c9f499454412c97aaa1"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
