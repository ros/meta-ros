# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package contains a tool for setting and publishing joint state values for a"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=12;endline=12;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin python_qt_binding rospy sensor_msgs"
SRC_URI = "https://github.com/ros-gbp/robot_model-release/archive/release/lunar/joint_state_publisher/1.12.11-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "6b99d3fad3258c6bb966687c40568c34"
SRC_URI[sha256sum] = "ec2d60d0a904a679eba2a5437afc0f56f407a153ac87552de8a0ec4966380d22"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
