# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "The combined_robot_hw_tests package"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin combined_robot_hw controller_manager controller_manager_tests hardware_interface roscpp"
SRC_URI = "https://github.com/ros-gbp/ros_control-release/archive/release/lunar/combined_robot_hw_tests/0.11.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "2c33ed33f859bdc78e68a6e430858310"
SRC_URI[sha256sum] = "6ffca99b9db74032a316a78692c6d3b2a7b2f7a7e63f40d61bca87888aec3d80"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
