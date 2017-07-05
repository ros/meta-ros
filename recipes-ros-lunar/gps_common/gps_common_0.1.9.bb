# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "GPS messages and common routines for use in GPS drivers"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin message_filters message_generation message_runtime nav_msgs roscpp sensor_msgs std_msgs"
SRC_URI = "https://github.com/swri-robotics-gbp/gps_umd-release/archive/release/lunar/gps_common/0.1.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "98a9b0a9b7595262fb8c6ca9e678001d"
SRC_URI[sha256sum] = "a1f05fd77ae83587aeec82893b3e517cf036776478293ebed6200fefc4f4d3f4"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
