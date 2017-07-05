# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "camera_calibration_parsers contains routines for reading and writing camera cali"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "boost catkin pkg-config rosconsole roscpp roscpp_serialization sensor_msgs yaml-cpp"
SRC_URI = "https://github.com/ros-gbp/image_common-release/archive/release/lunar/camera_calibration_parsers/1.11.12-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "18b4686d52eaee0a72cf9e3d0152e854"
SRC_URI[sha256sum] = "3d4662ee499b060e3d086279b2c6c07fd9e83e1402127993600f10d5be8b2195"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
