# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Combined Robot HW class."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin hardware_interface pluginlib roscpp"
SRC_URI = "https://github.com/ros-gbp/ros_control-release/archive/release/lunar/combined_robot_hw/0.11.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "a9d7f59a42164eba4ad4e86343d7c0c6"
SRC_URI[sha256sum] = "72c6fc7d540507693b83b466d66e00032087fa8490ad046f9cfe79d4ea2b4e8d"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
