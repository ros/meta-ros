# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Ecto is a hybrid C++/Python development framework for constructing and maintaini"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "boost catkin python xdot"
SRC_URI = "https://github.com/ros-gbp/ecto-release/archive/release/lunar/ecto/0.6.12-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "4659518ff0c458b81580ee3eaee08f81"
SRC_URI[sha256sum] = "3d95352ddb262ee31eb29e5b0ac81d72316573a5ce41f46c46d2daba3a4270b4"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
