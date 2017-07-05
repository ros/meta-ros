# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "A bond allows two processes, A and B, to know when the other has
    terminated,"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=12;endline=12;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "bond bondcpp bondpy catkin smclib"
SRC_URI = "https://github.com/ros-gbp/bond_core-release/archive/release/lunar/bond_core/1.7.19-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "f2df2707e91458eefe3d81e0f95cee01"
SRC_URI[sha256sum] = "40035bce831fe4d6f7ff49d740b05841a59401052fbae431ca17b28f7dfd278b"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
