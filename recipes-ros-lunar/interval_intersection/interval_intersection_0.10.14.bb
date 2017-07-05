# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "Tools for calculating the intersection of interval messages coming
    in on sev"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=11;endline=11;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib actionlib_msgs boost calibration_msgs catkin geometry_msgs rosconsole roscpp roscpp_serialization rostime std_msgs"
SRC_URI = "https://github.com/ros-gbp/calibration-release/archive/release/lunar/interval_intersection/0.10.14-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "32c9d36359f725cda47450dd566bfb54"
SRC_URI[sha256sum] = "ec2641c5ee7fc47f91e42816c7a1bc09eb4d6bf9d508bcae8993ece963f6261b"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
