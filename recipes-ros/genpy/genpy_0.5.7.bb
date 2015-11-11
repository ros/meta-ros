DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cade8bce4b6bd3b00999d9f4ab0e0de1"
SRC_URI[sha256sum] = "e45d05206d71a32e8e3e9d4a87e966aec716e54035b298723b5cb51db66bcab9"

inherit catkin

RDEPENDS_${PN} = "python-math genmsg python-shell"
RDEPENDS_${PN}_class-native = ""
