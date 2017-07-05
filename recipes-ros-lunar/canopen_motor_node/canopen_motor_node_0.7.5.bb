# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package extends the canopen_chain_node with specialized handling for canope"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=46dd5907f7af0af456f00c524455d867"

DEPENDS = "canopen_402 canopen_chain_node catkin controller_manager controller_manager_msgs filters hardware_interface joint_limits_interface muparser urdf"
SRC_URI = "https://github.com/ros-industrial-release/ros_canopen-release/archive/release/lunar/canopen_motor_node/0.7.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "0168f28180b6d7d48946a031aac753ab"
SRC_URI[sha256sum] = "3039dfd16ce24f8ef935d7a268472e225b5f566d39017e2ce7a04394154ceb40"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
