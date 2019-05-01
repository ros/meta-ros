DESCRIPTION = "Xacro is an XML macro language."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roslint"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4f9bb02da14c161b8452b81f90791c34"
SRC_URI[sha256sum] = "e8ff4107470cecf1ac8c209cbcfcbb648ab489ee9a4a1665c17771a65ec7d93e"

inherit catkin
