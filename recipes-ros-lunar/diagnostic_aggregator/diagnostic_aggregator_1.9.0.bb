# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "diagnostic_aggregator"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "bondcpp bondpy catkin diagnostic_msgs pluginlib roscpp rospy rostest xmlrpcpp"
SRC_URI = "https://github.com/ros-gbp/diagnostics-release/archive/release/lunar/diagnostic_aggregator/1.9.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "c7f6590f3ea52bfbdb3608795baebd93"
SRC_URI[sha256sum] = "079702495b417a9a06441497e6536a80cd804370a0e034c05145eb213521c3b8"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
