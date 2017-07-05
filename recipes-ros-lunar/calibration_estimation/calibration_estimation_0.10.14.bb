# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Runs an optimization to estimate the a robot's kinematic parameters. This packag"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "calibration_msgs catkin python-matplotlib python-scipy python_orocos_kdl rospy rostest sensor_msgs urdfdom_py visualization_msgs"
SRC_URI = "https://github.com/ros-gbp/calibration-release/archive/release/lunar/calibration_estimation/0.10.14-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "a16f38f797ed7670eaf1ff3c419245f0"
SRC_URI[sha256sum] = "ab6a6c5a84345b7f804eb92b6f112195d8c86fbab7127a52dcd069ae91f80243"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
