DESCRIPTION = "A generic, simple controller manager plugin for MoveIt."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "moveit-core actionlib control-msgs pluginlib roscpp"

require moveit.inc

SRC_URI_append = " file://0001-Fix-conversion-of-shared-ptr-to-bool-for-C-11.patch"

ROS_BPN = "moveit_plugins/moveit_simple_controller_manager"
