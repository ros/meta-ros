# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Python ROS message and service generators."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=7;endline=7;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin genmsg"
SRC_URI = "https://github.com/ros-gbp/genpy-release/archive/release/lunar/genpy/0.6.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "85eae6c5ec2a2b60b8d6acf98589b4b6"
SRC_URI[sha256sum] = "8b90f24cb7884b9349340a54e24887d2d42e35fe08d09349784eda76ba0002f2"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
