# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "actionlib_msgs defines the common messages to interact with an
     action serve"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=12;endline=12;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin message_generation message_runtime std_msgs"
SRC_URI = "https://github.com/ros-gbp/common_msgs-release/archive/release/lunar/actionlib_msgs/1.12.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "bd228335e40175348acad1bf68b9aa80"
SRC_URI[sha256sum] = "8b427fc6c67668de43bd07b0dbd5e6c800b38a8e4b5542cdf1a1cf591e475957"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
