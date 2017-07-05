# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "connects to a GPSd server and broadcasts GPS fixes 
   using the NavSatFix messa"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=13;endline=13;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin gps_common libgps pkg-config roscpp sensor_msgs"
SRC_URI = "https://github.com/swri-robotics-gbp/gps_umd-release/archive/release/lunar/gpsd_client/0.1.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "cef9424449c6d9208c9c2bd050830002"
SRC_URI[sha256sum] = "8e7d85c07aa1b1cd640f75da362299cec90a7670e52211e723ff765bdae8515c"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
