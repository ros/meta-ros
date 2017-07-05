# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Robot-independent Gazebo plugins for sensors, motors and dynamic reconfigurable "
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD, Apache 2.0"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=b70e8de3cb7b1e72b6fd191ef0f624df"

DEPENDS = "angles camera_info_manager catkin cv_bridge diagnostic_updater dynamic_reconfigure gazebo_dev gazebo_msgs geometry_msgs image_transport message_generation message_runtime nav_msgs nodelet polled_camera rosconsole roscpp rosgraph_msgs rospy sensor_msgs std_msgs std_srvs tf tf2_ros trajectory_msgs urdf"
SRC_URI = "https://github.com/ros-gbp/gazebo_ros_pkgs-release/archive/release/lunar/gazebo_plugins/2.7.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "0aebb2562cb243cfef948caa4c8899ed"
SRC_URI[sha256sum] = "a5846c2126d3686523857f11dc68d01de1cacba26d90375d574b92396f6e12ac"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
