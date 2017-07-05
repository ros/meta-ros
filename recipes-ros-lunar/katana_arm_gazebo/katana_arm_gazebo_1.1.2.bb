# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package starts a Neuronics Katana robot arm in the Gazebo simulation enviro"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=fe6a07ee75db997e0a74d91b3b60fb3a"

DEPENDS = "actionlib catkin controller_manager controller_manager_msgs gazebo_ros joint_trajectory_controller katana_description katana_gazebo_plugins robot_state_publisher roscpp std_msgs urdf xacro"
SRC_URI = "https://github.com/uos-gbp/katana_driver-release/archive/release/lunar/katana_arm_gazebo/1.1.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "ab49264d04b4b1e512b6f72f5539cfd3"
SRC_URI[sha256sum] = "5dd72fdc44c07639929611f227bc8b9b6096d168b03eac63acb7f085ca46830f"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
