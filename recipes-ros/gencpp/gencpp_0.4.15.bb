DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "35f450e4cfd9a5ff5e8335eff97009ef"
SRC_URI[sha256sum] = "2e43f804cfb013f3598289fc9c890ff310edc176534c57add5f2bdf64547df66"

inherit catkin
