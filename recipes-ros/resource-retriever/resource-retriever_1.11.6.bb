DESCRIPTION = "This package retrieves data from url-format files such as \
http://, ftp://, package:// file://, etc., and loads the data into memory."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "curl rosconsole roslib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8cf8f6a42ea7853a8c7b6aba4f0d3211"
SRC_URI[sha256sum] = "03e1d54d360273566539530328bdfa954a94e8f42effa7fff2ff7defbd0736ab"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "python-urlgrabber"
