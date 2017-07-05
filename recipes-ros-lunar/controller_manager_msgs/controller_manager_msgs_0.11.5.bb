# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Messages and services for the controller manager."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin message_generation message_runtime std_msgs"
SRC_URI = "https://github.com/ros-gbp/ros_control-release/archive/release/lunar/controller_manager_msgs/0.11.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "9c693f7d90afbbf648a3f5ac7149cdd6"
SRC_URI[sha256sum] = "6f4e5fcafd25acee19a14490566b0a8b7731b8aed8dd9f8946605251bcf9d8b6"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
