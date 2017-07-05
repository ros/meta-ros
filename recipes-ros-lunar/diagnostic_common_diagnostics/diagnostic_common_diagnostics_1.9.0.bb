# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "diagnostic_common_diagnostics"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin diagnostic_updater hddtemp rospy tf"
SRC_URI = "https://github.com/ros-gbp/diagnostics-release/archive/release/lunar/diagnostic_common_diagnostics/1.9.0-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "bf87e8bf66d28377d01f6944c275e8af"
SRC_URI[sha256sum] = "62acb68314ca78da574944385287c1cae1255727e84d447b86f72c230fefa313"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
