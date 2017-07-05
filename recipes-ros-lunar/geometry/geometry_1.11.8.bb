# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Geometry Library"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=6;endline=6;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "angles catkin eigen_conversions kdl_conversions tf tf_conversions"
SRC_URI = "https://github.com/ros-gbp/geometry-release/archive/release/lunar/geometry/1.11.8-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "db54103bbd503790cb2c9659398c3ce9"
SRC_URI[sha256sum] = "94aa20d1f47e80c30ea95665b292b2f81541e745d326012de9f6eadd0a8f4c1f"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
