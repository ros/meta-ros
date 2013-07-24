DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${BPN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "0bb1d12a115b7902d5b1f8546d63cdf8"
SRC_URI[sha256sum] = "43a7e64015c4e28fbfda071dcb9451a6ac0443df75242a32c23cfda68d230f93"

inherit catkin
