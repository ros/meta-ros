# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "EusLisp ROS message and service generators."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin genmsg"
SRC_URI = "https://github.com/tork-a/geneus-release/archive/release/lunar/geneus/2.2.6-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "a478f5eed7579b35449a620d90f2d94c"
SRC_URI[sha256sum] = "154b49e570e2016b1eb9aecfbb233149302a445733bd0a6fd1f78d5e2d6c3988"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
