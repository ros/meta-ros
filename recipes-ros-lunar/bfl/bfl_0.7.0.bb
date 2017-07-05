# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package contains a recent version of the Bayesian Filtering
  Library (BFL)"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = file://package.xml;beginline=19;endline=19;md5=d2740cd2c4139b24d7392872077c634a"

DEPENDS = "catkin cmake cppunit ros"
SRC_URI = "https://github.com/ros-gbp/bfl-release/archive/release/lunar/bfl/0.7.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "844982693c5cdc156b5d0a490baea419"
SRC_URI[sha256sum] = "02930745a24727863d41f471795e56c9ec24ef4303430d8b7e92a42cdbddfa0b"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
