# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Client implementation to use TF from Common Lisp"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=13;endline=13;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin cl_transforms cl_transforms_stamped roslisp tf"
SRC_URI = "https://github.com/ros-gbp/roslisp_common-release/archive/release/lunar/cl_tf/0.2.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "9ffe7bea246742cc0b49ad6c6d308a9d"
SRC_URI[sha256sum] = "c7d7991362a9291147d5dfba2908fe7b5d557d6622c387b5cd14cda04a59ea9c"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
