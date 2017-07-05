# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package provides a C++ interface for camera calibration
     information.  "
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=15;endline=15;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "boost camera_calibration_parsers catkin image_transport roscpp roslib rostest sensor_msgs"
SRC_URI = "https://github.com/ros-gbp/image_common-release/archive/release/lunar/camera_info_manager/1.11.12-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "c22fcb009858c0943a3d37a3153189e3"
SRC_URI[sha256sum] = "831e8a8c0f17a2313d2f426524578aee16d578b2f9bfbe061c306e80b0633023"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
