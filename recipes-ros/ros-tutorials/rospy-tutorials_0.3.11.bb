DESCRIPTION = "This package contains step-by-step tutorials written python for learning ROS"

SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation rostest std-msgs"

require ros-tutorials.inc
SRC_URI = "file://rospy-tutorials/0001-CMakeLists-patch-for-cross-compiling.patch;striplevel=2"



