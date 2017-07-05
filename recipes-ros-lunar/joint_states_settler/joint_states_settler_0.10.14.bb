# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Provides a node that reports how long a subset of joints has been
     settled. "
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=13;endline=13;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib actionlib_msgs catkin rosconsole roscpp roscpp_serialization settlerlib std_msgs"
SRC_URI = "https://github.com/ros-gbp/calibration-release/archive/release/lunar/joint_states_settler/0.10.14-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "c6c4f517ccb781366b202fb1001faf47"
SRC_URI[sha256sum] = "dc1ba79263d4fa71cfbbe3fd8347380f17010ba4954c0daf86ad1d5ba32fa026"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
