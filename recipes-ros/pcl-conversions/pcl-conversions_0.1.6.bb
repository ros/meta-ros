DESCRIPTION = "Provides conversions from PCL data types and ROS message types"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "pcl-msgs pcl roscpp"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a4317447dbd3da2bcd33d40db700b723"
SRC_URI[sha256sum] = "5664ef3877de7efed7215bb9320fad02d1c167a96f3ba8927727e607a5f6285c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
