# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "controller_manager_tests"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin controller_interface controller_manager rostest"
SRC_URI = "https://github.com/ros-gbp/ros_control-release/archive/release/lunar/controller_manager_tests/0.11.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "fe782791b6c435383dccb5937111b3aa"
SRC_URI[sha256sum] = "fed6f7789b5cc17f2cc8106a77cc1d4430cdca1648dcdfa36f7d6fcfa2764f7d"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
