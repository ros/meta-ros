# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Python implementation of bond, a mechanism for checking when
    another process"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "bond catkin rospy smclib uuid"
SRC_URI = "https://github.com/ros-gbp/bond_core-release/archive/release/lunar/bondpy/1.7.19-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "d8461a11ba909d564e87c764cef08fbd"
SRC_URI[sha256sum] = "d167fea0c88e4da6cbe0ed7689a291d7be64d379b5a902852ae32658b19881c9"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
