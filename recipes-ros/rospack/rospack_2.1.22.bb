DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "850cd0540a43889810f3c765fee7f28b"
SRC_URI[sha256sum] = "084d41eaddf96c57373e26c65baee1e81e5bf76207e3f49415e21478bf687a4c"

inherit catkin

RDEPENDS_${PN} = "python-rosdep python-subprocess"
