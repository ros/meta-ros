# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This contains CvBridge, which converts between ROS
    Image messages and OpenCV"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "boost catkin opencv3 python rosconsole sensor_msgs"
SRC_URI = "https://github.com/ros-gbp/vision_opencv-release/archive/release/lunar/cv_bridge/1.12.4-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "4ce5501b0dae9f4efbc87fefa7fc566f"
SRC_URI[sha256sum] = "e4640ef69d7bb912649ed7986fca3aabb093ead1d3736a7a4a58d0340ec696ea"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
