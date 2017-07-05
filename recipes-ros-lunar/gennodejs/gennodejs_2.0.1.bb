# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Javascript ROS message and service generators."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "Apache 2.0"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=cd1a22ceb914b60db1fb991e52fe3fcc"

DEPENDS = "catkin genmsg"
SRC_URI = "https://github.com/RethinkRobotics-release/gennodejs-release/archive/release/lunar/gennodejs/2.0.1-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "84113f3bfdd22060393c455bc818df8f"
SRC_URI[sha256sum] = "66a15f5a929b7792aa1237c1afaba0dbde8fd2808a207c4e85d5f3e3b51397a5"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
