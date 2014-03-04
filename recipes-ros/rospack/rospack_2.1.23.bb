DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fd27ee7b35fb5d34be609bac35477306"
SRC_URI[sha256sum] = "b41cf1775a9216aa2c7604d8e293b7eb11f50d18b1722a491a4b800362c5d7ca"

inherit catkin

RDEPENDS_${PN} = "python-rosdep python-subprocess"
