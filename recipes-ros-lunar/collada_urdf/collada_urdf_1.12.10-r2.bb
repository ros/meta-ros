# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package contains a tool to convert Unified Robot Description Format (URDF) "
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=18;endline=18;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "angles assimp assimp-dev catkin cmake_modules collada-dom collada_parser geometric_shapes liburdfdom-dev liburdfdom-headers-dev resource_retriever roscpp tf urdf"
SRC_URI = "https://github.com/ros-gbp/collada_urdf-release/archive/release/lunar/collada_urdf/1.12.10-2.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "7cecab9e6794bf4137dbe5edfb52a1c4"
SRC_URI[sha256sum] = "1942ac13908a30ab9db831f4fc57b7f463c0ac4617f77183a740e036392a0200"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
