# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Common Lisp utility libraries"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=13;endline=13;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin sbcl"
SRC_URI = "https://github.com/ros-gbp/roslisp_common-release/archive/release/lunar/cl_utils/0.2.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "176c076df23ff51e8527ea1eac116d8c"
SRC_URI[sha256sum] = "4e9e5adba5833d4d3e14929c69c3fb0e52084f0ec201ba0cba631714675835c7"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
