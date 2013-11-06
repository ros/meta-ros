DESCRIPTION = "Provides conversions from PCL data types and ROS message types"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "pcl-msgs pcl"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1cfba274d55c7e09d98ec8509240a682"
SRC_URI[sha256sum] = "9ac20bb51248e5c39f5aeccfaabbf2ed0a42130871f52f134dfcdfa03dac00ec"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
