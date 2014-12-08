DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6b1fe67407f9d49ebdd58cf53a125109"
SRC_URI[sha256sum] = "0e9e79f680b0cd6e10a34dbd3328079bf9d54c214453ca71653cd5683900ea4c"

inherit catkin

RDEPENDS_${PN} = "python-math genmsg python-shell"
RDEPENDS_${PN}_class-native = ""
