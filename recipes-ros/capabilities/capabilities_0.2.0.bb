DESCRIPTION = "Package which implements capabilities"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62135a7570582b9018c89013d4815380"

DEPENDS = "message-generation roslaunch rospy std-msgs std-srvs"

SRC_URI = "https://github.com/osrf/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0071ef2532612c7cc60c2b5a423d38d6"
SRC_URI[sha256sum] = "e55564dd82373139a4758d9d9e85d697bed6a0487c018774913e0f7069ce4024"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "bondpy message-runtime nodelet python-pyyaml roslaunch"
