DESCRIPTION = "The actionlib stack provides a standardized interface for \
  interfacing with preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp rostest"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d16d2369554d8060beb4369b61d3cc68"
SRC_URI[sha256sum] = "d0a5eac521832cf09ddff833d7c7965874e3a0bf837d9464c344f71147dabb4b"

inherit catkin
