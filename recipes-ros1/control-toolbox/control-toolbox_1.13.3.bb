DESCRIPTION = "The control toolbox contains modules that are useful across all controllers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole tf roscpp angles message-generation dynamic-reconfigure libtinyxml \
    realtime-tools message-filters"

SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3df0a768373bdf0b6297a4246ef4885b"
SRC_URI[sha256sum] = "36d5df7dfc205be97672ed29dca80acf10c3a156966ce4d5ea84069ec6d5823f"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
