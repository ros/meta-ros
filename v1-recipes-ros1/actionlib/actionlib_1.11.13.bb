DESCRIPTION = "The actionlib stack provides a standardized interface for interfacing with \
preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2a607a3455f5ea5908254bd65c9230c9"
SRC_URI[sha256sum] = "df635716bd65298aa443f86fb3578988af04f404c4a94ebc99ef61ac4c869e46"

inherit catkin

SRC_URI += "file://0001-Change-boost-posix_time-milliseconds-init-to-int64_t.patch"
