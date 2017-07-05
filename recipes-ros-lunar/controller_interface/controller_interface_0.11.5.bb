# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Interface base class for controllers"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin hardware_interface pluginlib roscpp"
SRC_URI = "https://github.com/ros-gbp/ros_control-release/archive/release/lunar/controller_interface/0.11.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "2107b9ea2eae87e7644700d911ba76e7"
SRC_URI[sha256sum] = "622e78ed2df66ccc9acd27551ffc2e57227df9227144eda9973c93ac65a0add6"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
