DESCRIPTION = "This package contains step-by-step tutorials written python for learning ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation rostest std-msgs cpp-common roscpp-serialization"

require ros-tutorials.inc

SRC_URI += "https://github.com/ros/${ROS_SPN}/commit/1e559b3f811a6cf3daac59088d6d86ca1d31b261.patch;striplevel=2;name=patch"
SRC_URI[patch.md5sum] = "c9e4af54266205ad233acc064a456840"
SRC_URI[patch.sha256sum] = "838ad3cbe2da1c625a44af80c4351f1187478e6ec52adc1c535942337252a719"
