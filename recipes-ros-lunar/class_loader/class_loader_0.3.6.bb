# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "The class_loader package is a ROS-independent package for loading plugins during"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "boost catkin cmake_modules libconsole-bridge-dev libpoco-dev"
SRC_URI = "https://github.com/ros-gbp/class_loader-release/archive/release/lunar/class_loader/0.3.6-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "340f9a95e9272e984e509d54ca60d8a7"
SRC_URI[sha256sum] = "033b5bff257a38df68fc73d5cf702e9a3e388ec96976ad370e3a1cec105eb730"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
