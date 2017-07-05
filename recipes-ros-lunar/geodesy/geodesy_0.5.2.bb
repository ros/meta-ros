# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Python and C++ interfaces for manipulating geodetic coordinates."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "angles catkin geographic_msgs geometry_msgs python-catkin-pkg python-pyproj sensor_msgs tf unique_id uuid_msgs"
SRC_URI = "https://github.com/ros-geographic-info/geographic_info-release/archive/release/lunar/geodesy/0.5.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "853be0ab676dc88aa90ebfe5c15f83be"
SRC_URI[sha256sum] = "8336ff81fc496e1cc2e3c1cd570c210f3e96fb1d6f093cffa5f6d9ddb47c32d0"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
