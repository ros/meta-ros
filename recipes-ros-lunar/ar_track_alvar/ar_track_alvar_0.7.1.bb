# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package is a ROS wrapper for Alvar, an open source AR tag tracking library."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=19240c261c4a9baa66e78eddf550902d"

DEPENDS = "ar_track_alvar_msgs catkin cmake_modules cv_bridge dynamic_reconfigure geometry_msgs image_transport message_generation message_runtime pcl_conversions pcl_ros resource_retriever roscpp rospy sensor_msgs std_msgs tf tf2 tinyxml visualization_msgs"
SRC_URI = "https://github.com/ros-gbp/ar_track_alvar-release/archive/release/lunar/ar_track_alvar/0.7.1-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "312e5236aa915958300193c05670cee8"
SRC_URI[sha256sum] = "d2700ee96bcf3a7fcdc90ed098e8724cd1a01bf3ec973782f3c8ee7d5294b9b2"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
