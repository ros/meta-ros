DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3a749efb13ee8e3dd498e0d536092eed"
SRC_URI[sha256sum] = "58ebd37d6b9fc39cf8a14da7951a52ec3f3bf038db417c34d2bac28130847b16"

inherit catkin
