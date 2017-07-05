# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package contains a collection of launch files that can be helpful in config"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin interval_intersection joint_states_settler laser_cb_detector monocam_settler urdfdom_py"
SRC_URI = "https://github.com/ros-gbp/calibration-release/archive/release/lunar/calibration_launch/0.10.14-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "889dca02320641ab138ab3ee451275d9"
SRC_URI[sha256sum] = "7d69d59d83c669f2f88ea660aa50f8bc6a51d0a92e0916ab2dfeb5e61174c05f"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
