# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Metapackage of geometry tutorials ROS."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=7;endline=7;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin turtle_tf turtle_tf2"
SRC_URI = "https://github.com/ros-gbp/geometry_tutorials-release/archive/release/lunar/geometry_tutorials/0.2.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "97d1ec6640e9724e1f0584aebcfea9e9"
SRC_URI[sha256sum] = "ca75216142918e356e1d29d5f5dc76bc59cd966efd51ebbc12ab42ccd00fc239"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
