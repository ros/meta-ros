DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost python-native libtinyxml"

SRC_URI = "https://github.com/ros/${BPN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "1383bdce36fe6319884e7b158c22d8b4"
SRC_URI[sha256sum] = "5bfdcc93db555fe23dead5d471f8bba25dc72c2f0f928bd2319e06bf42f9d117"

inherit catkin
