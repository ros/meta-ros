# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Controller to publish joint state"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin controller_interface hardware_interface pluginlib realtime_tools roscpp sensor_msgs"
SRC_URI = "https://github.com/ros-gbp/ros_controllers-release/archive/release/lunar/joint_state_controller/0.12.3-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "9f8d550e6bb6eef48b59de966cf1df22"
SRC_URI[sha256sum] = "495e95f8660b07db750c6e755ff028a2b4e2b1837a1dabaa1cd363b9f5a47a8a"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
