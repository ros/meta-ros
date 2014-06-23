DESCRIPTION = "Common-Lisp ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "03f0c73d79e35d4704289b18e4e4b6f2"
SRC_URI[sha256sum] = "c12ae21100b11635672c17bdeb165c17ae74bddf4ce8f9bc97711fed0eef9698"

inherit catkin
