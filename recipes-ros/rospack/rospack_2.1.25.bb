DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3c152a2f6c39d205b373fa674b76244d"
SRC_URI[sha256sum] = "1eaf4139e4286c4bce85c152989a2081cc04020c038dcef8d8b36d98fbb3778c"

inherit catkin

RDEPENDS_${PN} = "python-rosdep python-subprocess"
