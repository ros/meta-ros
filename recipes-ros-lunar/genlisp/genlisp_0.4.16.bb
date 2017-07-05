# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Common-Lisp ROS message and service generators."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin genmsg"
SRC_URI = "https://github.com/ros-gbp/genlisp-release/archive/release/lunar/genlisp/0.4.16-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "9f0c659e3cd83548cff404c1f653da7c"
SRC_URI[sha256sum] = "fcdf39b4e33e069f64dc09d655210c1da26ed2fe5de41f6d54a5ccb0ec0673a2"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
