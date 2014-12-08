DESCRIPTION = "Pipes console_bridge output to rosconsole/rosout when console_bridge is used in a ROS-dependent package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole console-bridge"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "50738e1196c5530d9724b98749a19f31"
SRC_URI[sha256sum] = "0834456f97e97f30ed27a6a234dac4e829970bffc20b439f4fcf442f0ba04d0c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
