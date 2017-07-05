# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "A metapackage to bring in the default packages second generation Transform Libra"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin tf2 tf2_bullet tf2_eigen tf2_geometry_msgs tf2_kdl tf2_msgs tf2_py tf2_ros tf2_sensor_msgs tf2_tools"
SRC_URI = "https://github.com/ros-gbp/geometry2-release/archive/release/lunar/geometry2/0.5.15-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "720f94f6505680a821f56bd690cc1de4"
SRC_URI[sha256sum] = "6f72f61fb456e49f300a769d5e59cbdc053c95175e3c38ecda4a7a3628af16ce"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
