# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package contains a C++ parser for the Collada robot
    description format."
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=19;endline=19;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin class_loader collada-dom liburdfdom-headers-dev roscpp urdf urdf_parser_plugin"
SRC_URI = "https://github.com/ros-gbp/collada_urdf-release/archive/release/lunar/collada_parser/1.12.10-2.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "0a29d1b28f0a10547839eaf92945ac83"
SRC_URI[sha256sum] = "619d55872496995196a0f96776d218c1f4b03eeaf0db8db71793976cdbbd3ec2"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
