DESCRIPTION = "This library contains wrappers for generating floating point values, integers, quaternions using boost libraries."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3602781cf42008fb1099191cec724b8a"
SRC_URI[sha256sum] = "d7af5b2dc47242be5622e059da6aa2d22c8eefd9ddcabba2e0d619608a0f532b"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
