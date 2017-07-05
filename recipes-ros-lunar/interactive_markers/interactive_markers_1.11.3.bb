# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "3D interactive marker communication library for RViz and similar tools."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=7;endline=7;md5=24ca93924f03642fbbd06efa2e6d00df"

DEPENDS = "catkin rosconsole roscpp rospy rostest std_msgs tf visualization_msgs"
SRC_URI = "https://github.com/ros-gbp/interactive_markers-release/archive/release/lunar/interactive_markers/1.11.3-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "94b360e186dfae2894ecf9861da137b7"
SRC_URI[sha256sum] = "4677f9092358bdf84a84748d6554b04a89a23adfdbc25672cb6d074f23058d50"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
