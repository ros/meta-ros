# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package provides a set of simple math utilities to work
        with angles"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=15;endline=15;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin"
SRC_URI = "https://github.com/ros-gbp/geometry_angles_utils-release/archive/release/lunar/angles/1.9.11-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "7defdab86e662fac81aca7605ccfea7e"
SRC_URI[sha256sum] = "e8deedc60c1f06c276cc1cd26017bdb4a651ff60f2a542584d28f8d493f02cea"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
