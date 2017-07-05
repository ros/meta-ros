# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "This package contains an URDF description of the Katana arm and all supporting m"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=fe6a07ee75db997e0a74d91b3b60fb3a"

DEPENDS = "catkin convex_decomposition ivcon transmission_interface urdf"
SRC_URI = "https://github.com/uos-gbp/katana_driver-release/archive/release/lunar/katana_description/1.1.2-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "77f6b3f9fd6850dcf9d5555b2e520be0"
SRC_URI[sha256sum] = "a994042ba0ffc777acec24b01e908ba39183b84daa4362dbfbf01596ad619de3"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
