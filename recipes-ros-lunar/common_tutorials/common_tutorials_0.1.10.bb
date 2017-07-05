# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Metapackage that contains common tutorials"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=6;endline=6;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib_tutorials catkin nodelet_tutorial_math pluginlib_tutorials turtle_actionlib"
SRC_URI = "https://github.com/ros-gbp/common_tutorials-release/archive/release/lunar/common_tutorials/0.1.10-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "454769d5bdd7ddf90251ae8ca3098b56"
SRC_URI[sha256sum] = "ce1af544a99ff31d9f16f11dbf97a1463c0b88017132dfd4bc03883832442716"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
