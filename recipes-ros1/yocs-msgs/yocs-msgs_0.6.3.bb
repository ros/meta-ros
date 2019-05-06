DESCRIPTION = "Yujin's Open Control System messages, services and actions"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs std-msgs std-srvs geometry-msgs message-generation dynamic-reconfigure"

SRC_URI = "https://github.com/yujinrobot/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aa6d653e6f54fe01c7214008b67cadd2"
SRC_URI[sha256sum] = "df0d541cd0752e444965e52980ba999e5c47e3d455caa0362d4cf9d75be8cccc"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
