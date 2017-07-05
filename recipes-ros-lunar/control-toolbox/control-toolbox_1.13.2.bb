DESCRIPTION = "The control toolbox contains modules that are useful across all controllers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole tf roscpp angles message-generation dynamic-reconfigure libtinyxml \
    realtime-tools message-filters ${PYTHON_PN}-rospkg"

SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "40bc1f04e5936b7fee824f6717702a62"
SRC_URI[sha256sum] = "270f9df4c8f64b629b873ada6dec202c90da24f3060c8e0e337e9e2528c29064"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
