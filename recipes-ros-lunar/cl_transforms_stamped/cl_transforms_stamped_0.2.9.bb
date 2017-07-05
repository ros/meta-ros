# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Implementation of TF datatypes"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=14;endline=14;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin cl_transforms geometry_msgs roslisp std_msgs"
SRC_URI = "https://github.com/ros-gbp/roslisp_common-release/archive/release/lunar/cl_transforms_stamped/0.2.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "5623db0cb79713d7fe54451de26b4d31"
SRC_URI[sha256sum] = "d6bc2ff1be95c517cde9349974f9aacac3dc52cb18bf6648129765f0f50b50e6"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
