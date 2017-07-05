# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This implements the CANopen device profile for drives and motion control. CiA(r)"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=46dd5907f7af0af456f00c524455d867"

DEPENDS = "canopen_master catkin class_loader"
SRC_URI = "https://github.com/ros-industrial-release/ros_canopen-release/archive/release/lunar/canopen_402/0.7.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "b25282f18fdfb42624f06bb5f7f6b481"
SRC_URI[sha256sum] = "9849ef01dbc9016ab1487ebc212145d9786a6ae6bcdd0950655219a0cad0e1df"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
