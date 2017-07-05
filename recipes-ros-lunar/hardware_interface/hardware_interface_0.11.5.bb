# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Hardware Interface base class."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin roscpp"
SRC_URI = "https://github.com/ros-gbp/ros_control-release/archive/release/lunar/hardware_interface/0.11.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "5b7a005a5279e79d0e1b80046b8b3641"
SRC_URI[sha256sum] = "db181bc222f5d35946555087c295f1cb88a41598f0186340ec62706ce1062d6e"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
