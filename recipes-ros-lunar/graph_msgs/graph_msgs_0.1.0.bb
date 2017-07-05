# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "ROS messages for publishing graphs of different data types"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin geometry_msgs message_generation message_runtime std_msgs"
SRC_URI = "https://github.com/davetcoleman/graph_msgs-release/archive/release/lunar/graph_msgs/0.1.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "9174bb7d413dfc104107d951e8dad19c"
SRC_URI[sha256sum] = "599d1b5ec0878c8c7153be8e5fcbd0a1503631a13b2f5b02469c4a5da60c49ec"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
