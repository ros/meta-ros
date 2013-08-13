DESCRIPTION = "Package modeling the build-time dependencies for generating language bindings of messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "gencpp-native genlisp-native genmsg-native genpy-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b3086fbe24cc103f412cb30d83362e36"
SRC_URI[sha256sum] = "9ce9c5b4e995933c575f2a5cb5c4b042b39913637bca06554092a52c3bb24c12"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
