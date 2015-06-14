DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost cmake-modules python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cb33ed17803998a42ad449c3cd3603e2"
SRC_URI[sha256sum] = "8602e21172ef453b63c6c6f1698c5ac81ec014b0a78bf98f31a60937dacee9ef"

inherit catkin

RDEPENDS_${PN} = "python-rosdep python-subprocess"
