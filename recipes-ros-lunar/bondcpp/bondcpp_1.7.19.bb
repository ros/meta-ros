# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "C++ implementation of bond, a mechanism for checking when
    another process ha"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "bond boost catkin cmake_modules roscpp smclib uuid"
SRC_URI = "https://github.com/ros-gbp/bond_core-release/archive/release/lunar/bondcpp/1.7.19-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "4cb0fa15d25c53c9db5cf6c85a4638f5"
SRC_URI[sha256sum] = "dbf64fb9164560d5a93d9be51b811d2575297e8fc7fb66e532a84317061657d6"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
