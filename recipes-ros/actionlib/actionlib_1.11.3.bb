DESCRIPTION = "The actionlib stack provides a standardized interface for interfacing with \
preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d7b1b2b5cac0e1177171a56cc1e7187a"
SRC_URI[sha256sum] = "69f12ecb01b33a992d343c6fb306d678ea61bffda796e0648cd72085793ded32"

inherit catkin
