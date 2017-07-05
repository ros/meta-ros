# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package provides a set of typedef's that allow
  using Eigen datatypes in S"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin cmake_modules eigen"
SRC_URI = "https://github.com/ros-gbp/eigen_stl_containers-release/archive/release/lunar/eigen_stl_containers/0.1.8-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "a023d62aac3633581f87c6ef6b3897d6"
SRC_URI[sha256sum] = "872b50caa628406f06a55006a7f3f646cd5910b9ea1c613c877aab8b868a926b"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
