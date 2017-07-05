# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "diagnostic_updater contains tools for easily updating diagnostics. it is commonl"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin diagnostic_msgs roscpp rostest std_msgs"
SRC_URI = "https://github.com/ros-gbp/diagnostics-release/archive/release/lunar/diagnostic_updater/1.9.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "130e2d3edddb7866e85de0998ba3c11e"
SRC_URI[sha256sum] = "1def96db0b5c11b86673e3c75f3d6a0460d282e2152cca0d4d7e7a7562a11376"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
