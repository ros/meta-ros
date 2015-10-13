DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8bdfa8a618c124e297ac17091980d01d"
SRC_URI[sha256sum] = "4727b5c176e94abd3fa4c2f3ce2b2b6d84ca7cb638a8899202a495a0f416df85"

inherit catkin

RDEPENDS_${PN} = "python-math genmsg python-shell"
RDEPENDS_${PN}_class-native = ""
