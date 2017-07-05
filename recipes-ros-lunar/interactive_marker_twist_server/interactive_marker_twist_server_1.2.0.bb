# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Interactive control for generic Twist-based robots using interactive markers"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=7;endline=7;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin interactive_markers roscpp visualization_msgs"
SRC_URI = "https://github.com/ros-gbp/interactive_marker_twist_server-release/archive/release/lunar/interactive_marker_twist_server/1.2.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "b9ada6fca9eafad7f41daf3471d917cd"
SRC_URI[sha256sum] = "68ea840c265e1b9c9e0df4b60459c5a40763b5fd85827af9e9375757d7ce6f5f"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
