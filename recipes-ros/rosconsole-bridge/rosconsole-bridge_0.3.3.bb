DESCRIPTION = "Pipes console_bridge output to rosconsole/rosout when console_bridge is used in a ROS-dependent package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole console-bridge"

SRC_URI ="https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "baee1ae9061c360b0b68d550c0f345bb"
SRC_URI[sha256sum] = "30f69f79fbedd121263dc61825f799e13536b031872146dce653d0d4af42abd4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
