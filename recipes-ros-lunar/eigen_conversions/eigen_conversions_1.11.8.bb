# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Conversion functions between:
      - Eigen and KDL
      - Eigen and geometry_m"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=15;endline=15;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin cmake_modules eigen geometry_msgs orocos_kdl std_msgs"
SRC_URI = "https://github.com/ros-gbp/geometry-release/archive/release/lunar/eigen_conversions/1.11.8-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "a19f58dec9f7af1c5d744f03895ef1b4"
SRC_URI[sha256sum] = "8ad36ceee949a079988675253023b7ee2a42a19563f7f4632a3155dfce6c1a9b"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
