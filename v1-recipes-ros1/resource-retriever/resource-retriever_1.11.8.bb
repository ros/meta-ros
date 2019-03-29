DESCRIPTION = "This package retrieves data from url-format files such as \
http://, ftp://, package:// file://, etc., and loads the data into memory."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "curl rosconsole roslib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
           file://0001-Python3-compatibility-10.patch \
           "
SRC_URI[md5sum] = "cd1055502daeaf93985fb56327c419f4"
SRC_URI[sha256sum] = "db3ce752736123499d80d803526080e31f2ba21460fd135186b26bf7b72fed2a"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "${PYTHON_PN}-rospkg"
