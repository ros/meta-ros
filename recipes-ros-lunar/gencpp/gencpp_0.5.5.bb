# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "C++ ROS message and service generators."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=7;endline=7;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin genmsg"
SRC_URI = "https://github.com/ros-gbp/gencpp-release/archive/release/lunar/gencpp/0.5.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "c2a1b03dc0fd212b5dc1b2312e2d5bf3"
SRC_URI[sha256sum] = "6af02ed2a3815c95253c2d2af8b3f7c8619a1c6d34646984dbb1c591b5d6cdf5"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
