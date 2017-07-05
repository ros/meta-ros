# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Client implementation to use TF2 from Common Lisp"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=15;endline=15;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib_lisp catkin cl_transforms_stamped cl_utils roslisp tf2_msgs"
SRC_URI = "https://github.com/ros-gbp/roslisp_common-release/archive/release/lunar/cl_tf2/0.2.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "587025f10a27eae864e8ddeb5b8d1cd9"
SRC_URI[sha256sum] = "ca4480c0c1207ac786de86585a88f754a3402361ae899ffaf779da3a014bd2b4"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
