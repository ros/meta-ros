# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Homogeneous transform library for Common Lisp."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=14;endline=14;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin cl_utils sbcl"
SRC_URI = "https://github.com/ros-gbp/roslisp_common-release/archive/release/lunar/cl_transforms/0.2.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "0c259fe1ef56172df34ab0d56f43a576"
SRC_URI[sha256sum] = "18f96f8675d0425480cce46cebe2923f01ed0830da5259543dbcbc969366cdb3"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
