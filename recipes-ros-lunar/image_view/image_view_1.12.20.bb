# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "A simple viewer for ROS image topics. Includes a specialized viewer
  for stereo"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "camera_calibration_parsers catkin cv_bridge dynamic_reconfigure gtk2 image_transport message_filters message_generation nodelet rosconsole roscpp sensor_msgs std_srvs stereo_msgs"
SRC_URI = "https://github.com/ros-gbp/image_pipeline-release/archive/release/lunar/image_view/1.12.20-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "f916d44f67bc61f4ba10fcc40437d12f"
SRC_URI[sha256sum] = "63b7ed07d99130301b9a8fd9b26cd09eea13e2472d1ac5ec77aa653b31f803e0"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
