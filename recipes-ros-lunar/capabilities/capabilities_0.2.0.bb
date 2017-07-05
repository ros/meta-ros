# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Package which implements capabilities, including code to parse capability interf"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "bondpy catkin message_generation message_runtime nodelet python-yaml roslaunch rospy rostest std_msgs std_srvs"
SRC_URI = "https://github.com/ros-gbp/capabilities-release/archive/release/lunar/capabilities/0.2.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "76771f540ae02f506b88d2320cf7feb2"
SRC_URI[sha256sum] = "675ff124fbdd8d09e74b27abda6a93bbe22f22310e5892f62a50e3bf03466e31"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
