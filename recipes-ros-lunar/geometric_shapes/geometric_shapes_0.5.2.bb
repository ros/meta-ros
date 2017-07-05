# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "assimp assimp-dev boost catkin eigen eigen_stl_containers libconsole-bridge-dev libqhull octomap pkg-config random_numbers resource_retriever shape_msgs visualization_msgs"
SRC_URI = "https://github.com/ros-gbp/geometric_shapes-release/archive/release/lunar/geometric_shapes/0.5.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "b8d4a5137033102cab483efed6ba1b51"
SRC_URI[sha256sum] = "839c89a1ab8cfa449ccda82be2573f4054dfc2f15e1876bdd7d40b91f4a58379"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
