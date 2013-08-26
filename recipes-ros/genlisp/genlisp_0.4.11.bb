DESCRIPTION = "Common-Lisp ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg-native"

PR = "r2"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b9be0a57abf76187a1057fb62cdc31e1"
SRC_URI[sha256sum] = "cc373440fcbf57cafb758795cb50045fdd96de717b93d3d5956b7a1a2af4d3e2"

SRC_URI += "file://0001-resolve-genlisp-path-in-installspace-at-runtime.patch"

inherit catkin
