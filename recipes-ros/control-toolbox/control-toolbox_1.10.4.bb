DESCRIPTION = "The control toolbox contains modules that are useful \ 
across all controllers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole tf roscpp angles message-generation \
            dynamic-reconfigure libtinyxml realtime-tools message-filters"

SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "28f8bc6536401456b207e20b4de2e8b3"
SRC_URI[sha256sum] = "0fe2964d156f8bc1af89cca66007d46ef9c71cc2c4d34dfb0c7070c72b7141f6"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
