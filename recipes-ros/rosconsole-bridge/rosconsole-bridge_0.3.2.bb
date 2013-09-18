DESCRIPTION = "Pipes console_bridge output to rosconsole/rosout when console_bridge is used in a ROS-dependent package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole console-bridge"

SRC_URI ="https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1bb1f0610d3624a34864f10d89f98b28"
SRC_URI[sha256sum] = "91db5a9f633c98d5169bbc5782ccbe6f4db93284872a224231edd98ba0a7d4d3"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
