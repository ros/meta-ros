DESCRIPTION = "This package retrieves data from url-format files such as \
http://, ftp://, package:// file://, etc., and loads the data into memory."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "curl rosconsole roslib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1dffd39475ebe70b14390889d3b4b3c4"
SRC_URI[sha256sum] = "5f00e95c5a086973efa25e26da9cee8f4b10b446fbb5eb6694b32b2201539866"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "python-urlgrabber"
