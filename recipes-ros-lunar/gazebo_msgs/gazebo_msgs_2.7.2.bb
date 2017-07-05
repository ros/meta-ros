# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Message and service data structures for interacting with Gazebo from ROS."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin geometry_msgs message_generation message_runtime sensor_msgs std_msgs std_srvs trajectory_msgs"
SRC_URI = "https://github.com/ros-gbp/gazebo_ros_pkgs-release/archive/release/lunar/gazebo_msgs/2.7.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "9d8c4e6b135eded6f1a166fe4a4153f8"
SRC_URI[sha256sum] = "60c3eb674602e38a4882eaa64467df2b596052ae2118a6bd2b3ed81909bd4ff3"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
