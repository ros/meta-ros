# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "A bond allows two processes, A and B, to know when the other has
    terminated,"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=12;endline=12;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin message_generation message_runtime std_msgs"
SRC_URI = "https://github.com/ros-gbp/bond_core-release/archive/release/lunar/bond/1.7.19-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "c7a7246b86adac26ea449ef28f3e3dbc"
SRC_URI[sha256sum] = "fb87eafee788b707e98e3e11cfb90a2a4ede88699d9e115b29ffe684d2852b02"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
