# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "ROS node base implementation for CANopen chains with support for management serv"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=46dd5907f7af0af456f00c524455d867"

DEPENDS = "canopen_master catkin diagnostic_updater message_generation message_runtime pluginlib roscpp roslib socketcan_interface std_msgs std_srvs"
SRC_URI = "https://github.com/ros-industrial-release/ros_canopen-release/archive/release/lunar/canopen_chain_node/0.7.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "d216abed173020f2638630bc26e4e587"
SRC_URI[sha256sum] = "b2239f4b3d689595b8554c7a4aa01bc15ebb3c08aebdfce690b4eead67f9bdcd"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
