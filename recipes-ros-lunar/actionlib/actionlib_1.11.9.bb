# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "The actionlib stack provides a standardized interface for
    interfacing with p"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib_msgs boost catkin message_generation message_runtime roscpp rospy rostest std_msgs"
SRC_URI = "https://github.com/ros-gbp/actionlib-release/archive/release/lunar/actionlib/1.11.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "fb49a284ef56bb7f6a39f3ef027f3c7b"
SRC_URI[sha256sum] = "fb0081a243e50a7514f8b4da04125386b65bad59aa6183502001ec9345177c30"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
