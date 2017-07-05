# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Controller for a differential drive mobile base."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=8;endline=8;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin controller_interface nav_msgs realtime_tools tf urdf"
SRC_URI = "https://github.com/ros-gbp/ros_controllers-release/archive/release/lunar/diff_drive_controller/0.12.3-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "b317b07d3f22fd462189aeff1aa46c88"
SRC_URI[sha256sum] = "9439016639fd6bec926a6054d1cf2cecff4223a7906db693fcad5e98bbc5abb0"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
