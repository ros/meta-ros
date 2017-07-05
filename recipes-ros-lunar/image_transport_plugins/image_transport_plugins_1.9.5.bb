# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "A set of plugins for publishing and subscribing to sensor_msgs/Image topics
    "
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=14;endline=14;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin compressed_depth_image_transport compressed_image_transport theora_image_transport"
SRC_URI = "https://github.com/ros-gbp/image_transport_plugins-release/archive/release/lunar/image_transport_plugins/1.9.5-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "0585af0d6a989f9d8b7337307ed61538"
SRC_URI[sha256sum] = "af224372ff5e069e03f1e960d544b2d5cd595eaf2c6f27cf4b86696088f4ee73"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
