DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost cmake-modules python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "878baf7283ffe32eb1429a175082be84"
SRC_URI[sha256sum] = "3487f24bd5362fa9a0c44b145543e13d7aa20bdb19d0477b7872d52a11bef914"

inherit catkin

RDEPENDS_${PN} = "python-rosdep python-subprocess"
