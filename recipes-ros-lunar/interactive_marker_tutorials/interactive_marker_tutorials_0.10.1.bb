# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "The interactive_marker_tutorials package"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin interactive_markers roscpp tf visualization_msgs"
SRC_URI = "https://github.com/ros-gbp/visualization_tutorials-release/archive/release/lunar/interactive_marker_tutorials/0.10.1-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "051b020f05a483b59eee4457b3559e28"
SRC_URI[sha256sum] = "fb5a6a7d68446704bc873b2227bb7c3bbed1d2744f06ed12d99283167ce0fbfd"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
