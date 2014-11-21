DESCRIPTION = "A common repository for CMake Modules which are not \
distributed with CMake but are commonly used by ROS packages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "46c3190968bf5f2d4c05ba6424372e40"
SRC_URI[sha256sum] = "298a7f29e7bda94c2117f5cd8fcbe9cbf56f79c4328e036639bb5f417113165c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
