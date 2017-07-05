DESCRIPTION = "Pipes console_bridge output to rosconsole/rosout when console_bridge is used in a ROS-dependent package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole console-bridge"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eb8835cc4ca737ef7371f2149b17101a"
SRC_URI[sha256sum] = "6133c7fc466b4440973d459bde5fb3e1ef4352d4644060965b7fa289530921fc"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
