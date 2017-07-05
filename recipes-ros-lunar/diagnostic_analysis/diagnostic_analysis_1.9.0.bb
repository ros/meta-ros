# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "The diagnostic_analysis package can convert a log of diagnostics data
    into a"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=12;endline=12;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin diagnostic_msgs rosbag roslib rostest"
SRC_URI = "https://github.com/ros-gbp/diagnostics-release/archive/release/lunar/diagnostic_analysis/1.9.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "c259b1e410d6c9db4685b825499e7a18"
SRC_URI[sha256sum] = "026d14d380ec4a570ed48945b95003a30c998c1c59f01d59735db5528996395f"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
