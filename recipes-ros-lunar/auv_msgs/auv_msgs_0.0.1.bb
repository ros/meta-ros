# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package provides message types commonly used with Autonomous Underwater Veh"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin geographic_msgs geometry_msgs message_generation message_runtime sensor_msgs std_msgs"
SRC_URI = "https://github.com/oceansystemslab/auv_msgs-release/archive/release/lunar/auv_msgs/0.0.1-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "e037a7998c06d5be63563072ddfd1cc0"
SRC_URI[sha256sum] = "b2f400971dce22133722a0b5a6d0615659823e921d0f011de22ee32e1bea5b26"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
