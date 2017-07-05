# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Provides a toolchain running through the robot calibration process. This
     in"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "calibration_estimation calibration_launch calibration_msgs catkin image_cb_detector interval_intersection joint_states_settler laser_cb_detector monocam_settler settlerlib"
SRC_URI = "https://github.com/ros-gbp/calibration-release/archive/release/lunar/calibration/0.10.14-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "ab3383e76efe479815b8a187616719e4"
SRC_URI[sha256sum] = "dd4d3689af6a930c940abe1debb9ee48d721c8ffe783f5cb1deddd45388087bb"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
