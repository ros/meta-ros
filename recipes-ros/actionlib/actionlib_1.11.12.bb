DESCRIPTION = "The actionlib stack provides a standardized interface for interfacing with \
preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f75eaec35fe5cc29c4af308afc34e29a"
SRC_URI[sha256sum] = "e600f0b3f15ab41992adb7e5e95b89a8df6b679c4eb4b7c0771bdb74ed4da623"

inherit catkin
