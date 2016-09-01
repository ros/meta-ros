DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost cmake-modules python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6608b514bc7aff7e8350855369228cd8"
SRC_URI[sha256sum] = "e11d7aebc61c71fd4b3d1d6c775766d6d58573a79d5076d7f13595eeeeba0ad2"

inherit catkin

RDEPENDS_${PN} = "python-rosdep python-subprocess"
