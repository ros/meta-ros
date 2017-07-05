# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Driver for the Innok Heros robot plattform"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=7389aef5a605df7910cbc0188bffd7bb"

DEPENDS = "catkin geometry_msgs rospy std_msgs tf"
SRC_URI = "https://github.com/innokrobotics/innok_heros_driver-release/archive/release/lunar/innok_heros_driver/1.0.3-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "5c75a231871b38e10246f46222ee1975"
SRC_URI[sha256sum] = "1637b5f1e495f67fac87b2ee222a45690bf9c079c4999769ced34cf3299d82e7"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
