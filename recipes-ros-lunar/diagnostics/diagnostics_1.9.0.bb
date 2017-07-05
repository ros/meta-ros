# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "diagnostics"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=10;endline=10;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin diagnostic_aggregator diagnostic_analysis diagnostic_common_diagnostics diagnostic_updater self_test"
SRC_URI = "https://github.com/ros-gbp/diagnostics-release/archive/release/lunar/diagnostics/1.9.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "e4b560fcc9241ef2789097c7a0d101de"
SRC_URI[sha256sum] = "8def5bddea7260534364e8d0b53addcb2873cf0b9987cf082df66a471626eb42"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
