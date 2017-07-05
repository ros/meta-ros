# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "cpp_common contains C++ code for doing things that are not necessarily ROS
    r"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=13;endline=13;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "boost catkin libconsole-bridge-dev"
SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/lunar/cpp_common/0.6.4-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "01620550e1e226174caf75306f948f16"
SRC_URI[sha256sum] = "ae94578505eaa28b651663f536b58f1f1b584a4e8ebb368f3ac8d8c8b210c4df"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
