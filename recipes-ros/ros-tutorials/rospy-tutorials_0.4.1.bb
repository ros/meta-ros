DESCRIPTION = "This package contains step-by-step tutorials written python for learning ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs cpp-common roscpp-serialization"

require ros-tutorials.inc

SRC_URI += "file://0001-rostest-is-optional.patch;striplevel=2"
