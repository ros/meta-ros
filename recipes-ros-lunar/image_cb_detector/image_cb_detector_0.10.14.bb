# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Provide a node that extracts checkerboard corners from ROS images.
    This pack"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=12;endline=12;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib actionlib_msgs calibration_msgs catkin cv_bridge geometry_msgs image_transport message_filters message_generation message_runtime roscpp sensor_msgs std_msgs"
SRC_URI = "https://github.com/ros-gbp/calibration-release/archive/release/lunar/image_cb_detector/0.10.14-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "2cc25fe1870604fcefa7f54cc9c838ac"
SRC_URI[sha256sum] = "8c19decd04896d07836a5146552cdf5d28efda9a571f0449a88f29cf19941bd7"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
