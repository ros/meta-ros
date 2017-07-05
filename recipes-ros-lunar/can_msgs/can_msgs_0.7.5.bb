# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "CAN related message types."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin message_generation message_runtime std_msgs"
SRC_URI = "https://github.com/ros-industrial-release/ros_canopen-release/archive/release/lunar/can_msgs/0.7.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "29b6cf775d1c266173e11e5ecf68fa2c"
SRC_URI[sha256sum] = "90f6ebd0257b48ae8262a8bde5b6ad08072ec43fff3ca33595c2460ed7e98181"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
