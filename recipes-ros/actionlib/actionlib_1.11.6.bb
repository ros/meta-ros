DESCRIPTION = "The actionlib stack provides a standardized interface for interfacing with \
preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "71c889328d63fa50c14c6fd0fe998447"
SRC_URI[sha256sum] = "697fb750b3494fcf28da7cc55ea8428bfd803d3faeac18f0296f1b5fa4d7920c"

inherit catkin
