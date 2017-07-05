# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "effort_controllers"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=9;endline=9;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "angles catkin control_msgs control_toolbox controller_interface forward_command_controller realtime_tools urdf"
SRC_URI = "https://github.com/ros-gbp/ros_controllers-release/archive/release/lunar/effort_controllers/0.12.3-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "2087df68e6efa3d4cdb7577eda629ae0"
SRC_URI[sha256sum] = "8434fb226aa91880a749b2ac7ea7f30a8cc13f4f79f1ca165d0b40c619f8a875"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
